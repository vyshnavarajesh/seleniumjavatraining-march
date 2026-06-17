package automationExamples.dropdownPackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DropDownAutoSuggestionExample {

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
		
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 20).click().perform();
		
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).sendKeys("To");
		Thread.sleep(3000);
		
		List<WebElement> airport = driver.findElements(By.xpath("//div[@role='listbox']//ul"));
		
		/*
		 * for(WebElement a : airport)
		 * {
		 * 		a.getText().equalsIgnoreCase("Tokyo, JP - Narita (NRT)"))
		 * }
		 * 
		 */
		
		for(int i=0; i< airport.size();i++)
		{
			
			// System.out.println("airport list :" + airport.get(i).getText());
			if(airport.get(i).getText().contains("Tokyo, JP - Narita (NRT)"))
			{
				airport.get(i).click();
				break;
			}
		}
		
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
