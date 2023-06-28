package learning.selenium.webDriverCommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kowsh\\Automation downloads\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(1000);
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbai']"));

		System.out.println(list.size());

		for (WebElement w : list) {

			String listValues = w.getText();
			System.out.println(listValues);

			if (listValues.contains("Java tutorial")) {

				w.click();
				break;
			}
		}

		/*
		 * for(int i=0;i<list.size();i++) {
		 * 
		 * String listItem = list.get(i).getText(); System.out.println(listItem);
		 * 
		 * if(listItem.contains("java tutorial")) { list.get(i).click(); break; } }
		 */
	}

}
