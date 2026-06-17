package automationExamples.windowsExamplePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class ModalExample  extends BaseTest{

	public static void main(String[] args) throws InterruptedException { // Modal window
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome");
		
		launchApplication("https://www.tutorialspoint.com/selenium/practice/modal-dialogs.php");
		
		driver.findElement(By.xpath("//button[@data-bs-target='#exampleModalSm']")).click();
		
		//Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='exampleModalSm']//div[@class='modal-body']")));
		
		System.out.println(modalText.getText());
		driver.findElement(By.xpath("//button[@data-bs-target='#exampleModalToggle2']")).click();
		
		Thread.sleep(1000);
		
		quitDriver();
		

	}

}
