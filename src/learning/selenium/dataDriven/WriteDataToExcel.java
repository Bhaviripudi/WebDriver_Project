package learning.selenium.dataDriven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream("C:\\Users\\bhsul\\OneDrive\\WriteData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Sheet1");
		XSSFSheet sheet2 = workbook.createSheet("Sheet2");
		
		
		for(int i =0; i<5 ; i++) {
			
			XSSFRow row1 = sheet1.createRow(i);
			XSSFRow row2 = sheet2.createRow(i);
			
			for(int j =0; j<3; j++) {
				
				row1.createCell(j).setCellValue("nana");
				row2.createCell(j).setCellValue("bujji");
				
			}
		}
		workbook.write(file);
		file.close();
		System.out.println("File created");
	}

}
