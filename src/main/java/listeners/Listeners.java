package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	public ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		 
		 extentTest = extentReport.createTest(result.getName()+"Execution Started");
		 extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTestThread.get().log(Status.PASS, "Test Passed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		String testMethodName = result.getName();
		
		
		try {
			
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			
			String screenshotFilePath = takeScreenShot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath,testMethodName);
			
			//takeScreenShot(testMethodName,driver);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	
	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}

	

	
}
