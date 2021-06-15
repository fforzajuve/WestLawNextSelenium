package com.wln.components.alert.section;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class BasicsSummaryComponent extends BaseComponent {
	
	private static final By basicsSummaryContainerBy = By.id("basicSummaryDiv");
	private static final By summaryAlertNameLblBy = By.id("summaryAlertName");
	private static final By summaryAlertClientIdLblBy = By.id("summaryAlertClientId");
	private static final By summaryDescriptionLblBy = By.id("summaryDescriptionHeading");
	private static final By summaryCitationLblBy = By.id("summaryCiteHeading");

	public BasicsSummaryComponent(DriverUtils driver) {
		super(driver);
	}
	
	public String getSummaryAlertName() {
		logger.info("Get Summary Alert Name.");
		String summaryAlertName = driver.findElement(basicsSummaryContainerBy).findElement(summaryAlertNameLblBy).getText();
		logger.info("Summary Alert Name: " + summaryAlertName);
		return summaryAlertName;
	}
	
	public String getSummaryDescription() {
		logger.info("Get Summary Description.");
		String summaryDesc = driver.findElement(summaryDescriptionLblBy).getText().split(":")[1];
		logger.info("Summary Description: " + summaryDesc.trim());
		return summaryDesc.trim();
	}

	public String getSummaryCitation() {
		logger.info("Get Cite.");
		String citation = driver.findElement(summaryCitationLblBy).getText().split(":")[1];
		logger.info("Summary Cite: " + citation.trim());
		return citation.trim();
	}
	
	public String getSummaryClientId() {
		logger.info("Get Client ID.");
		String clientId = driver.findElement(summaryAlertClientIdLblBy).getText().split(":")[1];
		logger.info("Summary Client ID: " + clientId.trim());
		return clientId.trim();
	}
}
