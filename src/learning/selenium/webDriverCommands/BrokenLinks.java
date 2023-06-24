package learning.selenium.webDriverCommands;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);// wait for 3 sec

		List<WebElement> linkscount = driver.findElements(By.tagName("a")); // links
		System.out.println(linkscount.size());
		
		for (WebElement element : linkscount) {
			String url = element.getAttribute("href"); // by using href we can get url of link
			URL link = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) link.openConnection(); // create a connection using 'link' obj
			Thread.sleep(3000);
			urlConnection.connect();// establish connetion
			int resp = urlConnection.getResponseCode(); // get resp code if code is above 400 : broken links
			
			if (resp >= 400) {
				System.out.println(url + " Broken link");
			} else
				System.out.println(url + " Valid link");
		}

	}

}
