package automationExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest_Grid {

    // ThreadLocal to ensure thread safety for parallel execution
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser, String gridUrl) {
        WebDriver driver;
        boolean isRemote = gridUrl != null && !gridUrl.isEmpty();

        try {
            if (isRemote) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(mapBrowserName(browser));

                if (browser.toLowerCase().contains("chrome")) {
                    ChromeOptions options = createChromeOptions(browser);
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                }

                URL hubUrl = new URL(gridUrl);
                driver = new RemoteWebDriver(hubUrl, capabilities);
            } else {
              
                switch (browser.toLowerCase()) {
                    case "chrome":
                    case "chrome-incognito":
                    case "chrome-headless":
                        ChromeOptions options = createChromeOptions(browser);
                        driver = new ChromeDriver(options);
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "safari":
                        driver = new SafariDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            }


            driverThreadLocal.set(driver);
            return driver;

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Grid URL: " + gridUrl, e);
        }
    }

 
    public static WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "chrome");
        String gridUrl = System.getProperty("grid.url");
        return initializeDriver(browser, gridUrl);
    }


    private static String mapBrowserName(String browser) {
        String lower = browser.toLowerCase();
        if (lower.contains("chrome")) return "chrome";
        if (lower.contains("firefox")) return "firefox";
        if (lower.contains("edge")) return "MicrosoftEdge";
        if (lower.contains("safari")) return "safari";
        return lower;
    }

    private static ChromeOptions createChromeOptions(String browser) {
        ChromeOptions options = new ChromeOptions();


        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);

        options.addArguments(
                "--disable-features=PasswordLeakDetection,SafetyTip,AutofillServerCommunications",
                "--disable-notifications",
                "--disable-save-password-bubble",
                "--disable-infobars",
                "--password-store=basic"
        );

        String lower = browser.toLowerCase();
        if (lower.contains("incognito")) {
            options.addArguments("--incognito");
        }
        if (lower.contains("headless")) {
            options.addArguments("--headless=new", "--window-size=1920,1080");
        }

        return options;
    }

    public static void launchApplication(String url) {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            throw new IllegalStateException("Driver not initialized. Call initializeDriver() first.");
        }
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}