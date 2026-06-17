package automationExamples.tablePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class TableExampleThree extends BaseTest {

	static String destination = "VR Headset";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");
		boolean found = false;
		
		launchApplication("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),'Pagination Web Table')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		// To get all the page numbers
		List<WebElement> pageNumbers = driver.findElements(By.cssSelector("#pagination a"));
		int pageNo = pageNumbers.size();
		System.out.println(pageNo);
		
		for(int i=1; i<=pageNo;i++) {
			
			WebElement pageLink = driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+i+"']"));
			System.out.println("index of i : "+ i);
			Thread.sleep(1000);
			pageLink.click();
			
			List<WebElement> rows = driver
					.findElements(By.xpath("//table[@id='productTable']//tbody//tr")); // rows
			
			for(WebElement row : rows) {
				
				WebElement cell = row.findElement(By.cssSelector("td:nth-child(2)")); // // xpath : //table[@id='productTable']//tbody//tr[i]//td[2]
				String name = cell.getText().trim();
				
				if(name.equalsIgnoreCase(destination)) {
					WebElement chkBox = row.findElement(By.cssSelector("td:nth-child(4) input[type='checkbox']")); // xpath : //table[@id='productTable']//tbody//tr[i]//td[4]//input[@type='checkbox']
					chkBox.click();
					found = true;
					break;
				}	
			}
			
			if(found)
			break;
		}
		
		Thread.sleep(4000);
		quitDriver();
	}

}
