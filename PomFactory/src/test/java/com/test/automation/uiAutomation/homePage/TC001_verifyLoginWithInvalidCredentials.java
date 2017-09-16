package com.test.automation.uiAutomation.homePage;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

public class TC001_verifyLoginWithInvalidCredentials extends TestBase {
	HomePage hPage;
	@DataProvider(name = "loginData")
	public String[][] getTestData() throws Exception {
		String[][] testRecords = getData("Sheet1", "TestData");
		return testRecords;
	}

	@BeforeClass
	public void setUp() throws Exception {
		init();
		log.info("before test");
	}

	@Test(dataProvider = "loginData")
	public void verifyLoginWithInvalidCredentials(String aemail,String apass, String arunmode) throws Exception {
		if (arunmode.equalsIgnoreCase("n")) {
			throw new SkipException("run skipped inthw");
		}
		hPage = new HomePage(driver);
		log.info("---------Test Started");
		hPage.loginToApplication(aemail, apass);
	}
}
