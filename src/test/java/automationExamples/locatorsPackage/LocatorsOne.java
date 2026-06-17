package automationExamples.locatorsPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

public class LocatorsOne {

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
		
		// one way to define the locators
		By uname = By.id("user-name");
		driver.findElement(uname).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("submit-button")).click();
		Thread.sleep(1000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total links :" + links.size());
		
		List<WebElement> img = driver.findElements(By.tagName("img"));
		System.out.println("total img :" + img.size());
		
		System.out.println("-------------------------------------------");
		
		// driver.findElement(By.linkText("LinkedIn")).click();
		// driver.findElement(By.partialLinkText("Face")).click();
		
		int valid = 0, skip=0, broken =0; 
		
		for(WebElement link : links) {
			String href = link.getAttribute("href");
			
			if(href == null || href.isEmpty() || href.equals("#"))
			{
				System.out.println("skipped | "+ href);
				skip++;
				continue;
			}
			
			
			HttpURLConnection con = (HttpURLConnection) new URL(href).openConnection();
			con.setRequestMethod("HEAD");
			con.setConnectTimeout(5000);
			
			con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/147.0.0.0 Safari/537.36");
			con.connect();
			
			int responseCode = con.getResponseCode();
			
			if(responseCode >= 400 || responseCode >= 500) {
				System.out.println("Broken link response code : " + responseCode + " link reference ==> "+ href);
				broken++;
			}else
			{
				System.out.println("Valid link response code : " + responseCode + " link reference ==> "+ href);
				valid++;
			}
			
			con.disconnect();
			
		}
		
		System.out.printf("Total links found valid => %d , broken =>  %d , skip =>  %d ",valid,broken,skip);
		//Thread.sleep(1000);
		driver.quit();
		
		
	}

}
