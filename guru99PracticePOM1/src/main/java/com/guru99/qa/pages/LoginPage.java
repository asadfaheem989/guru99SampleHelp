package com.guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(linkText = "Demo Site")
	WebElement demoIcon; 
	@FindBy(xpath = "//a[contains(text(), 'Selenium') and @class='dropdown-toggle']")
	WebElement seleniumTab ; 
	@FindBy(xpath = "//a[contains(text(), 'Insurance Project')]")
	WebElement InsuranceProjectTab; 
	@FindBy(xpath ="//a[contains(text(), 'Agile Project')]" )
	WebElement AgileProjectTab ; 
	@FindBy(xpath ="//a[contains(text(), 'Bank Project') and @data-toggle='dropdown']" )
	WebElement bankProjectTab; 
	@FindBy(xpath = "//a[contains(text(), 'Security Project')]" )
	WebElement securityProjectTab ; 
	@FindBy(xpath = "//a[contains(text(), 'Telecom Project')]")
	WebElement telecomProjectTab;
	@FindBy(xpath = "//a[contains(text(), 'Payment Gateway')]")
	WebElement paymentGatewayProjectTab; 
	@FindBy(xpath = "//a[contains(text(), 'New Tours')]")
	WebElement newToursTab; 
	@FindBy(xpath = "//input[@type='submit' and @name='btnLogin']")
	WebElement loginBtn ; 
	@FindBy(xpath = "//input[@type='reset']" )
	WebElement resetBtn ;
	@FindBy(xpath = "//a[contains(text(), 'here')]")
	WebElement viewLink;
	@FindBy(xpath = "//input[@type='text' and @maxlength = '10']")
	WebElement userIDField; 
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String loginPageTitle() {
		return driver.getTitle(); 
	}
	
	public void loginSetup(String username, String password) {
		
		userIDField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	 

	
}
