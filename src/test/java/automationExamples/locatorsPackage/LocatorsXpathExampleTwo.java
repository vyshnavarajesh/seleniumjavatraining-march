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

public class LocatorsXpathExampleTwo {

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
		
		// starts-with => //tagName[starts-with(@attribute,'value')] =>  //input[starts-with(@placeholder,'Username')] 
		
		//contains =>  //tagName[contains(@attribute,'value')] => driver.findElement(By.xpath("//input[contains(@placeholder,'First Name')]")).sendKeys("TestUser");
		
		// text() => //tagName[text()='value'] or //tagName[contains(text(),'Value')] => 	driver.findElement(By.xpath("//label[text()='Sports']")).click();
		/*
			boolean bd = driver.findElement(By.xpath("//div[@class='element-group']//div[contains(text(),'Interactions')]")).isDisplayed();
			System.out.println(bd);
		*/
		
		// and & or operation in xpath
		// //tagName[@attribute='value' and @attribute='value']
		// //tagName[@attribute='value' or @attribute='value'] = > driver.findElement(By.xpath("//textarea[@placeholder='Current Address' or @id='currentAddress']")).sendKeys("This is text area");
		
		// xpath - axes
		
		// ex : //tagName[@attribute,'value']//parent::tagName => //label[contains(text(),'Sports')]//parent::div
		// ex : //tagName[@attribute,'value']//child::tagName => //div[@id='hobbiesWrapper']//child::div[@class='form-check form-check-inline']
		// ex : //tagName[@attribute,'value']//self::tagName
		
		
		// ex : //tagName[@attribute,'value']//ancestor::tagName => //label[contains(text(),'Sports')]//ancestor::div[@id='hobbiesWrapper']
		// ex : //tagName[@attribute,'value']//ancestor-or-self::tagName
		// ex : //tagName[@attribute,'value']//descendant::tagName => //div[@id='hobbiesWrapper']//descendant::label[contains(text(),'Sports')]
		// ex : //tagName[@attribute,'value']//descendant-or-self::tagName
		
		
		// ex : //tagName[@attribute,'value']//following::tagName => //label[contains(text(),'Sports')]//following::input[@id='hobbies-checkbox-3']
		// ex : //tagName[@attribute,'value']//following-sibling::tagName => //input[@id='hobbies-checkbox-1']//following-sibling::label
		// ex : //tagName[@attribute,'value']//preceding::tagName => //label[contains(text(),'Sports')]//preceding::input[@id='gender-radio-1']
		// ex : //tagName[@attribute,'value']//preceding-sibling::tagName => //label[contains(text(),'Sports')]//preceding-sibling::input
		
		
		// instead of index value => last()
		
		Thread.sleep(5000);
		driver.quit();
	
	}

}
