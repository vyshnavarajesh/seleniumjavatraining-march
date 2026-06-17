package testNGexamplespkg;

import org.testng.annotations.Test;

public class TestNGExampleOne {
	
	@Test(priority=1)
	public void login()
	{
		System.out.println("This is login Method");
	}
	
	@Test(priority=0) // we can have +ve ,0 ,-ve numbers as part of priority ; highest priority will start form -ve , followed by 0 & +ve
	public void guestLogin()
	{
		System.out.println("This is guest login Method");
	}


	@Test(priority=2)
	public void search()
	{
		System.out.println("This is search Method");
	}
	
	@Test(priority=3)
	public void productDetails()
	{
		System.out.println("This is details Method");
	}
	
	@Test(priority=4)
	public void addToCart()
	{
		System.out.println("This is add/remove cart Method");
	}
	
	@Test(priority=5)
	public void payment()
	{
		System.out.println("This is payment Method");
	}  
	
	public void orderDetails()
	{
		System.out.println("This is orderDetails Method");
	}
	
	@Test(priority=6)
	public void logout()
	{
		System.out.println("This is logout Method");
	}
	
}
