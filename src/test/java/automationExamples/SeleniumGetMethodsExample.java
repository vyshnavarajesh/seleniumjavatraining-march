package automationExamples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumGetMethodsExample {

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
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		System.out.println(driver.getTitle()); // page Title or it is title of Website
		
		// System.out.println(driver.getPageSource()); // entire pageSource
		
		driver.findElement(By.id("firstName")).sendKeys("This is firstname");
		Thread.sleep(500);
		driver.findElement(By.id("firstName")).clear();
		System.out.println("value of value attribute : " +driver.findElement(By.id("dateOfBirthInput")).getAttribute("value"));
		System.out.println("value of class attribute : " + driver.findElement(By.id("dateOfBirthInput")).getAttribute("class"));
		
		System.out.println("colour : " + driver.findElement(By.id("submit")).getCssValue("color"));
		
		System.out.println("this is size of an element : " + driver.findElement(By.id("submit")).getSize());
		System.out.println("this is location : " + driver.findElement(By.id("submit")).getLocation());
		System.out.println("this is firstName location : " + driver.findElement(By.id("firstName")).getLocation());
		
		System.out.println(driver.findElement(By.xpath("(//div[@class='header-text'])[2]")).getText()); // to get innertext
		
		System.out.println("Is displayed : " + driver.findElement(By.id("submit")).isDisplayed());
		System.out.println("Is button enabled : " + driver.findElement(By.id("submit")).isEnabled());
		Thread.sleep(1000);
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		System.out.println("Is check box selcted : " + driver.findElement(By.id("hobbies-checkbox-1")).isSelected());
		Thread.sleep(1000);
		
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		System.out.println("Is check box selcted : " + driver.findElement(By.id("hobbies-checkbox-1")).isSelected());
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle()); // current window ID
		System.out.println(driver.getWindowHandles()); // [A12E17B80D67FD1731DE9842F0634B0B, A12E17B80D67FD1731DE321432434B0B]
		
		driver.quit();
	}
}
