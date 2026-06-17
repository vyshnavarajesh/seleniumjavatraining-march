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

public class LocatorsXpathExample {

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
		
		driver.manage().window().maximize();
		
		// driver.findElement(By.xpath("//input[starts-with(@placeholder,'Username')]")).sendKeys("standard_user");
		
		// Absolute xpath : /html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input
		
		// Relative xpath : //tagName[@attribute='value'] => UserName xpath : //input[@data-test='username'] (or) //*[@data-test='username'] 
		// We can use multiple attributes in Xpath => //tagName[@attribute='value'][@attribute='value'] =>  //input[@class='input_error form_input'][@placeholder='Password']
		// Index in xpath => (//input[@class='input_error form_input'])[2]
		
		
		// starts-with => //tagName[starts-with(@attribute,'value')] =>  //input[starts-with(@placeholder,'Username')] 
		
		//contains =>  //tagName[contains(@attribute,'value')]
		
		driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("password");
		Thread.sleep(5000);
		driver.quit();
	
	}

}
