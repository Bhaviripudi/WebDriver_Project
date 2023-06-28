package learning.selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstWebDriverTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kowsh\\Automation downloads\\drivers\\geckodriver.exe"); //set current path of the driver
		
		FirefoxDriver driver = new FirefoxDriver(); // Invoke the browser

		// WebDriver driver = new ChromeDriver(); //Invoke the browser

		// driver.get("https://opensource-demo.orangehrmlive.com/"); // url
		driver.get("https://www.saucedemo.com/");
		System.out.println("Text is " + driver.findElement(By.xpath("/html/body/div/div/div[1]")).getText());
		driver.manage().window().maximize(); // maximize the browser window
		driver.findElement(By.name("user-name")).sendKeys("standard_user"); // username
		driver.findElement(By.id("password")).sendKeys("secret_sauce"); // paswrd
		driver.findElement(By.id("login-button")).click(); // login button
		String expTitle = "Swag Labs";
		String actlTitle = driver.getTitle(); // Title of the page
		System.out.println("Title is " +actlTitle);

		// validation
		if (expTitle.equals(actlTitle)) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		System.out.println("current url " + driver.getCurrentUrl()); // will give current url
		driver.close(); // close the browser

	}

}
