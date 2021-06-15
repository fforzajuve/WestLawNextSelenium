package com.wln.components.alert.section;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class DeliverySummaryComponent extends BaseComponent {
	
	private static final By deliveySummaryContainerBy = By.id("deliverySummaryDiv");
	private static final By summaryFormatLblBy = By.id("deliverFormat");
	private static final By summaryRecipientsLblBy = By.id("summaryRecipients");

	public DeliverySummaryComponent(DriverUtils driver) {
		super(driver);
	}

	public String getSummaryFormat() {
		logger.info("Get Summary Format.");
		String summaryFormat = driver.findElement(deliveySummaryContainerBy).findElement(summaryFormatLblBy).getText();
		logger.info("Summary Format: " + summaryFormat);
		return summaryFormat;
	}
	
	public String getSummaryRecipients() {
		logger.info("Get Summary Recipients.");
		String summaryRecipients = driver.findElement(deliveySummaryContainerBy).findElement(summaryRecipientsLblBy).getText();
		logger.info("Summary summaryRecipientsLblBy: " + summaryRecipients);
		return summaryRecipients;
	}
}
