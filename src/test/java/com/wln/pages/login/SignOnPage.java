package com.wln.pages.login;

import org.openqa.selenium.By;

import com.wln.bo.User;
import com.wln.drivers.DriverUtils;
import com.wln.pages.BasePage;

public class SignOnPage extends BasePage {

	private static final By userNameTxtBy = By.name("Username");
	private static final By passwordTxtBy = By.name("Password");
	private static final By signInBtnBy = By.name("SignIn");

	public SignOnPage(DriverUtils driver) {
		super(driver);
	}

	public ClientIdPage setUsernamePasswordAndSignOn(User user) {
		enterUserName(user.getUserName());
		enterPassword(user.getPassword());
		clickSignInButton();
		return new ClientIdPage(driver);
	}

	public void enterUserName(String userName) {
		logger.info("Enter UserName: " + userName);
		driver.findElement(userNameTxtBy).sendKeys(userName);
	}

	public void enterPassword(String password) {
		logger.info("Enter Password: " + password);
		driver.findElement(passwordTxtBy).sendKeys(password);
	}

	public void clickSignInButton() {
		logger.info("Click Sign-In button");
		driver.findElement(signInBtnBy).click();
	}
}
