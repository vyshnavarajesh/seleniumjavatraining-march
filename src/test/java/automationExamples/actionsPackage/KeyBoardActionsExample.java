package automationExamples.actionsPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;

import automationExamples.BaseTest;

public class KeyBoardActionsExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException { // Keyboard Actions 
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");

		launchApplication("https://www.diffchecker.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions actions = new Actions(driver);
		actions.moveByOffset(10, 20).click().perform();
		
		String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<500;i++) {
			int index = (int) (Math.random()*ch.length());
			sb.append(ch.charAt(index));
		}
		
		
		
		driver.findElement(By.xpath("//div[@aria-label='Original text input']")).sendKeys(sb);
		Thread.sleep(1000);
		
		actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform(); // select the content
		actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform(); // copy the content
		
		//actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform(); // or alternatively use below code to switch to element
		driver.findElement(By.xpath("//div[@aria-label='Changed text input']")).click();
		
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform(); 
		//Zoom in 
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("=").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).build().perform();
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(10000);
		
		quitDriver();
	}

}
