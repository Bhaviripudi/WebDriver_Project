package learning.selenium.webDriverCommands;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCookies {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kowsh\\Automation downloads\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Cookie cookieObj = new Cookie("mycookie", "12345"); //create our own cookie in browser
		driver.manage().addCookie(cookieObj);
		
		Set<Cookie> cookies = driver.manage().getCookies(); //capture all cookies
		System.out.println("No of cookies " + cookies.size());  // No of cookies
		
		for(Cookie cookie : cookies) {
			
			System.out.println(cookie.getName() + " : " + cookie.getValue());  // Read and print cookies name and value
		}
		System.out.println("Cookie by name: "+driver.manage().getCookieNamed("mycookie"));  // Get the cookie by name
		
		//deleting cookie
		driver.manage().deleteCookieNamed("i18n-prefs");
		cookies = driver.manage().getCookies();
		System.out.println("No of cookies after deleting a cookie" + cookies.size());
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println("No of cookies after deleting all cookies" + cookies.size());
		
	}

}
