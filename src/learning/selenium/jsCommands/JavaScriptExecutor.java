package learning.selenium.jsCommands;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		//Flash an element
		WebElement letsGo = driver.findElement(By.xpath("/html/body/div/section[1]/div/div/form/div/button"));
		JsUtils.flash(letsGo, driver);
		
		//Drawing border
		WebElement freeJoin = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));
		JsUtils.drawBorder(freeJoin, driver);
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\bhsul\\OneDrive\\Pictures\\Screenshots\\twoplugs.png");
		FileUtils.copyFile(source, target);
		
		//Capture title of the page
		String title = JsUtils.getTitleJs(driver);
		System.out.println(title);
		
		//Click on element
		WebElement login = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a"));
		JsUtils.clickElement(login, driver);
		//Generate alert
		//JsUtils.generateAlert(driver, "Clicked on login......");
		
		//REfresh
		JsUtils.refreshJs(driver);
		
	}

}
