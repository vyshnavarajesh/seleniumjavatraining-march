package automationExamples.FileReadWritePackage.excelpackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationExamples.BaseTest;
import automationExamples.Utility.ExcelUtility;

public class ExcelReadWriteExample extends BaseTest{
	
	private static final String EXCEL_PATH = System.getProperty("user.dir")+"\\testData\\saucedemotest.xlsx";
	private static final String SHEET_NAME = "Sheet1";
	
	private static final int USERNAME = 0;
	private static final int PASSWORD = 1;
	private static final int EXPECTEDRESULT = 2;
	private static final int ACTUALRESULT = 3;
	private static final int STATUS = 4;
			
	public static void main(String[] args) throws InterruptedException {
		
		ExcelUtility excel = new ExcelUtility(EXCEL_PATH);
		
		driver = initializeDriver("chrome-incognito");
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		
		int rowCount = excel.getRowCount(SHEET_NAME);
		System.out.println("Total rows in the excel : "+ rowCount);
		
		for(int i=1; i<=rowCount; i++) {
			
			String username = excel.getCellData(SHEET_NAME, i, USERNAME);
			String password = excel.getCellData(SHEET_NAME, i, PASSWORD);
			String expectedResult = excel.getCellData(SHEET_NAME, i, EXPECTEDRESULT);
			
			launchApplication("https://www.saucedemo.com/");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
			
			WebElement usernameField = driver.findElement(By.id("user-name"));
			usernameField.clear();
			usernameField.sendKeys(username);
			
			WebElement passwordField = driver.findElement(By.id("password"));
			passwordField.clear();
			passwordField.sendKeys(password);
			
			WebElement loginBtn = driver.findElement(By.id("login-button"));
			loginBtn.click();
			
			String actualResult;
			
			List<WebElement> errorElements = driver.findElements(By.cssSelector("[data-test='error']"));
			boolean hasError = !errorElements.isEmpty() && errorElements.get(0).isDisplayed();
			
			if(driver.getCurrentUrl().contains("inventory")) {
				actualResult="Login Success";
			}else if(hasError) {
				actualResult = errorElements.get(0).getText().trim();
			}else {
				actualResult = "unknown";
			}
			
			Thread.sleep(2000);
			
			boolean resultComparison = actualResult.equalsIgnoreCase(expectedResult);
			excel.setCellData(SHEET_NAME, i, ACTUALRESULT, actualResult);
			excel.setCellData(SHEET_NAME, i, STATUS, resultComparison ? "PASS":"FAIL");
			
			if(resultComparison) {
				excel.fillGreenColor(SHEET_NAME, i, STATUS);
			}else {
				excel.fillRedColor(SHEET_NAME, i, STATUS);
			}
			
			System.out.println("Expected result : "+ expectedResult);
			System.out.println("Actual result : "+ actualResult);
			
		}
		quitDriver();
		excel.close();
		
	}

}
