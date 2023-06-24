package learning.selenium.crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class CrossBrowserTesting {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void launch(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();}
        else if(browserName.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.chrome.driver", "D:\\geckodriver.exe");
		driver = new FirefoxDriver();}

	}

	@Test
	public void login() {

		driver.get("https://www.saucedemo.com/");
		System.out.println("Text is " + driver.findElement(By.xpath("/html/body/div/div/div[1]")).getText());
		driver.manage().window().maximize(); // maximize the browser window
		driver.findElement(By.name("user-name")).sendKeys("standard_user"); // username
		driver.findElement(By.id("password")).sendKeys("secret_sauce"); // paswrd
		driver.findElement(By.id("login-button")).click();
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}
}
