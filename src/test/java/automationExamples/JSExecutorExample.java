package automationExamples;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class JSExecutorExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
		launchApplication("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		Actions act = new Actions(driver);
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // Scroll from Top to bottom
		act.pause(Duration.ofSeconds(2L)).perform(); // Using it to pause the execution instead of Thread.sleep
		
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // Scroll from Bottom to top
		act.pause(Duration.ofSeconds(2L)).perform();
		
		System.out.println("Title of the page : " + js.executeScript("return document.title;").toString());
		System.out.println("current url of the page : " + js.executeScript("return document.URL;").toString());

		WebElement element = driver.findElement(By.id("draggable"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		act.pause(Duration.ofSeconds(2L)).perform();
		js.executeScript("arguments[0].style.border='3px solid red'",element);
		act.pause(Duration.ofSeconds(2L)).perform();
		
		// js.executeScript("history.go(0)"); // refresh 
		/* history.go(-1) // go back to previous page
		  history.go(1) // forward to the next page
		  */
		
		
		js.executeScript("document.body.style.zoom='160%'");
		act.pause(Duration.ofSeconds(2L)).perform();
		
		js.executeScript("document.body.style.zoom='50%'");
		act.pause(Duration.ofSeconds(2L)).perform();
		
		js.executeScript("document.body.style.zoom='100%'");
		act.pause(Duration.ofSeconds(2L)).perform();
		
		WebElement singleFileUpload = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		js.executeScript("arguments[0].click();",singleFileUpload);
		String file = System.getProperty("user.dir")+ "\\NewTestFile.txt";
		singleFileUpload.sendKeys(file);
		
		WebElement multiFileUpload = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		js.executeScript("arguments[0].click();",multiFileUpload);
		String file1 = System.getProperty("user.dir")+ "\\NewTestFile.txt";
		String file2 = System.getProperty("user.dir")+ "\\NewTestFileTwo.txt";
		multiFileUpload.sendKeys(file1 +"\n" + file2);
		
		act.pause(Duration.ofSeconds(5L)).perform();
	
		quitDriver();

	}

}
