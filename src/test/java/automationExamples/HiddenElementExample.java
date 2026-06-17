package automationExamples;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class HiddenElementExample extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
		launchApplication("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement hiddenElement = driver.findElement(By.id("input2"));
		System.out.println("initial value : "+ hiddenElement.getAttribute("value"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('input2').value='text msg';"); // take care of data entry to hidden 
		System.out.println("new value : "+ hiddenElement.getAttribute("value"));
		quitDriver();

	}

}
