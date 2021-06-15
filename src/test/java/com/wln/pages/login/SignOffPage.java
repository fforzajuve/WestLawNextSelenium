package com.wln.pages.login;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.pages.BasePage;

public class SignOffPage extends BasePage {
	
	private static final By signOffMessagelblBy = By.cssSelector(".co_signOff_message > h1");
	private static final By signBackOnBtnBy = By.cssSelector(".co_signOff_message > input");

	public SignOffPage(DriverUtils driver) {
		super(driver);
	}
	
	public String getSignOffMessage() {
		logger.info("Get Sign Off Message.");
		String message = driver.findElement(signOffMessagelblBy).getText();
		logger.info("Sign Off Message: " + message);
		return message;
	}
	
	public void clickSignBackOnButton() {
		logger.info("Click Sign Back On Button.");
		driver.findElement(signBackOnBtnBy).click();
	}

}
