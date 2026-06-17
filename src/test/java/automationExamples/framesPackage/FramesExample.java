package automationExamples.framesPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import automationExamples.BaseTest;

public class FramesExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
	driver = initializeDriver("chrome");
		
//		launchApplication("https://www.tutorialspoint.com/selenium/practice/frames.php");
//		
//		//click element in iFrame button
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//a[@href='/selenium/index.htm']")).click();
	
		launchApplication("https://practice-automation.com/iframes/");
		
		//click element in iFrame button
		driver.switchTo().frame("top-iframe");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/agent-cli/introduction']")).click();
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//a[@href='https://automatenow-courses.teachable.com/']")).click();
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(2000);
		quitDriver();

	}

}
