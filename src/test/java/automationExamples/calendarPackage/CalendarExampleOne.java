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
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class CalendarExampleOne extends BaseTest {

	static String inputDate = "03/30/2026"; // mm/dd/yyyy

	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub

		driver = initializeDriver("chrome-incognito");
		launchApplication("https://testautomationpractice.blogspot.com/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		SimpleDateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Input Date format
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMMM d yyyy"); // output date format

		inputDateFormat.setLenient(false);
		Date date = null;

		try {
			date = inputDateFormat.parse(inputDate);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			return;
		}

		String formattedDate = outputDateFormat.format(date);
		String[] dates = formattedDate.split(" "); // May 27 2026
		String tgMonth = dates[0];
		String tgDate = dates[1];
		String tgYear = dates[2];

		System.out.println("Target Date : " + tgMonth + " " + tgDate + " " + tgYear);
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		js.executeScript("arguments[0].scrollIntoView(true);", datePicker);

		// Type 1 : straight forward :
		// datePicker.sendKeys("05/31/2025");
		datePicker.click();

		while (true) {

			String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText(); // May 2026 June																					// 2026
			String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			if (currentMonth.equals(tgMonth) && currentYear.equals(tgYear)) {
				break;
			}

			int currentYr = Integer.parseInt(currentYear);
			int targetYr = Integer.parseInt(tgYear);

			int currentMonthNum = new SimpleDateFormat("MMMM").parse(currentMonth).getMonth(); // month in number format
			int targetMonthNum = new SimpleDateFormat("MMMM").parse(tgMonth).getMonth();

			if (currentYr > targetYr || (currentYr == targetYr && currentMonthNum > targetMonthNum)) {
				driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
			} else {
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}

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
