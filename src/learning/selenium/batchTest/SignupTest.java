package learning.selenium.batchTest;

import org.testng.annotations.Test;

public class SignupTest {

	@Test(priority=1)
	void signUpByName() {
		System.out.println("sign up by name");
	}
	
	@Test(priority=2)
	void signUpByEmail() {
		System.out.println("sign up by email");
	}
}
