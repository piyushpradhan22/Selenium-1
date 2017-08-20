package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;

	public void init() {
		launchBrowser("firefox");
		getUrl("http://automationpractice.com/index.php");
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			log.info("Launching Firefox");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	public void getUrl(String url) {
		driver.get(url);
		log.info("Navigating Url");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

}
