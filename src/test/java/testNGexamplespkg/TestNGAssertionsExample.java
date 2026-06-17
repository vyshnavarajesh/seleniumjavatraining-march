package testNGexamplespkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationExamples.BaseTest;

public class TestNGAssertionsExample extends BaseTest{
	
	@Test(enabled=false)
	public void loginToSauceDemo() throws InterruptedException {
		
	String expectedTitle = "Swag Tests";
	String expectedproductHeader = "products";
	
	driver = initializeDriver("chrome-incognito");

	launchApplication("https://www.saucedemo.com/");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.findElement(new ByAll(By.id("user-name"),By.name("user-name"),
			By.xpath("//input[@placeholder='Username']"))).sendKeys("standard_user");
	
	driver.findElement(new ByIdOrName("password")).sendKeys("secret_sauce"); 
	
	driver.findElement(By.id("login-button")).click();
	
	String actualTitle = driver.getTitle();
	
	System.out.println(actualTitle);
	
	/*  This is not recommended as verification point, because both success / failed condition will mark test method  as pass
	if(actualTitle.contains(expectedTitle))
	{
		System.out.println("Passed");
	}else {
		System.out.println("Failed");
	} */
	
	
	Assert.assertEquals(actualTitle, expectedTitle);
	String actualproductHeader = driver.findElement(By.xpath("//div[@data-test='secondary-header']/span")).getText();
	Assert.assertEquals(actualproductHeader, expectedproductHeader,"Text Mismatch error");
	
	// Thread.sleep(1000);
	
	quitDriver();

	}
	
	@Test(enabled=false)
	public void loginToSauceDemowithSoftAssertion() throws InterruptedException {
		
		String expectedTitle = "Swag Tests";
		String expectedproductHeader = "inventory products";
		
		driver = initializeDriver("chrome-incognito");

		launchApplication("https://www.saucedemo.com/");
		
		SoftAssert softassertion = new SoftAssert();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//Additional locator example
		driver.findElement(new ByAll(By.id("user-name"),By.name("user-name"),
				By.xpath("//input[@placeholder='Username']"))).sendKeys("standard_user");
		
		driver.findElement(new ByIdOrName("password")).sendKeys("secret_sauce");
		
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
	
}
