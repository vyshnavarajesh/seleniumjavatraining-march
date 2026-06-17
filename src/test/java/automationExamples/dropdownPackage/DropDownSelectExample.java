package automationExamples.dropdownPackage;

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
import org.openqa.selenium.support.ui.Select;

public class DropDownSelectExample {

	
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
			
			driver.get("https://demoqa.com/select-menu");
			driver.manage().window().maximize();
			
			WebElement drpDown = driver.findElement(By.id("oldSelectMenu"));
			
			Select s = new Select(drpDown);
			Thread.sleep(2000);
			s.selectByValue("2");
			Thread.sleep(2000);
			s.selectByVisibleText("Blue");
			Thread.sleep(2000);
			s.selectByIndex(5);
			
			driver.quit();


	}

}
