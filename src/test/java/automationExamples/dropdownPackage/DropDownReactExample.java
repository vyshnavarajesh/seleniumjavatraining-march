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

public class DropDownReactExample {


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
		
		driver.findElement(By.id("state")).click();
		
		Thread.sleep(2000);
		
		// driver.findElement(By.xpath("//div[contains(text(),'Haryana')]")).click(); // hard coding the value 
		
		// debugger mode in screen : setTimeout(()=> {debugger;},4000)
		
		// driver.findElement(By.id("react-select-3-option-3")).click();
		
		List<WebElement> state = driver.findElements(By.xpath("//div[@id='react-select-3-listbox']//div"));
		
	/*	for(WebElement s : state)
		{
			System.out.println(s.getText());
		}
	*/
		for(int i=0; i< state.size();i++)
		{
			if(state.get(i).getText().equalsIgnoreCase("Haryana"))
			{
				state.get(i).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.quit();



	}

}
