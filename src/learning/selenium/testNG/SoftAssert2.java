package learning.selenium.testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert2 {
	
	SoftAssert softAssert1 = new SoftAssert();
	SoftAssert softAssert2 = new SoftAssert();
	

	@Test
	void demoTest1() {
		
		softAssert1.assertEquals("stu", "sTu"); //fail
		softAssert1.assertAll();
	}
	@Test
	void demoTest2() {
		
		softAssert2.assertEquals("stu", "stu"); //pass
		softAssert2.assertAll();
	}
	
}
