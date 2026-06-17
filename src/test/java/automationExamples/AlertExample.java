package automationExamples;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AlertExample extends BaseTest{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome");
		
		launchApplication("https://demo.automationtesting.in/Alerts.html");
		
		//click on Alert button
		driver.findElement(By.id("OKTab")).click();
		
		Thread.sleep(2000);
		
		Alert alertOne = driver.switchTo().alert();
		alertOne.accept(); // OK button
		
		
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		Alert alertTwo= driver.switchTo().alert();
		System.out.println(alertTwo.getText()); // prinitng the text from alert 
		alertTwo.dismiss(); // Cancel button
		Thread.sleep(2000);
		String currentTxt = driver.findElement(By.cssSelector(".btn.btn-primary+p")).getText();
		
		if(currentTxt.contains("You Pressed Cancel"))
		{
			driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		}else
		{
			driver.findElement(By.id("OKTab")).click();
		}
		
		driver.findElement(By.cssSelector(".btn.btn-info")).click();
		Alert alertThree = driver.switchTo().alert();
		alertThree.sendKeys("From Automation script");
		
		Thread.sleep(3000);
		alertThree.accept();
		Thread.sleep(3000);
		quitDriver();

	}

}
