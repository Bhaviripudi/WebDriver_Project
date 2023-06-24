package learning.selenium.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		
		Actions action = new Actions(driver);
		
		WebElement switchTo = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a"));
		WebElement alerts = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a"));
		WebElement windows = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[2]/a"));
		WebElement iframes = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[3]/a"));
		
		action.moveToElement(switchTo).moveToElement(alerts).moveToElement(windows).moveToElement(iframes).click().build().perform();
		
//		action.moveToElement(switchTo).build().perform();
//		action.moveToElement(alerts).build().perform();
//		action.moveToElement(windows).build().perform();
//		action.moveToElement(iframes).click().build().perform();
		
		driver.close();
		
	}

}
