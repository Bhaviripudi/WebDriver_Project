package learning.selenium.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void demoTest() {
		Assert.assertTrue(true);
		Assert.assertEquals("Selenium", "Sselenium");; //fail
		System.out.println("Test passed"); // In hard assert this statement wont execute if above statement failed
	}
}
