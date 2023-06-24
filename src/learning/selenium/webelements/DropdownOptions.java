package learning.selenium.webelements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownOptions {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement element = driver.findElement(By.id("country"));
		Select se = new Select(element);
		
		List origList = new ArrayList<>();
		List tempList = new ArrayList<>();
		
		List<WebElement> elementList = se.getOptions();//we will get all options
		System.out.println(elementList.size()); // no o elements in dropdown
		for (WebElement e : elementList) {
			origList.add(e.getText());
			tempList.add(e.getText());
		}

		System.out.println(origList);
		//tempList = origList; // whenever templist sorted automatically origlist will also be sorted
		System.out.println("Before sorting " + tempList);
		Collections.sort(tempList);
		System.out.println("After sorting " + tempList);
		if (tempList == origList) {
			System.out.println("Dropdown sorted"); // output becoz whenever templist sorted automatically origlist will
													// also be sorted
		} else
			System.out.println("Dropdown not sorted");
		driver.close();
	}

}
