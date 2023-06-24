package learning.selenium.encodeDecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EncodePassword {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(decodeStr("c2VjcmV0X3NhdWNl"));
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
	}
	
	static String decodeStr(String password) {
		byte[] decodedStr = Base64.decodeBase64(password);
		return(new String(decodedStr));
	}

}
