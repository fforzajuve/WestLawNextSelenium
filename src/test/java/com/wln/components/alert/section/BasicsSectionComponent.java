package com.wln.components.alert.section;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.dialogs.alert.ChangeClientIdDialog;
import com.wln.drivers.DriverUtils;

public class BasicsSectionComponent extends BaseComponent {

	private static final By basicSectionBy = By.xpath("//li[@id='basicsSection'and not(@class='co_collapsed')]");
    private static final By alertNameTxtBy = By.id("optionsAlertName");
	private static final By alertDescriptionTxtBy = By.id("optionsAlertDescription");
	private static final By citationTxtBy = By.id("optionsAlertCitation");
	private static final By clientIdLblBy = By.className("co_clientIDInline_recent");
	private static final By changeClientIdBtnBy = By.className("co_clientIDInline_change");
	private static final By continueBtnBy = By.id("co_button_continue_Basics");
	
	
	private BasicsSummaryComponent basicsSummaryComponent;
	

	public BasicsSectionComponent(DriverUtils driver) {
		super(driver);
		basicsSummaryComponent = new BasicsSummaryComponent(driver);
	}
	
	public BasicsSummaryComponent getBasicsSummaryComponent() {
		return basicsSummaryComponent;
	}
	
	public BasicsSectionComponent enterAlertName(String alertName) {
		logger.info("Enter Alert Name: " + alertName);
		driver.findElement(alertNameTxtBy).sendKeys(alertName);
		return this;
	}
	
	public String getAlertName() {
		logger.info("Get Alert Name.");
		String alertName = driver.findElement(alertNameTxtBy).getAttribute("value").trim();
		logger.info("Alert Name: " + alertName);
		return alertName;
	}
	
	public BasicsSectionComponent enterDescription(String desc) {
		logger.info("Enter Alert Description: " + desc);
		driver.findElement(alertDescriptionTxtBy).sendKeys(desc);
		return this;
	}
	
	public String getAlertDescription() {
		logger.info("Get Alert Description.");
		String desc = driver.findElement(alertDescriptionTxtBy).getAttribute("value").trim();
		logger.info("Alert Description: " + desc);
		return desc;
	}
	
	public BasicsSectionComponent enterCitation(String citation) {
		logger.info("Enter Alert Citation: " + citation);
		driver.findElement(citationTxtBy).sendKeys(citation);
		return this;
	}
	
	public String getCitation() {
		logger.info("Get Citation.");
		String citation = driver.findElement(citationTxtBy).getAttribute("value").trim();
		logger.info("Citation: " + citation);
		return citation;
	}
	
	public String getClientId() {
		logger.info("Get Client ID.");
		String clientId = driver.findElement(clientIdLblBy).getText();
		logger.info("Client ID: " + clientId);
		return clientId;
	}
	
	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();

	}

	public boolean isBasicsSectionDisplayed() {
		boolean isBasicsDisplayed = driver.isElementDisplayed(basicSectionBy);
		logger.info("Is Basics section displayed? " + isBasicsDisplayed);
		return isBasicsDisplayed;
	}
	
	public void waitForBasicsSection() {
		logger.info("Wait For Basics section to be displayed.");
		driver.waitForElementDisplayed(basicSectionBy);
	}
	
	public BasicsSectionComponent changeClientId(String clientId) {
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
