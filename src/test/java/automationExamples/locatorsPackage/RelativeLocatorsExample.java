package automationExamples.locatorsPackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorsExample {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub

		if(browser.equalsIgnoreCase("Chrome"))
		{
			 
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.password_manager_leak_detection", false);
		    prefs.put("safebrowsing.enabled", false);
		    
		    options.setExperimentalOption("prefs", prefs);
		    options.addArguments("--disable-features=PasswordLeakDetection,SafetyTip,AutofillServerCommunications",
		    		"--disable-notifications",
		    		"--disable-save-password-bubble",
		    		"--disable-infobars",
		    		"--password-store=basic");
		        
					 
			driver = new ChromeDriver(options);
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
		}else
		{
			 driver = new EdgeDriver();
		}
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().fullscreen();
		
		// reference locators
		/*
		
		WebElement userName  = driver.findElement(By.id("user-name"));
		userName.sendKeys("HI");
		
		// identifying locator below
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(userName)).sendKeys("Thisispassword");
		*/
		
		
		WebElement pwd  = driver.findElement(By.id("password"));
		pwd.sendKeys("password");
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(pwd)).sendKeys("ThisisuserName");
		
		String pwdText = driver.findElement(RelativeLocator.with(By.tagName("div")).toRightOf(By.className("login_credentials"))).getText();
		System.out.println(pwdText);
		
		String userNames = driver.findElement(RelativeLocator.with(By.tagName("div")).toLeftOf(By.className("login_password"))).getText();
		System.out.println(userNames);
		
		//chaining of locators
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("user-name")).below(By.id("password"))).click();
		//System.out.println("Text :"+ text);
		
		
		System.out.println("font family of submit buton : "+ driver.findElement(By.id("login-button")).getCssValue("font-family"));
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
