package com.wln.pages.login;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.pages.BasePage;

public class ClientIdPage extends BasePage {
	
	private static final By clientIdFieldBy = By.id("co_clientIDTextbox");
	private static final By continueBtnBy = By.id("co_clientIDContinueButton");
	private static final By expandBtnBy = By.id("co_clientIDRecentsDropdown");

	public ClientIdPage(DriverUtils driver) {
		super(driver);
	}
	
	public WlnHomePage setClientIdAndContinueToHomePage(String clientId) {
		logger.info("Enter Client ID: " + clientId);
		driver.findElement(clientIdFieldBy).clear();
		driver.findElement(clientIdFieldBy).sendKeys(clientId);
		collapseClientIdDropdown();
		driver.waitForElementDisplayed(continueBtnBy);
		driver.findElement(continueBtnBy).click();
		return new WlnHomePage(driver);
	}
	
	private void collapseClientIdDropdown(){
		if(isClientIdDropdownExpanded()) {
			driver.findElement(expandBtnBy).click();
		}
	}

	private boolean isClientIdDropdownExpanded() {
		String attrClass = driver.findElement(expandBtnBy).getAttribute("class");
		if(attrClass.contains("co_dropdownArrowExpanded")){
			return true;
		}
		else
			return false;
	}

}
