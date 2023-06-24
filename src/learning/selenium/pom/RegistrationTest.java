package learning.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationTest {

	@Test
	public void register() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//RegisterPOM register = new RegisterPOM(driver);
		RegisterPOM2 register = new RegisterPOM2(driver);

		driver.get("https://demo.automationtesting.in/Index.html");

		register.clkSkipSignIn();
		register.enterFrstName("sulochana");
		register.enterLastName("B");
		register.enterEmail("sulu@gmail.com");
		register.enterPhone("12345");

	}

}
