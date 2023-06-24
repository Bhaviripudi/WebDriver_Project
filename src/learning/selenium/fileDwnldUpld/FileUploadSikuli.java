package learning.selenium.fileDwnldUpld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class FileUploadSikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		//driver.findElement(By.xpath("//*[@id=\"ta1\"]")).sendKeys("Upload a file testing");
		driver.wait(30);
		driver.findElement(By.xpath("//*[@id=\"input-4\"]")).click();
		
		String inputFilePath = "C:\\Users\\bhsul\\OneDrive\\Pictures\\Saved Pictures";
		String docFilePath = "C:\\Users\\bhsul\\OneDrive\\Pictures\\Saved Pictures";
		
		Screen screen = new Screen();
		Pattern filePathTxtBx = new Pattern(inputFilePath+"FileNameSnip.png");
		Pattern openButton = new Pattern(inputFilePath+"OpenSnip.png");
		Thread.sleep(3000);
		screen.wait(filePathTxtBx, 20);
		screen.type(filePathTxtBx, docFilePath+"Flower.jpg");
		screen.click(openButton);
	}

}
