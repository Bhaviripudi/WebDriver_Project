package learning.selenium.fileDwnldUpld;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FileDwnld_SavePreferredLoc {

	public static void main(String[] args) {
		
		
		
		HashMap<String, Object> chromePrefers = new HashMap<String, Object>();
		chromePrefers.put("profile.default_content_settings", 0);
		chromePrefers.put("download.prompt_for_download", false);
		chromePrefers.put("download.default_directory", "D:\\DownloadFiles");
		ChromeOptions options = new ChromeOptions(); //setting options in browser profile
		options.setExperimentalOption("prefs", chromePrefers);
		
		/*DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(cap);

		// text
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.findElement(By.id("textbox")).sendKeys("Hello Testing");
		driver.findElement(By.id("createTxt")).click();*/
	}

}
