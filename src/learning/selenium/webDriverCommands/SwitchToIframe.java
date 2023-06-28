package learning.selenium.webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToIframe {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kowsh\\Automation downloads\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://theautomationzone.blogspot.com/2022/08/handling-frames.html");
		driver.switchTo().frame("frame1");  //by id of the frame or we can also give index number or by x-path of frame
		System.out.println(driver.findElement(By.xpath("/html/body/p")).getText());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame2']")));
		System.out.println(driver.findElement(By.xpath("/html/body/p")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Blog1\"]/div[1]/div/div/div/div[1]/h3")).getText());
        driver.close();
	}

}
