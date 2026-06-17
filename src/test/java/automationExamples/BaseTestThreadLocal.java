package automationExamples;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BaseTestThreadLocal {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver initializeDriver(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			prefs.put("safebrowsing.enabled", false);

			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-features=PasswordLeakDetection,SafetyTip,AutofillServerCommunications",
					"--disable-notifications", "--disable-save-password-bubble", "--disable-infobars",
					"--password-store=basic");

			driver.set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("Chrome-incognito")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			prefs.put("safebrowsing.enabled", false);

			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-features=PasswordLeakDetection,SafetyTip,AutofillServerCommunications",
					"--disable-notifications", "--disable-save-password-bubble", "--disable-infobars", "--incognito",
					"--password-store=basic");

			driver .set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver .set(new FirefoxDriver());
		} else if(browser.equalsIgnoreCase("safari")){
			SafariOptions options = new SafariOptions();
			options.setUseTechnologyPreview(true); 
			driver.set(new SafariDriver());
		}
		else {
			driver.set(new EdgeDriver());
		}

		return getDriver();

	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void launchApplication(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}
	

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}
	
	

}
