package testNGexamplespkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import automationExamples.BaseTest;
import automationExamples.BaseTestThreadLocal;

public class TestNGParallelExampleChrome_Safari extends BaseTestThreadLocal{
	
	public static WebDriverWait wait;
	private String browser;
	
	private static final String url = "https://www.saucedemo.com/";
	//private static final String errorMessage = "Epic sadface: Username is required";
	
	private static final By username_field = By.id("user-name");
	private static final By password_field = By.id("password");
	private static final By loginBtn = By.id("login-button");
	private static final By errorMsg = By.cssSelector("[data-test='error']");
	private static final By  productsTitle = By.xpath("//div[@data-test='secondary-header']/span");
	
	
	/*
	@FindBy(id="user-name")
	WebElement usernamefield;
	
	@FindBy(xpath="password")
	WebElement passwordfield;
*/
	
	
	private void login(String usernameData, String PasswordData) {
		WebElement userName= getDriver().findElement(username_field);
		userName.clear();
		userName.sendKeys(usernameData);
		WebElement password = getDriver().findElement(password_field);

		password.clear();
		password.sendKeys(PasswordData);
		
		getDriver().findElement(loginBtn).click();
	}
	
	@BeforeMethod
	@Parameters("browser") 
	public void setup(String browser) {
		this.browser =browser;
		System.out.println("Initialized browser :"+ browser);
		initializeDriver(browser);
		launchApplication(url);
		wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		quitDriver();
	}
	
	@Test(dataProvider="credentials",description = "Verification of different valid login & Password",enabled=true)
	public void loginToSauceDemowithDataProvider(String userName,String Password) throws InterruptedException {
		
		String expectedTitle = "Swag Labs";
		String expectedproductHeader = "Products";
		SoftAssert softassertion = new SoftAssert();

		login(userName,Password);
		
		String actualTitle = getDriver().getTitle();
		System.out.println(actualTitle);
		
		softassertion.assertEquals(actualTitle, expectedTitle);
		String actualproductHeader = getDriver().findElement(productsTitle).getText();
		softassertion.assertEquals(actualproductHeader, expectedproductHeader,"Text Mismatch error");
		
		softassertion.assertAll();
		Thread.sleep(1000);
		}
	
	@Test(dataProvider="invalidcredentials",description = "Verification of  invalid login & Password")
	public void loginToSauceDemowithInValidDataProvider(String userName,String Password, String expectedErrorMsg) throws InterruptedException {
		
		SoftAssert softassertion = new SoftAssert();
		login(userName,Password);
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		WebElement error_element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
		
		softassertion.assertEquals(error_element.getText(), expectedErrorMsg,String.format("Error userName='%s', Password='%s'",userName,Password));
		
		softassertion.assertAll();
		Thread.sleep(1000);
		}
	
	@DataProvider(name="credentials", parallel =true)
	public Object[][] validCredentials(){
		
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"}
		};
	}
	
	
	@DataProvider(name="invalidcredentials", parallel = true)
	public Object[][] invalidCredentials(){
		return new Object[][] {
			{"","","Epic sadface: Username is required"},
			{"standard_user","","Epic sadface: Password is required"},
			{" "," ","Epic sadface: Username and password do not match any user in this service"},
			{"standard_user"," ","Epic sadface: Username and password do not match any user in this service"},
			{"invalid_user","no_password","Epic sadface: Username and password do not match any user in this service"}
		};
		
	}
	

}
