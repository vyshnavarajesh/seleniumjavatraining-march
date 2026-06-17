package automationExamples.framesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import automationExamples.BaseTest;

	public class FrameExampleTwo extends BaseTest {

		public static void main(String[] args) throws InterruptedException {
		driver = initializeDriver("chrome");
			
			launchApplication("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");
			
			//click element in iFrame button
			WebElement iframe = driver.findElement(By.id("frame1"));
			//WebElement iframe = driver.findElement(By.name("frame1")); 
			
			driver.switchTo().frame(iframe);
			
			String link = driver.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(link);
		
			String headerText = driver.findElement(By.xpath("//h1[contains(text(),'New Tab')]//parent::div")).getText();
			
			System.out.println(headerText);
			Thread.sleep(2000);
			
			
			driver.switchTo().defaultContent(); // in order to click on elements in parent window or parent frames ; switch to default content
			driver.findElement(By.xpath("//a[@href='modal-dialogs.php']")).click();
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(5000);
			quitDriver();

		}

}
