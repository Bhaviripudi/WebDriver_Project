package learning.selenium.webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopup {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		         // https://username:password@test.com
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String text = driver.findElement(By.cssSelector("p")).getText();
		if(text.equals("Congratulations! You must have the proper credentials."))
		{
			System.out.println("test passed");
		}
		else
			System.out.println("test failed");
		driver.close();
	}

}
