package automationExamples.actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import automationExamples.BaseTest;

@SuppressWarnings("unused")
public class MouseActionsExampleOne extends BaseTest{

	public static void main(String[] args) throws InterruptedException { // Mouse Hover
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
	/*	launchApplication("https://www.cleartrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("svg[data-testid='closeIcon']")).click();
		
		Actions act = new Actions(driver);
		WebElement business = driver.findElement(By.xpath("//p[contains(text(),'Business') and @cursor='pointer']"));
		
		act.moveToElement(business).build().perform();
		// build will create an action => It makes sense to use build, when you are working with Key functions (copy / paste / select All etc.,) 
		// moving to an element
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h2[contains(text(),'OutOfOffice')]")).click();
		Thread.sleep(4000);
		quitDriver();
		
*/

		launchApplication("https://www.flipkart.com/");
		
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 20).click().perform();
		
		driver.findElement(By.xpath("//a[@href='/account/login?ret=/']")).click();
		
		actions.moveToElement(driver.findElement(By.xpath("//div//span[contains(text(),'Electronics')]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@title='Gaming Laptops']")).click();
	
		Thread.sleep(4000);
		quitDriver();
		
	}

}


// Mouse Hover Actions
// Drag & Drop
// right click
// double click
// click somewhere in my screen 
// scroll to some element in my page
// zoom in zoom out
// tooltip