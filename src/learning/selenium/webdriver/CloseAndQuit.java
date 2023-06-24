package learning.selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseAndQuit {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver(); // Invoke the browser
		//driver.get("https://www.webroot.com/services/popuptester1.htm");
		driver.get("https://www.techbeamers.com/websites-to-practice-selenium-webdriver-online/");
		driver.findElement(By.xpath
				("/html/body/div[1]/div/div[1]/div/div/div/article/div/div[1]/div[1]/div[1]/div[2]/div[2]/div/section[3]/div/div/div/div[3]/div/div/div/h3/a")).click();
		//driver.close();
		driver.quit();
	}

}
