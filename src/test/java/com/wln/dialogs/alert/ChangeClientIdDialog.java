package com.wln.dialogs.alert;

import org.openqa.selenium.By;

import com.wln.dialogs.BaseDialog;
import com.wln.drivers.DriverUtils;

public class ChangeClientIdDialog extends BaseDialog {
	
	private static final By clientIdTxtBy = By.name("clientIdTextbox");
	private static final By changeBtnBy = By.id("co_clientIDOOPContinueButton");
	private static final By cancelBtnBy = By.id("co_clientIDOOPCancelLink");

	public ChangeClientIdDialog(DriverUtils driver) {
		super(driver);
		driver.waitForElementDisplayed(clientIdTxtBy);
	}
	
	public void changeClientId(String clientId) {
		logger.info("Change Client Id to " + clientId);
		driver.waitForElementDisplayed(clientIdTxtBy);
		driver.findElement(clientIdTxtBy).clear();
		driver.findElement(clientIdTxtBy).sendKeys(clientId);
		driver.findElement(changeBtnBy).click();
		driver.waitForElementNotDisplayed(clientIdTxtBy);
	}
	
	public ChangeClientIdDialog enterNewClientId(String clientId) {
		logger.info("Enter Client Id: " + clientId);
		driver.waitForElementDisplayed(clientIdTxtBy);
		driver.findElement(clientIdTxtBy).clear();
		driver.findElement(clientIdTxtBy).sendKeys(clientId);
		return this;
	}

	public void clickChangeButton() {
		logger.info("Click Change button");
		driver.findElement(changeBtnBy).click();
	}
	

	public void clickCancelButton() {
		logger.info("Click Cancel button");
		driver.findElement(cancelBtnBy).click();
	}
}
