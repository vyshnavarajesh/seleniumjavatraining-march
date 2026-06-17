package automationExamples.actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import automationExamples.BaseTest;

public class MouseActionsExampleThree extends BaseTest {

	public static void main(String[] args) throws InterruptedException { // Mouse Hover
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");

		launchApplication("https://testautomationpractice.blogspot.com/");

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		
		WebElement min = driver.findElement(By.xpath("(//div[@id='slider-range']//span)[1]"));
		
		WebElement max = driver.findElement(By.xpath("(//div[@id='slider-range']//span)[2]"));
		
		//actions.moveToElement(min).perform(); // JavascriptExecutor
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='widget-content']//input[@id='comboBox']"))).perform();
		
		// actions.dragAndDrop(src, tg).build().perform();
		
		System.out.println("slider 1 location : "+ min.getLocation()); //(1167, 2019)
		System.out.println("slider 2 location : "+ max.getLocation()); // (1296, 2019)
		
		actions.dragAndDropBy(min, 50, 0).build().perform(); // moving the left side slider by +50
		System.out.println("slider 1 location updated : "+ min.getLocation()); // (1216, 2019)
		System.out.println("slider 2 location updated : "+ max.getLocation()); // (1296, 2019)
		
		actions.dragAndDropBy(max, -30, 0).build().perform(); // moving the right side slider by -50
		System.out.println("slider 1 location new updated : "+ min.getLocation()); // (1216, 2019)
		System.out.println("slider 2 location new updated : "+ max.getLocation()); // (1296, 2019)
		
		Thread.sleep(2000);
		
		WebElement copyText = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
		actions.moveToElement(driver.findElement(By.xpath("//input[@value='Hello World!']"))).perform();
		Thread.sleep(2000);
		actions.doubleClick(copyText).perform();
		
		Thread.sleep(2000);
		actions.contextClick().perform(); // rightClick
		

		Thread.sleep(4000);
		quitDriver();

	}

}

