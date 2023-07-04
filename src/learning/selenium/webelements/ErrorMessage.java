package learning.selenium.webelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErrorMessage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kowsh\\Automation downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[1]/div/label/input")).sendKeys("hfjafja");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[2]/div/label/input")).sendKeys("jksfjagf");
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]")).click();
		
		String expMsg = "Sorry, your password was incorrect. Please double-check your password.";
		String actlMsg = driver.findElement(By.xpath("//*[@id=\"slfErrorAlert\"]")).getText();
		
		if(expMsg.equals(actlMsg)) {
			System.out.println("Error message matched");
		}else {
			System.out.println("Error message not matched");
		}
		
	}

}
