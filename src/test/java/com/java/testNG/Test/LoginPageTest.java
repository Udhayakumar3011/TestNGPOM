package com.java.testNG.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.java.testNG.Initiliazer.MyOwnListernersTest;
import com.java.testNG.Initiliazer.baseSetup;
import com.java.testNG.Pages.LoginPages;

//@Listeners(MyOwnListernersTest.class)
public class LoginPageTest extends baseSetup {

	public static WebDriver driver;
	public static LoginPages loginpages;
	public static ExtentTest test;

	@BeforeSuite
	public void launchBrowser() throws IOException {
		if ((driver == null)) {
			driver = baseSetup.customBrowser();
		}
	}

	@Test(priority = 0)
	public void login() throws IOException {
		test = extent.createTest("Login");

		loginpages = new LoginPages(driver);
		loginpages.username();
		loginpages.password();
		loginpages.loginButton();
		test.log(Status.PASS, "Login TC is Passed");

	}

	@Test(priority = 1)
	public void Jquery() throws IOException {
		test = extent.createTest("Jquery");
		String expectedResult = "Google";
		String actualResult = "Gogle";
		driver.get("https://jqueryui.com/autocomplete/");
		Assert.assertEquals(expectedResult, actualResult);
		test.log(Status.PASS, "Jquery Login TC is Passed");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		System.out.println("Execution Completed");

		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(path + result.getName() + " " + timeStamp() + ".png"));
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(reportDes).build());
			test.log(Status.FAIL, " TC is Failed");
		} else {
			test.log(Status.PASS, " TC is Passed");
		}
	}
}
