package automationExamples.calendarPackage;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class CalendarExampleTwo extends BaseTest {

	static String inputDate = "08/15/2026"; // mm/dd/yyyy

	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");
		launchApplication("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Input Date format
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM d yyyy"); // output date format

		Date date = inputDateFormat.parse(inputDate);
		String formattedDate = outputDateFormat.format(date);

		System.out.println("formattedDate : " + formattedDate);

		String[] dates = formattedDate.split(" "); // May 27 2026
		String tgMonth = dates[0];
		String tgDate = dates[1];
		String tgYear = dates[2];
		System.out.println("Target Date : " + tgMonth + " " + tgDate + " " + tgYear);

		WebElement datePicker = driver.findElement(By.id("txtDate"));
		js.executeScript("arguments[0].scrollIntoView(true);", datePicker);

		// Type 1 : straight forward :
		// datePicker.sendKeys("05/31/2025");
		datePicker.click();

		WebElement monthDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		WebElement yrDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

		new Select(monthDropDown).selectByVisibleText(tgMonth);
		new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-year']")))).selectByVisibleText(tgYear);
		
		List<WebElement> calendarDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//a"));

		for (WebElement calendarDate : calendarDates) {
			if (calendarDate.getText().equals(tgDate)) {
				calendarDate.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		quitDriver();
	}

}
