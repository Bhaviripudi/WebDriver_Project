package learning.selenium.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingWebTable {

	public static void main(String[] args) {

		/*
		 * Open Orange HRM url Login Go to Admin -> user management -> users Need to
		 * check how many are enabled
		 */

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");

		int rows = driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr")).size();
		int countryCount = 0;
		for (int i = 2; i <= rows; i++) {

			String country = driver.findElement(By.xpath
					("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[1]/div[2]/table/tbody/tr["+i+"]/td[3]")).getText();
             System.out.println(country);
			
			if (country.equalsIgnoreCase("Austria")) {
				countryCount = countryCount + 1;

			}
			
		}
		System.out.println("No from Austria " +countryCount);
		driver.close();

	}

}
