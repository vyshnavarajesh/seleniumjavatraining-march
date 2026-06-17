package automationExamples.seleniumWaitPackage;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class SeleniumExplicitWaitExample  extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
		launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/* Explicit wait */
		/* 
		 * Explicit wait is preferred because it allows waiting for specific conditions like visibility or clickability
		 * we usually keep implicit wait to very minimal and rely mainly on explicit waits to make tests stable and predictable
		 */

		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(userName)).sendKeys("Admin");
		
		
		/* Fluent Wait */
		
		/* It is customized version of explicit wait where we can control polling interval, timeout, and exception handling
		 */

		  Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(30))
	       .pollingEvery(Duration.ofSeconds(5L))
	       .ignoring(NoSuchElementException.class);
		
		 WebElement password = fluentwait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//input[@placeholder='Password']"));
		     }
		   });
		 password.sendKeys("admin123"); 
		
		/*
		By password = By.xpath("//input[@placeholder='Password']");
		sendKeys(driver,password,30,"admin123");
		*/
		 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		quitDriver();
}
	
	/* Best usage of explicit wait */
	public static void sendKeys(WebDriver driver, By locator, long timeOut, String val) {
	
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		WebElement element = wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(val);
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, long timeOut, String val) {
		
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		 wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.visibilityOf(element));
		 element.clear();
		element.sendKeys(val);
	}
	
	public static void click(WebDriver driver, By locator, long timeOut) {
		
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		WebElement element = wait.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		
		element.click();
	}

	
}

