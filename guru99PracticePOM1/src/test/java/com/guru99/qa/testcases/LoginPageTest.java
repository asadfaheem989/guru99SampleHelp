package com.guru99.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.guru99.qa.base.TestBase;
import com.guru99.qa.pages.LoginPage;
import com.guru99.qa.util.ExtentScShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	public ExtentReports extent;
	public ExtentTest extentTest;
	ExtentScShot extentScShot = new ExtentScShot(); 


	public LoginPageTest() {
		super();
	}
	@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport1.html", true);
		//extent = ExtentScShot.extent;
		extent.addSystemInfo("Host Name", "Naveen Mac");
		extent.addSystemInfo("User Name", "Naveen Automation Labs");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	private static final Logger log = LogManager.getLogger("check123");

	@BeforeMethod
	public void setUp() {

		log.info("***********************Startmethod**********************");
		intialization("chrome");
		loginPage = new LoginPage();

	}

	@Test(enabled = false)
	public void loginPageTitleVerificationTest() {
		log.info("***********************First Test Started**********************");
		String title = loginPage.loginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
		log.info("***********************FirstTest Ended**********************");
	}

	@Test
	public void loginSetupTest() throws InterruptedException {
		extentTest = extent.startTest("loginSetupTest");
		log.info("***********************2ndTestStarted**********************");
		loginPage.loginSetup(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "Guru999 Bank Manager HomePage");
		log.info("***********************2ndTestFinished**********************");
		try {

			Assert.assertEquals(homePageTitle, "Guru9999 Bank Manager HomePage");
			log.info("******************it works************");
		} catch (AssertionError e) {
			log.error(e);

		}
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = LoginPageTest.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest);

		log.info("***********************teardowntime**********************");
		driver.close();
	}
}
