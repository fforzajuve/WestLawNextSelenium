package com.wln.components.alert;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.AlertsCenterPage;

public class AlertNavigationMenuComponent extends BaseComponent {

	private static final By navContainerBy = By.id("co_alertNav_menu");
	private static final By alertsBy = By.linkText("Alerts");
	private static final By newsletterBy = By.linkText("Newsletters");
	private static final By reportsBy = By.linkText("Reports");

	public AlertNavigationMenuComponent(DriverUtils driver) {
		super(driver);
	}

	public AlertsCenterPage selectAlerts() {
		logger.info("Select Alerts.");
		driver.findElement(navContainerBy).findElement(alertsBy).click();
		return new AlertsCenterPage(driver);
	}

	public AlertsCenterPage selectNewsletters() {
		logger.info("Select Newsletters.");
		driver.findElement(navContainerBy).findElement(newsletterBy).click();
		return new AlertsCenterPage(driver);
	}

	public AlertsCenterPage selectReports() {
		logger.info("Select Reports.");
		driver.findElement(navContainerBy).findElement(reportsBy).click();
		return new AlertsCenterPage(driver);
	}

}
