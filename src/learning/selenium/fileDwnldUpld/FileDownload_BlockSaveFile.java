package learning.selenium.fileDwnldUpld;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownload_BlockSaveFile {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		
		FirefoxProfile profile = new FirefoxProfile(); //creating the browser profile
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf"); //set MIME type of particular file ,pdf file,  for zip file -> application/zip
		profile.setPreference("browser.download.manager.showWhenStarting.", false); //setting the preference to block the save file popup
		
		//download files in desired location
		profile.setPreference("browser.download.dir", "D:\\DownloadFiles");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("pdfjs.disabled", true);//only for pdf files
		
		FirefoxOptions options = new FirefoxOptions(); //setting options in browser profile
		options.setProfile(profile);
		WebDriver driver = new FirefoxDriver(options);
		
		//text
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Hello Testing");
		driver.findElement(By.id("createTxt")).click();
		
		//checking if file exists or not
		if(isFileExists("C:\\Users\\bhsul\\Downloads\\info.txt"))
		{
			System.out.println("File exists");
		}else
			System.out.println("File does not exists");
		
		driver.findElement(By.id("link-to-download")).click(); // clicking the download link
				
		Thread.sleep(3000);
		//pdf
		driver.findElement(By.id("pdfbox")).sendKeys("This is pdf file");
		driver.findElement(By.id("createPdf")).click();
		
		if(isFileExists("C:\\Users\\bhsul\\Downloads\\info.pdf"))
		{
			System.out.println("Pdf File exists");
		}else
			System.out.println("Pdf File does not exists");
		
		driver.findElement(By.id("pdf-link-to-download")).click(); 
			
		driver.close();
		
	}
	
	static boolean isFileExists(String path) {
		
		File file = new File(path);
		
		if(file.exists()) {
			return true;
		}
		else 
			return false;
	}
	

}
