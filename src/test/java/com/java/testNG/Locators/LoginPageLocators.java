package com.java.testNG.Locators;

public class LoginPageLocators {

	protected String username_id, password_id, loginButton_Xpath;

	public LoginPageLocators() {

		username_id = "id_username";
		password_id = "id_password";
		loginButton_Xpath = "//button[contains(text(),'Login')]";

	}

}
