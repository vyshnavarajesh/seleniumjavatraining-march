package testNGexamplespkg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGBankExampleOne {
	

	@Test(priority=1,groups= {"sanity"})
	public void bankLoginWithPassword()
	{
		System.out.println("This is login Method with Password");
		Assert.assertTrue(true);
	}
	
	@Test(priority=1,groups= {"sanity","regression","smoke"},enabled=true)
	public void bankLoginWithOTP()
	{
		System.out.println("This is  bankLoginWithOTP method");
		Assert.assertTrue(true);
	}
	
	@Test(enabled=true)
	public void bankLoginWithFaceID()
	{
		System.out.println("This is bankLoginWithFaceID method");
	}
	
	@Test(priority=2,groups= {"sanity"},dependsOnMethods= {"bankLoginWithPassword","bankLoginWithOTP"},alwaysRun=true)
	public void bankAccountBalance()
	{
		System.out.println("This is bankAccountBalance");
	}
	
	@Test(priority=3,groups= {"regression"},enabled=true,dependsOnMethods= {"bankLoginWithPassword"})
	public void bankStatement()
	{
		System.out.println("This is  bankStatement method");
	}
	
	
	

}
