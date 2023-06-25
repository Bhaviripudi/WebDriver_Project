package learning.selenium.staleElements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
	    WebElement email=driver.findElement(By.name("email"));
	    email.sendKeys("bhav");
	    WebElement pwd = driver.findElement(By.name("password"));
	    pwd.sendKeys("xyz");
	    driver.navigate().refresh(); //after refreshing the new doc structure will be created, in that case cannot identify the elements.
	    //handling staled elements
	    try {
	    email.sendKeys("bhav");
	    }catch(StaleElementReferenceException ex){
	    	email=driver.findElement(By.name("email"));
	 	    email.sendKeys("bhav");
	    }
	    
	}

}
