package testNGexamplespkg;

import org.testng.annotations.Test;

public class TestNGBankExampleTwo {
	
	
	@Test(groups= {"sanity"})
	public void transferMoneyIMPS()
	{
		System.out.println("This is transferMoneyIMPS method");
	}
	
	@Test(groups= {"sanity","regression","smoke"})
	public void transferMoneyNEFT()
	{
		System.out.println("This is transferMoneyNEFT method");
	}
	
	@Test
	public void transferMoneyUPI()
	{
		System.out.println("This is transferMoneyUPI method");
	}
	
	
	@Test(groups= {"regression"})
	public void payElectricityBill()
	{
		System.out.println("This is transferMoneyUPI method");
	}

}
