package automationExamples.tablePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class TableExampleFour extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");
		launchApplication("https://tabulator.info/examples/6.4");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		By dismissNotify = By.xpath("//a[@id='notify']//i[@id='notify-dismiss']");
		wait.until(ExpectedConditions.elementToBeClickable(dismissNotify));
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", dismissNotify);
		driver.findElement(dismissNotify).click();

		WebElement fittodata = driver.findElement(By.xpath("//h2//a[@id='fittodata' and @href='#fittodata']"));
		js.executeScript("arguments[0].scrollIntoView(true);", fittodata);
		
		wait.until(ExpectedConditions.
				presenceOfElementLocated(By.xpath("//a[contains(text(),'Fit To Data')]//parent::h2//following-sibling::div[@id='example-table-fittodata']")));
		
		List<WebElement> rows = driver.findElements(By.xpath("(//a[contains(text(),'Fit To Data')]//parent::h2//following-sibling::div[@id='example-table-fittodata']//div[@role='rowgroup'])[2]//div[@role='row']"));
		
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.cssSelector("div.tabulator-cell"));
			
			for(int i=0; i<cells.size();i++) {
				System.out.print(cells.get(i).getText());
				System.out.print(" | ");
			}
			System.out.println(" ");
		} 
		
		Thread.sleep(5000);
		quitDriver();

	}

}
