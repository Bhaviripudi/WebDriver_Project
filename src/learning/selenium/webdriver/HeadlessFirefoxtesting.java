package learning.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxtesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		//options.setHeadless(true);
		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://www.saucedemo.com/");
		System.out.println("Title "+ driver.getTitle());
		
	}

}
