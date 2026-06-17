package testNGexamplespkg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TestNGExampleThree {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(" @BeforeSuite");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println(" @AfterSuite");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println("This is @BeforeClass");
		System.out.println("+++++++++++++++++++++++++++++");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("+++++++++++++++++++++++++++++");
		System.out.println(" @AfterClass");
		System.out.println("+++++++++++++++++++++++++++++");
	}
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("--------------------");
		System.out.println("This is capture cookie @BeforeTest");
		System.out.println("--------------------");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("--------------------");
		System.out.println("clear cookie  @AfterTest");
		System.out.println("--------------------");
	}


	@Test
	public void search() {

		System.out.println("This is search @Test method");
	}

	@Test
	public void filter() {

		System.out.println("This is filter @Test method");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("***********************");
		System.out.println("This is before method");
		System.out.println("***********************");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("***********************");
		System.out.println("This is after method");
		System.out.println("***********************");
	}

}
