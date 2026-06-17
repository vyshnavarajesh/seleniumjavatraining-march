package automationExamples.shadowDom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;
import automationExamples.Utility.JavaScriptUtils;

public class ShadowDomExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		/* Property file reading */
		/* FileInputStream => is  to read the data to file */
		/* FileOutputStream => is  to Write the data to file */
		
		FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\testData\\local.properties"); // Trying to read the data from local.properties 
		Properties p = new Properties();
		p.load(f);
		
		String browser = p.getProperty("browserName"); /// Here browserName is Key : value it holds is "firefox"
		System.out.println("browser : "+ browser);
		

		/* Validating shadow root */
		driver = initializeDriver(browser);
		
		JavaScriptUtils jsutil = new JavaScriptUtils(driver);
	
		launchApplication("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement wb = driver.findElement(By.xpath("//h2[contains(text(),'ShadowDOM')]"));
		jsutil.jsScrollToElement(wb);
		
		SearchContext shadowparentrootelement = driver.findElement(By.cssSelector("div#shadow_host")).getShadowRoot();
		
		System.out.println(shadowparentrootelement.findElement(By.cssSelector("span#shadow_content")).getText());
		shadowparentrootelement.findElement(By.cssSelector("input[type='checkbox']")).click();
		
		// Getting in to Nested root
		SearchContext nestedrootelement = shadowparentrootelement.findElement(By.cssSelector("div#nested_shadow_host")).getShadowRoot();
		System.out.println("Getting the nested shadow element : " + nestedrootelement.findElement(By.cssSelector("div#nested_shadow_content")).getText());

		Thread.sleep(2000);
		quitDriver();
	}

}
