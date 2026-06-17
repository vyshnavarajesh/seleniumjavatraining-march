package automationExamples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class ScreenshotExample extends BaseTest{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		driver = initializeDriver("chrome-incognito");
		
		launchApplication("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
		
		TakesScreenshot t = (TakesScreenshot) driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE); // will take screenshot
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String filepath = System.getProperty("user.dir")+"/screenshots/img"+"_"+timestamp+".png";
		Files.copy(srcFile.toPath(), Paths.get(filepath));
		
		/* Alternative way to copy the file */
		// File targetFilePath = new File(System.getProperty("user.dir")+"\\screenshots\\img1.png");
		// file1.renameTo(targetFilePath)
		
		
		WebElement ele = driver.findElement(By.xpath("//input[@class='form-control' and @placeholder='Type to Search']"));
		
		File WebElementsrc = ele.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\element"+"_"+timestamp+".png");
		WebElementsrc.renameTo(target);
		
		Thread.sleep(2000);
		quitDriver();
		
	}

}
