package automationExamples.tablePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class TableExampleTwo extends BaseTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");

		launchApplication("https://www.tutorialspoint.com/selenium/practice/webtables.php#");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> rows = driver
				.findElements(By.xpath("//table[contains(@class,'table table-striped')]//tbody//tr")); // rows

		for (int i = 1; i <= rows.size() - 1; i++) {
			List<WebElement> cols = driver.findElements(
					By.xpath("//table[contains(@class,'table table-striped')]//tbody//tr[" + i + "]//td")); // columns

			String fname = cols.get(0).getText(); // column 1 in row 1
			System.out.println(fname);

			String lname = cols.get(1).getText(); // column 2 in row 1
			// System.out.println(fname);

			String email = cols.get(3).getText(); // column 3 in row 1
			System.out.println(email);

			if (fname.equalsIgnoreCase("Cierra") && email.equalsIgnoreCase("cierra@example.com")) {
				WebElement edit = driver.findElement(
						By.xpath("(//table[contains(@class,'table table-striped')]//tbody//tr["+i+"]//td[7]//a)[1]"));
				edit.click();

			WebElement modal = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//h5[@class='modal-title'])[2]"))));

				if (modal.isDisplayed()) {
					System.out.println(modal.getText());
				}

				break;
			}
		}
		Thread.sleep(2000);
		quitDriver();
	}

}
