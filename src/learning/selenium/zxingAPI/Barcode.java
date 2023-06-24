package learning.selenium.zxingAPI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Barcode {

	public static void main(String[] args) throws IOException, NotFoundException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://barcode.tec-it.com/en/Code128?data=ABC-abc-1234");
		String barcodeUrl = driver.findElement(By.xpath("//*[@id=\"infoTarget\"]/div[1]/img")).getAttribute("src");
		System.out.println(barcodeUrl);
		
		URL url = new URL(barcodeUrl);
		BufferedImage bufferedImage = ImageIO.read(url);
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitMap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result result = new MultiFormatReader().decode(binaryBitMap);
		System.out.println(result.getText());
		
	}

}
