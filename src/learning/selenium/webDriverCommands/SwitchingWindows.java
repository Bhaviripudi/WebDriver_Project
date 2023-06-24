package learning.selenium.webDriverCommands;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchingWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		
		Set<String> s = driver.getWindowHandles();
		
		for(String i : s) {
			
			System.out.println("Ids of winows " +i);
			String t = driver.switchTo().window(i).getTitle();
			System.out.println(t);
			if(t.contains("Frames & windows")) //want to close specific window
			{
			driver.close();
			}
		}
		//driver.quit();
	}

}
