package learning.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPOM {

	WebDriver driver;

	By skipSignIn = By.id("btn2");
	By frstName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
	By lastName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
	By email = By.xpath("//*[@id=\"eid\"]/input");
	By phone = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input");

	RegisterPOM(WebDriver dr) {

		driver = dr;
	}

	public void clkSkipSignIn() {

		driver.findElement(skipSignIn).click();
	}

	public void enterFrstName(String FrstNm) {

		driver.findElement(frstName).sendKeys(FrstNm);
	}

	public void enterLastName(String LstNm) {

		driver.findElement(lastName).sendKeys(LstNm);
	}

	public void enterEmail(String emailAddress) {

		driver.findElement(email).sendKeys(emailAddress);
	}

	public void enterPhone(String ph) {

		driver.findElement(phone).sendKeys(ph);
	}
}
