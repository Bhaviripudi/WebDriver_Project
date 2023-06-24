package learning.selenium.extentReports;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReports {

	ExtentReports report; // Specify the location of the report
	ExtentTest test; // What details should be populated in the reports

	@BeforeTest
	public void startReport() {

		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/MyReport.html", true);
		report.addSystemInfo("Host Name", "LocalHost");
		report.addSystemInfo("Environment", "Dev");
		report.addSystemInfo("User Name", "Sulochana");
		report.loadConfig(new File(System.getProperty("user.dir") +"\\extent-config.xml"));
		//report.loadConfig(new File("C:\\Users\\bhsul\\Java_Automation_workspace\\WebDriver_Project\\extent-config.xml"));
	}

	@Test
	public void reportPass() {

		test = report.startTest("Report passed");
		assertTrue(true);
		test.log(LogStatus.PASS, "passed as condition is true");
	}

	@Test
	public void reportFail() {

		test = report.startTest("Report failed");
		assertTrue(false);
		test.log(LogStatus.FAIL, "failes as condition fails");

	}

	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		report.endTest(test);
	}

	@AfterTest
	public void endReport() {

		report.flush();
	}

}
