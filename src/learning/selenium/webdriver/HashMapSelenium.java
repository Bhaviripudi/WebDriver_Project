package learning.selenium.webdriver;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapSelenium {

	static HashMap<String, String> loginData() {

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("x", "standard_user@secret_sauce");

		return hm;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		String credential = loginData().get("x");
		 String arr[] = credential.split("@");
		 
		 driver.findElement(By.id("user-name")).sendKeys(arr[0]);
		 driver.findElement(By.id("password")).sendKeys(arr[1]);
		 driver.findElement(By.id("login-button")).click();
		 
		 if(driver.getTitle().equals("Single Page Apps for GitHub Pages")) {
			 System.out.println("Test passed");
		 }
		 else
			 System.out.println("Test failed");
	}

}
