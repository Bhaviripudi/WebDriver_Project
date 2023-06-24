package learning.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestCaseInHubNode {

	WebDriver driver;
	
	@Test(priority=1)
	public void setUp() throws MalformedURLException {
		
		String nodeUrl = "http://192.168.55.122/wd/hub";
		      /*DesiredCapabilities cap = DesiredCapabilities.chrome();
		      cap.setBrowserName("chrome");
		      cap.setPlatform(Platform.WINDOWS);
		      //cap.setPlatform(Platform.LINUX);*/
				
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//driver = new RemoteWebDriver(new URL(nodeUrl),cap);
	}
	
	@Test(priority=2)
	public void login() {
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.findElement(By.name("username")).sendKeys("bahubali@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bahubali@123");
		driver.findElement(By.name("login")).click();
		
		if(driver.getPageSource().contains("Hello bahubali")) {
			System.out.println("passed");
		}else
			System.out.println("failed");
	}
	@Test(priority=3)
	public void close() {
		driver.close();
	}
}
