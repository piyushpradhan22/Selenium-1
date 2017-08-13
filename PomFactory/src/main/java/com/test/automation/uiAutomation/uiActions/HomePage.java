package com.test.automation.uiAutomation.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(className = "login")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement loginEmail;

	@FindBy(id = "passwd")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement submitButton;

	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement aunthenticationFailed;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String hloginEmail, String hloginPassword) {
		signIn.click();
		loginEmail.sendKeys(hloginEmail);
		loginPassword.sendKeys(hloginPassword);
		submitButton.click();
	}

	public String getTextOffailed() {
		return aunthenticationFailed.getText();

	}

}
