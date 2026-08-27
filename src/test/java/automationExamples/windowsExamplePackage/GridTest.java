package automationExamples.windowsExamplePackage;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationExamples.BaseTest_Grid;

public class GridTest {
	private WebDriver driver;
    @Parameters({"browser", "grid.url"})
    @BeforeMethod
    public void setUp(String browser, String gridUrl) {
        BaseTest_Grid.initializeDriver(browser, gridUrl);
        BaseTest_Grid.launchApplication("https://www.saucedemo.com/");
        driver = BaseTest_Grid.getDriver();
    }

    @AfterMethod
    public void tearDown() {
    	BaseTest_Grid.quitDriver();
    }

    @Test
    public void testValidLogin() {
        login("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(), "Products", "Login did not land on Products page");
    }
    
    @Test
    public void testLockedOutUser() {
        login("locked_out_user", "secret_sauce");
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        Assert.assertTrue(error.getText().contains("locked out"), "Expected lockout error message");
    }
    
    @Test
    public void testProductSortLowToHigh() {
        login("standard_user", "secret_sauce");
        driver.findElement(By.className("product_sort_container")).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();

        List<Double> prices = driver.findElements(By.className("inventory_item_price"))
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());

        List<Double> sorted = prices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(prices, sorted, "Products not sorted low to high");
    }


    private void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}