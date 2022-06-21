package com.java.testNG.Initiliazer;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseSetup {
	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest testLog;

	public static String reportDes = "./src\\test\\resources\\Extents_Reports\\Extent.html";
	public static String path = "./src\\test\\resources\\FailedScreenshots\\";

	public static ExtentReports extentReports() {
		htmlReporter = new ExtentHtmlReporter(reportDes);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Automation Test Suite Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		return extent;

	}

	@BeforeSuite(alwaysRun = true)
	public void reportSetup() {
		extentReports();

	}

	@AfterSuite
	public void reportFlush() {
		extent.flush();
	}

	public static String timeStamp() {
		return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	}

	public static WebDriver customBrowser() throws IOException {
		String browser = getPropertyData("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get(getPropertyData("URL"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			driver.get(getPropertyData("URL"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		return driver;

	}

	public static String getPropertyData(String key) throws IOException {

		String value;
		FileReader fr = new FileReader("./src\\test\\resources\\PropertyFileReader\\testData.Properties");

		Properties p = new Properties();
		p.load(fr);
		value = p.getProperty(key);

		return value;

	}

}
