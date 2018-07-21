package com.guru99.qa.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentScShot  {
	public static ExtentReports extent; 
	
	public static ExtentTest extentTest;
	
	public ExtentScShot() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport1.html", true);	
	}


}
