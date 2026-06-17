package automationExamples.windowsExamplePackage;

import java.util.Set;

import org.openqa.selenium.By;

import automationExamples.BaseTest;

public class WindowHandlingExampleOne extends BaseTest{ // New Tab Handling

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome");
		
		launchApplication("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		
		System.out.println(driver.getWindowHandle()); // this will return current window ID (Parent)
		
		driver.findElement(By.xpath("//button[@title='New Tab']")).click();
		
		// to access the list of windows sing index => convert set to List => List<String> ll = new ArrayList<String>(windows);
		Set<String> windows = driver.getWindowHandles(); 
		System.out.println(windows);
		
		for(String w : windows)
		{
			driver.switchTo().window(w);
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		quitDriver();
	}

}
