package automationExamples.calendarPackage;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;

public class CalendarExampleFour extends BaseTest {

	public static void main(String[] args) throws InterruptedException, ParseException {

		driver = initializeDriver("chrome-incognito");
		launchApplication("https://www.cleartrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		Thread.sleep(1000);

		try {
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='closeIcon']")).click();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		LocalDate today = LocalDate.now();
		System.out.println("today : " + today);

		LocalDate targetDate = today.plusDays(300);
		System.out.println("TargetDate : " + targetDate);

		int targetDay = targetDate.getDayOfMonth();

		String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // SEPTEMBER
	
		int targetYear = targetDate.getYear();
		System.out.println("targetDay : " + targetDay + " | " + "targetMonth : " + targetMonth + " | " +"targetYear : " + targetYear);

		WebElement datePicker = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='dateSelectOnward']")));
		datePicker.click();

		while (true) { // This is for Month Selection
			List<WebElement> monthInfo = driver
					.findElements(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']/div"));

			boolean monthFound = false;
			for (WebElement month : monthInfo) {
				String visibleMonthYr = month.getText();
				System.out.println("visibleMonthYr : " + visibleMonthYr);
				String[] combo = visibleMonthYr.split(" ");

				String visibleMonth = combo[0];
				System.out.println("visibleMonth : " + visibleMonth);

				int visibleYr = Integer.parseInt(combo[1]);
				System.out.println("visibleYr : " + visibleYr);

				if (visibleMonth.equalsIgnoreCase(targetMonth) && visibleYr == targetYear) {
					monthFound = true;
					break;
				}
			}

			if (monthFound) {
				break;
			} else {
				WebElement nextArrow = driver.findElement(By.cssSelector("svg[data-testid='rightArrow']"));
				nextArrow.click();
				Thread.sleep(2000);
			}
		}

		// Date Selection
//		List<WebElement> calendarDates = driver
//				.findElements(By.xpath("//div[contains(@class,'DayPicker-Day') and not (contains(@aria-disabled,'true'))]"));

		List<WebElement> calendarDates = driver.findElements(
				By.xpath("//div[contains(@class,'DayPicker-Day') and not (contains(@aria-disabled,'true'))]"));

		System.out.println("calendarDates : " + calendarDates.size());
		
		String targetMonthMMM = targetDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH); // MMM : SEP
		
		
		for (WebElement day : calendarDates) {

			String ariaLabel = day.getAttribute("aria-label");
			System.out.println("ariaLabel : " + ariaLabel);
			if (ariaLabel != null && ariaLabel.contains(targetMonthMMM) 
					&& ariaLabel.contains(String.valueOf(targetYear))) {
				
				String[] labels = ariaLabel.split(" ");
				System.out.println(labels[3]);
				int dayLabel = Integer.parseInt(labels[2]);
				System.out.println(dayLabel);
				if (dayLabel == targetDay) {
					day.click();
					break;
				}
			}
		}

//		for (WebElement day : calendarDates) {
//			String currentDay = day.getText();
//			int enterday = Integer.parseInt(currentDay);
//			System.out.println("day : " + Integer.parseInt(currentDay));
//
//			if (enterday == targetDay) {
//				day.click();
//				break;
//			}
//		}

		Thread.sleep(9000);
		quitDriver();

	}

}
