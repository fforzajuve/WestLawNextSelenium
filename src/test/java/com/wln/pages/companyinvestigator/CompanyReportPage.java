package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;

public class CompanyReportPage extends CompanyPage{
	
	private static final By imageBy = By.id("ReportTab");

	public CompanyReportPage(DriverUtils driver) {
		super(driver);
	}
	
	public boolean isReportImageDisplayed() {
		boolean isImageDisplayed = driver.isElementDisplayed(imageBy);
		logger.info("Is image displayed? " + isImageDisplayed);
		return isImageDisplayed;
	}

}
