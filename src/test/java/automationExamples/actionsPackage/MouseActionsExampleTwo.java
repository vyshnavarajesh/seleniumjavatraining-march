package automationExamples.actionsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import automationExamples.BaseTest;

public class MouseActionsExampleTwo extends BaseTest {

	public static void main(String[] args) throws InterruptedException { // Mouse Hover
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");

		launchApplication("https://www.tutorialspoint.com/selenium/practice/droppable.php");

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement tg = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//actions.clickAndHold(src).release(tg).build().perform();
		
		actions.dragAndDrop(src, tg).build().perform();

		Thread.sleep(4000);
		quitDriver();

	}

}
