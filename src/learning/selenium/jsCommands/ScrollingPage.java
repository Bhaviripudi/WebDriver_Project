package learning.selenium.jsCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    //scrolling by the pixel
		    js.executeScript("window.scrollBy(0,1000)", "");
		    
		    //scrolling by element
		     WebElement india = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[1]/tbody/tr[86]/td[1]/img"));
		     js.executeScript("arguments[0].scrollIntoView()", india);
		    
		   //scroll till bottom
		    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		    
	}

}
