package com.wln.components.alert.ci.sections;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.dialogs.alert.ChangeClientIdDialog;
import com.wln.drivers.DriverUtils;

public class CompanyInvestigatorBasicsSectionComponent extends BaseComponent {
	
	private static final By basicsSectionBy = By.xpath("//li[@id='basicsSection'and not(@class='co_collapsed')]");
	private static final By alertNameTxtBy = By.id("optionsAlertName");
	private static final By alertDescriptionTxtBy = By.id("optionsAlertDescription");
	private static final By continueBtnBy = By.id("co_button_continue_Basics");
	private static final By clientIdLblBy = By.className("co_clientIDInline_recent");
	private static final By changeClientIdBtnBy = By.className("co_clientIDInline_change");


	public CompanyInvestigatorBasicsSectionComponent(DriverUtils driver) {
		super(driver);
	}
	
	public CompanyInvestigatorBasicsSectionComponent enterAlertName(String alertName) {
		logger.info("Enter Alert Name: " + alertName);
		driver.findElement(alertNameTxtBy).clear();
		driver.findElement(alertNameTxtBy).sendKeys(alertName);
		return this;
	}

	public String getAlertName() {
		logger.info("Get Alert Name.");
		String name = driver.findElement(alertNameTxtBy).getAttribute("value").trim();
		logger.info("Alert Name: " + name);
		return name;
	}

	public CompanyInvestigatorBasicsSectionComponent enterDescription(String desc) {
		logger.info("Enter Alert Description: " + desc);
		driver.findElement(alertDescriptionTxtBy).clear();
		driver.findElement(alertDescriptionTxtBy).sendKeys(desc);
		return this;
	}

	public String getAlertDescription() {
		logger.info("Get Alert Description.");
		String desc = driver.findElement(alertDescriptionTxtBy).getAttribute("value").trim();
		logger.info("Alert Description: " + desc);
		return desc;
	}
	
	
	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}

	public boolean isBasicsSectionDisplayed() {
		boolean isBasicsDisplayed = driver.isElementDisplayed(basicsSectionBy);
		logger.info("Is Basics section displayed? " + isBasicsDisplayed);
		return isBasicsDisplayed;
	}

	public void waitForBasicsSection() {
		logger.info("Wait For Basics section to be displayed.");
		driver.waitForElementDisplayed(basicsSectionBy);
	}
	
	public String getClientId() {
		logger.info("Get Client ID.");
		String clientId = driver.findElement(clientIdLblBy).getText();
		logger.info("Client ID: " + clientId);
		return clientId;
	}
	
	public CompanyInvestigatorBasicsSectionComponent changeClientId(String clientId) {
		logger.info("Change Client Id to: " + clientId );
		ChangeClientIdDialog changeClientIdDialog = openChangeClientIdDialog();
		changeClientIdDialog.changeClientId(clientId);
		return this;
	}
	
	public ChangeClientIdDialog openChangeClientIdDialog() {
		logger.info("Open Change Client Id Dialog");
		driver.findElement(changeClientIdBtnBy).click();
		return new ChangeClientIdDialog(driver);
	}

}
