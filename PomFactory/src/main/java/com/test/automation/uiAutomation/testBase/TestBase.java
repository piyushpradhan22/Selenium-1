package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.automation.uiAutomation.excelReader.ExcelReader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	public ExcelReader excel;

	public void init() throws InterruptedException {
		launchBrowser("chrome");
		getUrl("file:///" + System.getProperty("user.dir") + "\\Demo\\demoSite.htm");
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		Thread.sleep(10000);
	}

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			log.info("Launching Firefox");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	public void getUrl(String url) {
		driver.get(url);
		log.info("Navigating Url");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	// Excel Getdata
	public String[][] getData(String sheetName1,String excelName1) throws Exception {
		excel = new ExcelReader(System.getProperty("user.dir") + "//src//main//java//com//test//automation//uiAutomation/data//TestData.xlsx");
		String[][] data = excel.getDataFromSheet(sheetName1, excelName1);
		return data;
	}

}
