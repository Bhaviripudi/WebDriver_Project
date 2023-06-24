package learning.selenium.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	void launch() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver.manage().window().maximize();
	}

	@AfterTest
	void close() {
		driver.close();
	}

	@Test
	void loginTsestCase() {
		
		driver.get("https://www.saucedemo.com/");

		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.name("password"));

		Assert.assertTrue(userName.isDisplayed()); // If the condtion true it will proceed
		userName.sendKeys("standard_user");

		Assert.assertTrue(password.isDisplayed());
		password.sendKeys("secret_sauce");

		/*
		 * Assert.assertFalse(password.isDisplayed()); //Negative test case
		 * password.sendKeys("admin123");
		 */

		driver.findElement(By.id("login-button")).click();

		String expTitle = driver.getTitle();
		System.out.println(expTitle);

		Assert.assertNotEquals("Single Page Apps for GitHub Pages", expTitle); // Negative test case

	}
}
