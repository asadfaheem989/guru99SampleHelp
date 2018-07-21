package com.guru99.qa.base;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.qa.util.TestUtil;



public class TestBase {

	public static WebDriver driver; 
	public static Properties prop; 
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Ace\\eclipse-workspace\\guru99PracticePOM1\\src\\main\\java\\com\\guru99\\qa\\config\\config.properties");
			prop.load(ip);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	
	public static void intialization(String browserName) {
		//browserName = prop.getProperty("browser"); 
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\Ace\\eclipse-workspace\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\Ace\\eclipse-workspace\\Selenium\\geckodriver.exe"); 
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,  TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url")); 
		
	}
}
