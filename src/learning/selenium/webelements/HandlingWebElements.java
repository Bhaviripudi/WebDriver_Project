package learning.selenium.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWebElements {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3.org/WAI/UA/2002/06/thead-test");
		
		int rows = driver.findElements(By.xpath("/html/body/table[3]/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("/html/body/table[3]/tbody/tr/th")).size();
		
		System.out.println(rows);
		System.out.println(cols);
		
		for(int i=2; i<=rows ; i++) {
			
			for(int j=1; j<=cols; j++) {
				
				System.out.print(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr["+i+"]/td["+j+"]")).getText() + "  ");
			}
			
			System.out.println();
		}
		
		driver.close();
	}

}
