package testNGexamplespkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationExamples.BaseTest;

public class TestNGDataProviderExample extends BaseTest{
	
	public static WebDriver driver;
	
	@Test(dataProvider="credentials",description = "Verification of different valid login & Password")
	public void loginToSauceDemowithDataProvider(String userName,String Password) throws InterruptedException {
		
		String expectedTitle = "Swag Labs";
		String expectedproductHeader = "Products";
		
		driver = initializeDriver("safari");

		launchApplication("https://www.saucedemo.com/");
		
		SoftAssert softassertion = new SoftAssert();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(new ByAll(By.id("user-name"),By.name("user-name"),
				By.xpath("//input[@placeholder='Username']"))).sendKeys(userName);
		
		driver.findElement(new ByIdOrName("password")).sendKeys(Password);
		
		driver.findElement(By.id("login-button")).click();
		
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		
		softassertion.assertEquals(actualTitle, expectedTitle);
		
		String actualproductHeader = driver.findElement(By.xpath("//div[@data-test='secondary-header']/span")).getText();
		softassertion.assertEquals(actualproductHeader, expectedproductHeader,"Text Mismatch error");
		
		quitDriver();
		softassertion.assertAll();
		// Thread.sleep(1000);
		}
	
	@DataProvider(name="credentials") // This is at method
	public Object[][] validCredentials(){
		
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"}
		};
		
	}
	


}
