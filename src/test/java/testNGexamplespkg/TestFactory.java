package testNGexamplespkg;

import org.testng.annotations.Factory;

public class TestFactory {
	
	@Factory // class level
	public Object[] createFactoryLogin() {

		return new Object[] { new TestNGFactoryExample("standard_user", "secret_sauce"),
				new TestNGFactoryExample("performance_glitch_user", "secret_sauce"),
				new TestNGFactoryExample("error_user", "secret_sauce") };

	}
	
	public Object[] createFactorySearch() {

		return new Object[] { new TestNGFactoryExample("standard_user", "secret_sauce"),
				new TestNGFactoryExample("performance_glitch_user", "secret_sauce"),
				new TestNGFactoryExample("error_user", "secret_sauce") };

	}


}
