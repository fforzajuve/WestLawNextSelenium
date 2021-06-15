package com.wln.components.alert;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.alert.AlertType;
import com.wln.pages.alert.AlertsCenterPage;

public class AlertTypeComponent extends BaseComponent {

	private static final By alertTypeContainerBy = By.id("coid_alertType");
	private static final By activeAlertTypeLnkBy = By.xpath("//li[@class='co_leftColumn_activePage']//a");
	
	
	private static final String ALERT_TYPE_FORMAT = ".//li//a[contains(.,'%s')]";
	
	public AlertTypeComponent(DriverUtils driver) {
		super(driver);
	}
	
	public boolean isAlertTypesDisplayed() {
		boolean isAlertTypesDisplayed = driver.isElementDisplayed(alertTypeContainerBy);
		logger.info("Is Alert Types Displayed? "+ isAlertTypesDisplayed);
		return isAlertTypesDisplayed;
	}
	
	public int getAlertTypesNumber() {
		logger.info("Get Alert Types Number.");
		int alertTypesNumber = driver.findElement(alertTypeContainerBy).findElements(By.tagName("li")).size();
		logger.info("Alert Types Number: " + alertTypesNumber);
		return alertTypesNumber;
	}
	
	public AlertType getActiveAlertType() {
		logger.info("Get Active Alert Type.");
		String alertType = driver.findElement(alertTypeContainerBy).findElement(activeAlertTypeLnkBy).getText();
		logger.info("Active Alert Type: " + alertType);
		return AlertType.getFrom(alertType);
	}
	
	public AlertsCenterPage selectAlertType(AlertType alertType) {
		if(alertType != getActiveAlertType()) {
			String alertTypeLink = String.format(ALERT_TYPE_FORMAT, alertType.getName());
			driver.findElement(alertTypeContainerBy).findElement(By.xpath(alertTypeLink)).click();
		}
		return new AlertsCenterPage(driver);
	}

}
