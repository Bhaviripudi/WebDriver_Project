package learning.selenium.ashotAPI;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import learning.selenium.jsCommands.JavaScriptExecutor;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CaptureLogo {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\kowsh\\Automation downloads\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img"));
		
		
		Screenshot logoShot = new AShot().takeScreenshot(driver, logoElement);
		ImageIO.write(logoShot.getImage(), "png",
				new File("C:\\Users\\kowsh\\OneDrive\\Pictures\\Saved Pictures\\OrangeHRM.png"));

		File file = new File("C:\\Users\\kowsh\\OneDrive\\Pictures\\Saved Pictures\\OrangeHRM.png");
		if (file.exists()) {
			System.out.println("Logo exists");
		} else
			System.out.println("Logo does not exists");
	}

}
