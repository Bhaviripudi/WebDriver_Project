package learning.selenium.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jExample {

	public static void main(String[] args) {

		Logger logger = Logger.getLogger("Log4jExample"); // Need to create logger instance so we can pass class name
		DOMConfigurator.configure("log4j.xml"); //xml file
		//PropertyConfigurator.configure("log4j.properties"); //application.properties file

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		logger.info("Firefox driver started");

		FirefoxDriver driver = new FirefoxDriver();

		driver.get("https://www.saucedemo.com/");
		logger.info("opened the url");

		logger.info("Text is " + driver.findElement(By.xpath("/html/body/div/div/div[1]")).getText());
		driver.manage().window().maximize();
		logger.info("maximize the browser window");
		driver.findElement(By.name("user-name")).sendKeys("standard_user"); // username
		driver.findElement(By.id("password")).sendKeys("secret_sauce"); // paswrd
		driver.findElement(By.id("login-button")).click(); // login button
		String expTitle = "Swag Labs";
		String actlTitle = driver.getTitle(); // Title of the page
		logger.info("Title is " + actlTitle);

		// validation
		if (expTitle.equals(actlTitle)) {
			logger.info("passed");
		} else {
			logger.info("Failed");
		}
		driver.close();

	}

}
