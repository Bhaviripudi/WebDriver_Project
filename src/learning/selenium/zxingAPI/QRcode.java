package learning.selenium.zxingAPI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.xmlgraphics.util.ImageIODebugUtil;
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

public class QRcode {

	public static void main(String[] args) throws IOException, NotFoundException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://barcode.tec-it.com/en/QRCode?data=This%20is%20a%20QR%20Code%20by%20TEC-IT");

		String qrUrl = driver.findElement(By.xpath("//*[@id=\"infoTarget\"]/div[1]/img")).getAttribute("src");
		URL url = new URL(qrUrl);
		BufferedImage bufferedImage = ImageIO.read(url);
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println(result.getText());
	}

}
