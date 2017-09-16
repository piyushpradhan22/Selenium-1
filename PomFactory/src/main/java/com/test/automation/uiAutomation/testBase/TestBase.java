package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.automation.uiAutomation.excelReader.ExcelReader;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	public ExcelReader excel;
	public static ExtentReports extent;
	public static ExtentTest test;

	static {
		DateFormat df = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		Date date = new Date();
		String dateStamp = df.format(date);
		extent = new ExtentReports(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\test\\automation\\uiAutomation\\report\\" + dateStamp + "test.html", false);
	}

	public void init() throws Exception {
		launchBrowser("chrome");
		getUrl("http://newtours.demoaut.com");
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		Thread.sleep(10000);
	}

	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			log.info("Launching Chrome");
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
	public String[][] getData(String sheetName1, String excelName1) throws Exception {
		excel = new ExcelReader(System.getProperty("user.dir")
				+ "//src//main//java//com//test//automation//uiAutomation/data//TestData.xlsx");
		String[][] data = excel.getDataFromSheet(sheetName1, excelName1);
		return data;
	}

	public String getScreenshot(String sName) {
		File destFile = null;
		try {
			DateFormat df = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
			Date date = new Date();
			String dateStamp = df.format(date);
			File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			destFile = new File(System.getProperty("user.dir")
					+ "//src//main//java//com//test//automation//uiAutomation//screenshot//" + sName + "_" + dateStamp
					+ ".png");
			FileUtils.copyFile(scrfile, destFile);
			Reporter.log("<a href ='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "'height = '100' width = '100'/> </a>");
		} catch (Exception e) {
			System.out.println("Error taking Screenshot :");
			e.printStackTrace();
		}
		return destFile.getAbsolutePath();
	}

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String sc = getScreenshot(result.getName());
			test.log(LogStatus.PASS, " Test is passed" + test.addScreenCapture(sc));
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed--" + result.getThrowable());
		}
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and the reason is " + result.getThrowable());
		}
		if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started--");
		}
	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		driver.quit();
		log.info("Browser closed");
		extent.endTest(test);
		extent.flush();
	}

}
