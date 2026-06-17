package automationExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class SeleniumOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver dr = new ChromeDriver(); // for chrome
		
//		ChromeDriver dr4 = new ChromeDriver();
//		 
//		WebDriver dr2 = new FirefoxDriver(); // firefox
//		
//		WebDriver dr3 = new EdgeDriver();
		
		
		// dr.navigate().to("https://www.selenium.dev/"); // this has got 2 methods
		// dr.manage().window().fullscreen();
		 dr.get("https://www.selenium.dev/documentation/webdriver/bidi/"); // It will strictly wait until my page loaded fully
		 Thread.sleep(2000);
		 dr.navigate().back();
		 Thread.sleep(2000);
		 dr.navigate().refresh();
		 Thread.sleep(1000);
		 dr.navigate().forward();
		 //dr.get("https://www.selenium.dev/documentation/webdriver/bidi/"); // It will strictly wait until my page loaded fully
		 
		
		 Thread.sleep(1000);
		 dr.manage().window().minimize();
		 Thread.sleep(1000);
		 dr.manage().window().maximize();
		 Thread.sleep(1000);
		 dr.close();  // want to close only current session, we use close()
		 // dr.quit(); // will close all the browser sessions
		 
		 // locators
		 
		 // id (priority 0)
		 // name (priority 1)
		 // className
		 // tagName (eg : a , img etc.,)
		 // linkText
		 // partialLinktext
		 
		 // xpath 
		 // css 
	}

}
