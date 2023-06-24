package learning.selenium.jsCommands;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtils {

	public static void flash(WebElement element, WebDriver driver) {

		String bgColor = element.getCssValue("backgroundColor"); // green

		for (int i = 0; i < 10; i++) {

			changeColor("#000000", element, driver);// 1
			changeColor(bgColor, element, driver);// 2

		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void drawBorder(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static String getTitleJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static void clickElement(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}
	public static void refreshJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
}
