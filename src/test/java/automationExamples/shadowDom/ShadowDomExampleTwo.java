package automationExamples.shadowDom;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;
import automationExamples.Utility.JavaScriptUtils;

public class ShadowDomExampleTwo extends BaseTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		/* Validating shadow root */
		driver = initializeDriver("chrome-incognito");
		
		JavaScriptUtils jsutil = new JavaScriptUtils(driver);
		JavascriptExecutor js =  (JavascriptExecutor) driver;
	
		launchApplication("https://selectorshub.com/iframe-in-shadow-dom/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		SearchContext parent = driver.findElement(By.cssSelector("div#userName")).getShadowRoot();
		parent.findElement(By.cssSelector("input[title='user name field']")).sendKeys("test");
		
		Thread.sleep(1000);
		
		WebElement ele = parent.findElement(By.cssSelector("iframe#pact1"));
		driver.switchTo().frame(ele);
		
		driver.findElement(By.cssSelector("input[placeholder='Current Crush Name']")).sendKeys("crushed");
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		
		SearchContext closedroot = parent.findElement(By.cssSelector("div#concepts")).getShadowRoot();
		
		System.out.println(closedroot.findElement(By.cssSelector("input#training")).getAttribute("placeholder"));
		quitDriver();
	}

}

