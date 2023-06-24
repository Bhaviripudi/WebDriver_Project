package learning.selenium.listenerTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class LoginTest {

	@Test
	void loginByName() {
		System.out.println("login by name");
		assertEquals("sulu", "suloch");
	}
	
	@Test
	void loginByEmail() {
		System.out.println("login by email");
		assertEquals("nana", "nana");
	}
}
