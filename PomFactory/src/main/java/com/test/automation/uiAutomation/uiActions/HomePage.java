package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {
	WebDriver driver;
   
	@FindBy(xpath = "//a[contains(text(),'SIGN-ON')]")
	WebElement signIn;
	
	@FindBy(name="userName")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(name="login")
	WebElement login;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
	WebElement signOut;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String hloginEmail, String hloginPassword) throws Exception {
		signIn.click();
		userId.sendKeys(hloginEmail);
		pass.sendKeys(hloginPassword);
		login.click();
		Thread.sleep(2000);
		signOut.click();
	}
}
