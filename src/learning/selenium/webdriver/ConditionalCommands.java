package learning.selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConditionalCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://omayo.blogspot.com/");
		WebElement userName = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[5]/div[1]/form/input[1]"));
		WebElement password = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div[5]/div[1]/form/input[2]"));

		if (userName.isDisplayed() && userName.isEnabled()) {

			userName.sendKeys("something");
		}

		if (password.isDisplayed() && password.isEnabled()) {

			password.sendKeys("pass");
		}

		WebElement bike = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[15]/div[1]/input[1]"));
		WebElement bicycle = driver.findElement(By.xpath(
				"/html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[3]/div/aside/div[1]/div[15]/div[1]/input[2]"));
		System.out.println(bike.isSelected());
		System.out.println(bicycle.isSelected());
		
		//select bike
		if(bike.isSelected()==false) {	
			bike.click();			
		}
		
		driver.close();
	}

}