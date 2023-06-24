package learning.selenium.ashotAPI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		BufferedImage expctdImage = ImageIO
				.read(new File("C:\\Users\\bhsul\\OneDrive\\Pictures\\Screenshots\\OrangeHRM.png")); // expected image
		WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[2]/img")); // finding path
		Screenshot logoShot = new AShot().takeScreenshot(driver, logoElement); // take screenshot
		BufferedImage actImag = logoShot.getImage(); // get the image

		ImageDiffer imageDiffer = new ImageDiffer();
		ImageDiff diff = imageDiffer.makeDiff(expctdImage, actImag); // store the difference if any
		if (diff.hasDiff() == true) { // has any difference
			System.out.println("Images not matched");
		} else
			System.out.println("Images matched");
	}

}
