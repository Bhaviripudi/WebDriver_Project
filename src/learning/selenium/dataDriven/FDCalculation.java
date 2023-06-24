package learning.selenium.dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculation {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.paisabazaar.com/fd-fixed-deposit-calculator/");
		driver.manage().window().maximize();

		FileInputStream file = new FileInputStream("C:\\Users\\bhsul\\OneDrive\\ReadData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet4");

		int rowCount = sheet.getLastRowNum();

		driver.findElement(By.id("principal_amount")).clear();
		driver.findElement(By.id("rate_of_interest_w")).clear();
		driver.findElement(By.id("tennure")).clear();
		
		System.out.println(rowCount);

		for (int i = 1; i < rowCount; i++) {

			XSSFRow currentRow = sheet.getRow(i);

		    //XSSFCell fd_amount = currentRow.getCell(0);
			//int fda = (int) fd_amount.getNumericCellValue(); // type casting to remove decimal values
			
			int fda = (int) currentRow.getCell(0).getNumericCellValue();

			int roi = (int) currentRow.getCell(1).getNumericCellValue();
			int fd_tenure = (int) currentRow.getCell(2).getNumericCellValue();
			double maturity_amount = (double) currentRow.getCell(3).getNumericCellValue();

			driver.findElement(By.id("principal_amount")).sendKeys(String.valueOf(fda));
			driver.findElement(By.id("rate_of_interest_w")).sendKeys(String.valueOf(roi));
			driver.findElement(By.id("tennure")).sendKeys(String.valueOf(fd_tenure));

			//dropdown
			Select period = new Select(driver.findElement(By.id("tennureType")));
			period.selectByVisibleText("Years");
			//period.selectByIndex(1);
			//period.selectByValue("");

			driver.findElement(By.id("fd-calculatorbt")).click();

			String actual_maturity = driver.findElement(By.id("maturityAmount")).getText();

			if ((Double.parseDouble(actual_maturity)) == maturity_amount) {

				System.out.println("Test passed ");
			} else {
				System.out.println("Failed");
			}

		}
		driver.close();
	}

}
