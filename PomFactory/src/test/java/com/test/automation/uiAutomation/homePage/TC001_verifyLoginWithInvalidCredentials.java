package com.test.automation.uiAutomation.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_verifyLoginWithInvalidCredentials extends TestBase {

	HomePage hPage;

	@BeforeTest
	public void setUp() throws Exception {
		init();
		log.info("before test");
	}

	@Test
	public void verifyLoginWithInvalidCredentials() {
		hPage = new HomePage(driver);
		log.info("---------Test Started");
		hPage.loginToApplication("test@gmail.com", "passwordtest");
		Assert.assertEquals(hPage.getTextOffailed(), "Authentication failed.");
	}

	@AfterTest
	public void endTest() {
		log.info("Driver Quiting");
		driver.quit();

	}

}
