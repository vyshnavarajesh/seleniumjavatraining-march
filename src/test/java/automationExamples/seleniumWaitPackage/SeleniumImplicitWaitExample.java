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

public class SeleniumImplicitWaitExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
		launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Thread.sleep(1000); //static wait
		
		
		/* pageLoadTimeout (not implicit wait) */
		/*
		1. It sets the maximum time Selenium waits for a page to fully load before throwing a TimeoutException.
		2. Triggered as soon as driver.get() is called => Scope of this is  @ page-level
		3. Does not guarantee element is loaded 
		 */
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		
		/*  implicitlyWait() - Usage to be limited to -  Base Setup */
		/*
		 1. It Will wait for element to appear in DOM ; proceed further if element is found early
		 2. triggered as soon as driver.findlement() or driver.findElements is called ;  Applies globally to all findElement / findElements calls.
		 3. Scope of this is at element-level
		 
		 4. It does NOT wait for actions like: click() ; submit() ;sendKeys()
		 5. It also does NOT handle conditions like: element is clickable; element is visible; element is enabled; page stability etc;
			
		*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // It tells Selenium to poll the DOM for up to 10 seconds when trying to find elements.
		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin"); // Implicit wait applies to findElement; Once the element is found sendKeys() is executed immediately
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123"); 
		
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		// If the button exists in DOM & the element is not clickable yet, implicit wait doesn't help
		// solution for the above issue is Explicit Wait => refer SeleniumExplicitWaitExample
		
		Thread.sleep(50000);
		quitDriver();
}

}
