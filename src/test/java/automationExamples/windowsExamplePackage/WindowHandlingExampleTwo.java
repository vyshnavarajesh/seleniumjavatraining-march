package automationExamples.windowsExamplePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import automationExamples.BaseTest;

public class WindowHandlingExampleTwo extends BaseTest{ // New Window Handling

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome");
		
		launchApplication("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		
		System.out.println(driver.getWindowHandle()); // this will return current window ID (Parent)
		
		driver.findElement(By.xpath("//button[contains(text(),'New Window Message')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next(); // pointing to parent
		System.out.println("parent Window : "+ parentWindow);
		
		String childWindow = it.next(); // pointing to child (can be a new tab or new window)
		System.out.println("child Window : "+ childWindow);
		
//		String childWindow2 = it.next(); // pointing to child
//		System.out.println("child Window : "+ childWindow);
		
		System.out.println("Before Switching to child window :" + driver.getCurrentUrl());
		System.out.println("Before Switching to child window getting the current Title :" + driver.getTitle());
		
		driver.switchTo().window(childWindow);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("After Switching to child window :" + driver.getCurrentUrl());
		System.out.println("After Switching to child window getting the current Title :" + driver.getTitle());
		
		if(driver.getPageSource().contains("New Window Message"))
		{
			System.out.println("Test Passed");
			System.out.println(driver.findElement(By.xpath("//main//div[@class='container']//child::div")).getText());
		}else {
			System.out.println("Test Failed");
		}
		Thread.sleep(2000);
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//button[contains(text(),' Widgets')]")).click();
		Thread.sleep(2000);
		System.out.println("After Switching back to parent window :" + driver.getCurrentUrl());
		Thread.sleep(2000);
		quitDriver();
		
	}

}
