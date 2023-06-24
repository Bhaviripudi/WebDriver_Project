package learning.selenium.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	SoftAssert softAssert = new SoftAssert();

	@Test
	void demoTest() {
	
		softAssert.assertTrue(true);
		softAssert.assertEquals("wcm", "Wcm");//fail
		softAssert.assertEquals("call", "call");//pass
		System.out.println("Soft tests passed");//It will execute even above statement fails
		softAssert.assertAll();
	}
}
