package automationExamples.calendarPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class CalendarExampleThree extends BaseTest {

	static String inputstartDate = "03/01/2026"; // mm/dd/yyyy
	static String inputendDate = "09/01/2026"; // mm/dd/yyyy

	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");
		launchApplication("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Input Date format
		SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // output date format
		
		String htmlStartDate = targetDateFormat.format(inputDateFormat.parse(inputstartDate));
		String htmlEndDate = targetDateFormat.format(inputDateFormat.parse(inputendDate));
		
		WebElement datePicker = driver.findElement(By.xpath("//div[@class='date-picker-box']"));
		js.executeScript("arguments[0].scrollIntoView(true);", datePicker);
		
		WebElement startDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start-date")));
		js.executeScript("arguments[0].value= arguments[1];", startDate,htmlStartDate);
		
		WebElement endDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("end-date")));
		js.executeScript("arguments[0].value= arguments[1];", endDate,htmlEndDate);
		
		driver.findElement(By.xpath("//button[@class='submit-btn']")).click();
		
		System.out.println("result :"+ driver.findElement(By.xpath("//div[@id='result']")).getText());
		
		Thread.sleep(5000);
		quitDriver();
		
	}

}
