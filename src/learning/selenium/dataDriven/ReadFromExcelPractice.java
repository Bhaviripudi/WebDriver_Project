package learning.selenium.dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadFromExcelPractice {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://nxtgenaiacademy.com/demo-site/");
		driver.manage().window().maximize();

		FileInputStream file = new FileInputStream("C:\\Users\\bhsul\\OneDrive\\ReadData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet3");

		int rowCount = sheet.getLastRowNum();
		// int colCount = sheet.getRow(0).getLastCellNum();

		for (int row = 1; row < rowCount; row++) {

			XSSFRow currentRow = sheet.getRow(row);
			String first_name = currentRow.getCell(0).getStringCellValue();
			String last_name = currentRow.getCell(1).getStringCellValue();
			String email = currentRow.getCell(2).getStringCellValue();
			String verification = new DataFormatter().formatCellValue(currentRow.getCell(3));

			driver.findElement(By.name("vfb-5")).sendKeys(first_name);
			driver.findElement(By.name("vfb-7")).sendKeys(last_name);

			WebElement gender = driver.findElement(By.name("vfb-31"));
			if (gender.isSelected() == false) {
				gender.click();
			}
			driver.findElement(By.name("vfb-14")).sendKeys(email);
			driver.findElement(By.name("vfb-3")).sendKeys(verification);
			driver.findElement(By.name("vfb-submit")).click();

			if (driver.getPageSource().contains("Dynamic Transaction")) {
				System.out.println("Registration successful for " + row + " record");

			} else {
				System.out.println("Registration failure for " + row + " record");
			}
			driver.navigate().back();
			driver.findElement(By.name("vfb-5")).clear();
			driver.findElement(By.name("vfb-7")).clear();
			driver.findElement(By.name("vfb-14")).clear();
			driver.findElement(By.name("vfb-3")).clear();

		}
		driver.close();
	}

}
