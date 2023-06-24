package learning.selenium.webDriverCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		//Alert with ok
		//alert with ok link
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		//alert with ok button
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		//switch to alert box
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Alert with OK and Cancel
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click(); //cancel and ok link
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();  // cancel and ok button
		//alert with cancel validation
		driver.switchTo().alert().dismiss();
		String expTextCancel = "You Pressed Cancel";
		String actText = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		if(expTextCancel.equals(actText)) {
			System.out.println("Clicked on cancel");
		}else 
			System.out.println("Not clicked on cancel");
		
		//alert with OK validation
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		driver.switchTo().alert().accept();
		String expTextOK = "You pressed Ok";
		 actText = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText();
		if(expTextOK.equals(actText)) {
		System.out.println("Clicked on ok");
		}else 
		System.out.println("Not clicked on ok");
		
		//Alert with Text Box
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		driver.switchTo().alert().sendKeys("Testing alert text box");
		driver.switchTo().alert().accept();
		String expText = "Hello Testing alert text box How are you today";
	    String actualText = driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText();
	    
	    if(expText.equals(actualText)) {
	    	
	    	System.out.println("Entered text matched");
	    }else
	    {
	    	System.out.println("Not matched");
	    }
		driver.close();
	}

}
