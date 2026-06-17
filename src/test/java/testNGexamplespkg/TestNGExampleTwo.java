package testNGexamplespkg;

import org.testng.annotations.Test;

public class TestNGExampleTwo {
	
	@Test(priority=1, groups={"smoke","regression"})
	public void login()
	{
		System.out.println("This is login Method");
	}
	

	@Test(priority=0, groups="smoke") 
	public void guestLogin()
	{
		System.out.println("This is guest login Method");
	}


	@Test(priority=2, groups={"smoke","regression"})
	public void search()
	{
		System.out.println("This is search Method");
	}
	
	@Test(priority=3, invocationCount=4, groups="regression")
	public void productDetails()
	{
		System.out.println("This is details Method");
	}
	
	@Test(priority=4,groups="regression")
	public void payment()
	{
		System.out.println("This is payment Method");
	}  
	
	@Test(priority=5, enabled=true) // enabled = false ; will skip the @test method form execution
	public void orderDetails()
	{
		System.out.println("This is orderDetails Method");
	}
	
	@Test(priority=6,groups={"smoke","regression"})
	public void logout()
	{
		System.out.println("This is logout Method");
	}

}
