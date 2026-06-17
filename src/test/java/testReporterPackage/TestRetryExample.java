package testReporterPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRetryExample {
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void sampleTest() {
		System.out.println("retry the test");
		Assert.assertTrue(false);
	}

}
