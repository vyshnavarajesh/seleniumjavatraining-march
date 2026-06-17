package automationExamples.locatorsPackage;

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

public class LocatorsCSSExample {

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
		
		driver.manage().window().maximize();
		
		//CSS selector - id & class
		// id => tagName#attributeVAlue  or  #attributeVAlue (value of ID) => eg : textarea#currentAddress (or) #currentAddress
		// className => tagName.className => eg : textarea.form-control (or) .form-control
		
		// className => tagName.className#IDAttributevalue 
		//multiple class Name => tagName.claaName1.className2
		
		// format of xpath vs css => xpath : //textarea[@id='currentAddress'] & css format =>  textarea[id='currentAddress']
		// xpath :  //textarea[@id='currentAddress' and @class='form-control'] vs css selector : textarea[id='currentAddress'][class='form-control']
		
		// contains in xpath vs cssselector (*) => tagName[attribute*='value'] => input[placeholder*='@']
		// starts-with in xpath vs cssselector (^) => tagName[attribute^='value'] => input[placeholder^='name']
		// ends the text in css : $  => tagName[attribute$='value'] => input[placeholder$='.com']
		
		
		//sibling(+)
		// Eg : input#hobbies-checkbox-1+label
		
		// first-of-type => ul.w3-ul>li:first-of-type
		// last-of-type => ul.w3-ul>li:last-of-type
		// nth-of-type => eg : ul.w3-ul>li:nth-of-type(5) (Try it : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_lists_border)
		
		// first-child => ul.w3-ul>li:first-child (Try it : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_lists_border)
		// last-child => ul.w3-ul>li:last-child (Try it : https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_lists_border)
		//nth-child : ul.w3-ul>li:nth-child(3)
		
		driver.findElement(By.cssSelector("textarea#currentAddress")).sendKeys("text Area example");
		
		Thread.sleep(3000);
		driver.quit();
	}

}
