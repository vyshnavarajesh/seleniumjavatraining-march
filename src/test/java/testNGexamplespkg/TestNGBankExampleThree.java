package testNGexamplespkg;

import org.testng.annotations.Test;

public class TestNGBankExampleThree {
	

	@Test(groups= {"sanity","regression","smoke"})
	public void creditCardLoanApplication()
	{
		System.out.println("This is login Method with Password");
	}
	
	@Test(groups= {"regression"})
	public void homeLoanApplication()
	{
		System.out.println("This is  bankLoginWithOTP method");
	}
	
	@Test(groups= {"sanity"})
	public void carLoanApplication()
	{
		System.out.println("This is bankLoginWithFaceID method");
	}
	
	

}
