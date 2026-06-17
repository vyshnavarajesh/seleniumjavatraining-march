package testNGexamplespkg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGBankExampleFour {
	

	@Test(priority=1,groups= {"sanity"})
	public void bankLoginWithPassword()
	{
		System.out.println("This is login Method with Password");
		Assert.assertTrue(true);
		
	}
	
	
	@Test(enabled=true)
	public void bankLoginWithFaceID()
	{
		System.out.println("This is bankLoginWithFaceID method");
	}
	
	
	
	@Test(groups= {"cards"})
	public void printCard()
	{
		System.out.println("This is  bankStatement method");
		
		Assert.assertTrue(false);
	}
	
	
	@Test(groups= {"creditcards"})
	public void getCreditCard()
	{
		System.out.println("This is  bankStatement method");
		
	}
	
	
	@Test(groups= {"forex"})
	public void getForexCard()
	{
		System.out.println("This is  bankStatement method");
	}

}
