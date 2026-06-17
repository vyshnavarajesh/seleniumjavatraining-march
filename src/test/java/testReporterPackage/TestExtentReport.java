package testReporterPackage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationExamples.BaseTest;

@Listeners(TestListener.class) // This is at test class level ; we can run it as testNG class
public class TestExtentReport {
	
	@BeforeClass
	public void setup() {
		
		BaseTest.initializeDriver("safari");
		BaseTest.launchApplication("https://www.saucedemo.com/");
		
	}
	
	@Test
	public void success() {
		Assert.assertTrue(true);
	}

	
	@Test
	public void failure() {
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods ="failure")
	public void skipped() {
		System.out.print("This test is skipped");
	
	}
	
	@AfterClass
	public void tearDown() {
		
		BaseTest.quitDriver();
	}

}
