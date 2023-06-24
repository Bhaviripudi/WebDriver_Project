package learning.selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTesting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true); //This will make browser as headless
		    //or
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		System.out.println("Title of the page " + driver.getTitle());

	}

}
