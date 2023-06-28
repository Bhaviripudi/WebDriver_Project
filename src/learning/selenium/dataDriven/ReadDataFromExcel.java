package learning.selenium.dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\kowsh\\ExcelAutomation\\ReadData.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		//XSSFSheet sheet = book.getSheet(1);  //if sheet is index
		
		int rowCount = sheet.getLastRowNum();   //return rows count
		int colCount = sheet.getRow(0).getLastCellNum(); //returns cell count
		
		System.out.println(rowCount);
		
		for(int i =0; i<rowCount ; i++) {
			
			XSSFRow currentRow = sheet.getRow(i); //get current row
			
			for(int j=0; j<colCount ; j++) {
				
				String value = currentRow.getCell(j).toString(); //get value in the cell
				System.out.print(" " +value);
			}
			System.out.println();
		}
		
	}

}
