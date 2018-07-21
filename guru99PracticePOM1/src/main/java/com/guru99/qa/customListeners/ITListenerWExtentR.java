package com.guru99.qa.customListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.guru99.qa.testcases.LoginPageTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ITListenerWExtentR implements ITestListener{
	
	public ExtentReports extent;
	public ExtentTest extentTest;
	WebDriver driver; 
	
	
//	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		// after execution, you could see a folder "FailedTestsScreenshots"
//		// under src folder
//		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
//				+ ".png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//	}
//	
	
	public void onTestStart(ITestResult result) {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport1.html", true);
		//extent = ExtentScShot.extent;
		extent.addSystemInfo("Host Name", "Naveen Mac");
		extent.addSystemInfo("User Name", "Naveen Automation Labs");
		extent.addSystemInfo("Environment", "QA");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFinish(ITestResult result ) throws IOException {
		}
		
		
		
		
	


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
