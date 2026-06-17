package automationExamples.tablePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class TableExampleOne extends BaseTest {
	
	static String str = "RARE RABBIT Men Solid Casual";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver = initializeDriver("chrome-incognito");
	
		launchApplication("https://www.flipkart.com/rare-rabbit-men-solid-casual-white-shirt/p/itmbdde6a7e14889?pid=SHTHMAQYBRDP9QG2&lid=LSTSHTHMAQYBRDP9QG2IP2NOJ&marketplace=FLIPKART&q=rare+rabbit+shirt&store=clo%2Fash%2Faxc%2Fmmk%2Fkp7&srno=s_1_3&otracker=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_4_na_na_na&fm=search-autosuggest&iid=13ef7c0e-70eb-43d1-9d92-f4318f7dc852.SHTHMAQYBRDP9QG2.SEARCH&ppt=sp&ppn=sp&ssid=6c94r9towg0000001779068607341&qH=bcadd8b324d11ff7&ov_redirect=true");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Size Chart')]")));
		
		try {
			WebElement sizeChart = driver.findElement(By.xpath("//div[contains(text(),'Size Chart')]"));
			sizeChart.click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			driver.findElement(By.xpath("//div[contains(text(),'Size Chart')]")).click(); // fresh instance of identifying size chart element
		}
		
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(text(),'"+str+"')]//following-sibling::div//tr")));
		
		List<WebElement> header = driver.findElements(By.xpath("//h1[contains(text(),'"+str+"')]//following-sibling::div//th"));
		List<WebElement> rows = driver.findElements(By.xpath("//h1[contains(text(),'"+str+"')]//following-sibling::div//tr"));
		
		/*Printing header name */
		for(WebElement headerName : header) {
			System.out.print(headerName.getText() + " | ");
		}
		System.out.println(" ");
		
		/* getting all the data from table */
		for(int i=1; i<rows.size();i++) {
			List<WebElement> columns = driver.findElements(By.xpath("//h1[contains(text(),'"+str+"')]//following-sibling::div//tr["+i+"]/td")); // i = 4
			// List<WebElement> columns = rows.get(i).findElements(By.xpath("td")); // alternative way to identify columns
			for(WebElement col : columns) {
				System.out.print(col.getText() + " | ");
			}
			System.out.println(" ");
		}
		
		Thread.sleep(2000);
		
		quitDriver();
	}

}
