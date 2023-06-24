package learning.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM2 {

	WebDriver driver;

	@FindBy(how = How.ID, using = "btn2")  //syntax1
	WebElement skipSignIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	WebElement frstName;
	
	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input") //syntax2
	WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"eid\"]/input")
	WebElement email;
	
	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")WebElement phone;

	RegisterPOM2(WebDriver dr) {

		driver = dr;
		PageFactory.initElements(dr, this); // when ever we use @FindBy we should use this additional method in constructor
	}

	public void clkSkipSignIn() {

		skipSignIn.click();
	}

	public void enterFrstName(String FrstNm) {

		frstName.sendKeys(FrstNm);
	}

	public void enterLastName(String LstNm) {

		lastName.sendKeys(LstNm);
	}

	public void enterEmail(String emailAddress) {

		email.sendKeys(emailAddress);
	}

	public void enterPhone(String ph) {

		phone.sendKeys(ph);
	}
}
