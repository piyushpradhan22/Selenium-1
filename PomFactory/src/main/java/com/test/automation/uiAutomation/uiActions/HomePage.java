package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "customer_login_link")
	WebElement signIn;
	
	@FindBy(id = "customer_logout_link")
	WebElement signOut;

	@FindBy(id = "CustomerEmail")
	WebElement loginEmail;

	@FindBy(id = "CustomerPassword")
	WebElement loginPassword;

	@FindBy(id = "customer_login")
	WebElement submitButton;

	@FindBy(id = "customer_logout_link")
	WebElement logOutDisplayed;
	
	@FindBy(id = "PreviewFrame")
	WebElement homePageIframe;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(WebDriver driver,String hloginEmail, String hloginPassword) {
		driver.switchTo().frame(driver.findElement(By.id("PreviewFrame")));
		signIn.click();
		loginEmail.sendKeys(hloginEmail);
		loginPassword.sendKeys(hloginPassword);
		loginPassword.submit();
		signOut.click();
		driver.switchTo().defaultContent();
	}

	public boolean mlogOutDisplayed() throws Exception {
		Thread.sleep(5000);
		return logOutDisplayed.isDisplayed();

	}

}
