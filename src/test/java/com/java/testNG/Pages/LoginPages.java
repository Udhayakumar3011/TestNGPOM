package com.java.testNG.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.java.testNG.Initiliazer.baseSetup;
import com.java.testNG.Locators.LoginPageLocators;

public class LoginPages extends LoginPageLocators {

	public static WebDriver driver;

	public LoginPages(WebDriver driver) {
		this.driver = driver;
	}

	public void username() throws IOException {
		WebElement username = driver.findElement(By.id(username_id));
		username.click();
		username.sendKeys(baseSetup.getPropertyData("username"));
	}

	public void password() throws IOException {
		WebElement password = driver.findElement(By.id(password_id));
		password.click();
		password.sendKeys(baseSetup.getPropertyData("password"));
	}

	public void loginButton() {
		WebElement loginButton = driver.findElement(By.xpath(loginButton_Xpath));
		loginButton.click();

		// Validation
		WebElement loggedUsername = driver.findElement(By.xpath("//a[contains(text(),'Udhay')]"));
		String expRes = loggedUsername.getText();
		System.out.println("Result" + " " + expRes);
		Assert.assertEquals(expRes, "Udhay");
	}
}
