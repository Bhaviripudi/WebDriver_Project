package learning.selenium.staleElements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.techbeamers.com/websites-to-practice-selenium-webdriver-online/");
		Thread.sleep(3000);
		WebElement mySqlLink = driver.findElement(By.xpath("//*[@id=\"menu-item-8952\"]/a"));
		mySqlLink.click();
		driver.navigate().back();
		// handling stale element
		try {
			mySqlLink.click();
		} catch (StaleElementReferenceException ex) {

			mySqlLink = driver.findElement(By.xpath("//*[@id=\"menu-item-8952\"]/a"));
			mySqlLink.click();
		}
	}

}
