package learning.selenium.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Calender {

	public static void main(String[] args) {

		  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		  WebDriver driver = new FirefoxDriver();
		  driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	      driver.findElement(By.id("first_date_picker")).click();
	      
	      //Select year = new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")));  //selecting dropDown
	      //year.selectByVisibleText("2024");
	      
	      //Future date selection
	      for(int m = 6; m<=12; m++) {
	    	  //6<=12 then clk(july) and check if loop and then 6+1<=12 -> click(aug) then check if and 7+1<=12 -> clk(sept) - matched break
	    	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
	    	  String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
	    	  String year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
	    	  
	    	      if(month.equalsIgnoreCase("September") && year.equals("2023")) {
	    		  
	    		  driver.findElement(By.linkText("14")).click();
	    		  break;
	    	  }
	      }
	    //past date selection
	      for(int m = 6; m>=1; m--) {
	    	  driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
	    	  String month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
	    	  String year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
	    	  
	    	      if(month.equalsIgnoreCase("March") && year.equals("2023")) {
	    		  
	    		  driver.findElement(By.linkText("14")).click();
	    		  break;
	    	  }
	      }
	      
	      
	}

}
