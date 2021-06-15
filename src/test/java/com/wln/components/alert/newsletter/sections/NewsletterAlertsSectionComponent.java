package com.wln.components.alert.newsletter.sections;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class NewsletterAlertsSectionComponent extends BaseComponent{
	
	private static final By alertsSectionBy = By.xpath("//li[@id='contentSection'and not(@class='co_collapsed')]");
	private static final By continueBtnBy = By.id("co_button_continue_Content");
	private static final By alertsListContainerBy  = By.id("co_facet_Alert_availableOptions");
	
	private static final String ADD_ALERT_FORMAT = ".//li[contains(@id,'co_facetItem_Alert')]//p[contains(.,'%s')]/preceding-sibling::i";

	public NewsletterAlertsSectionComponent(DriverUtils driver) {
		super(driver);
	}
	
	public NewsletterAlertsSectionComponent addAlert(String alertName) {
		logger.info("Select Alert: " + alertName);
		String addAlertIcon = String.format(ADD_ALERT_FORMAT, alertName);
		driver.findElement(alertsListContainerBy).findElement(By.xpath(addAlertIcon)).click();
		return this;
	}
	
	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}
	
	public boolean isAlertsSectionDisplayed() {
		boolean isAlertsDisplayed = driver.isElementDisplayed(alertsSectionBy);
		logger.info("Is Alerts section displayed? " + isAlertsDisplayed);
		return isAlertsDisplayed;
	}
	
	public void waitForAlertsSection() {
		logger.info("Wait For Alerts section to be displayed.");
		driver.waitForElementDisplayed(alertsSectionBy);
	}

}
