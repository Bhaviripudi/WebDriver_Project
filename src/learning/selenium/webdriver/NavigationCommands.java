package learning.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://www.orangehrm.com/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
