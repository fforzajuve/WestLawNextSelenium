package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;

public class CompanyFamilyTreePage extends CompanyPage {
	
	private static final By familyTreeBy = By.id("paper-container");

	public CompanyFamilyTreePage(DriverUtils driver) {
		super(driver);
	}

	public boolean isFamilyTreeDisplayed() {
		boolean isFamilyTreeDisplayed = driver.isElementDisplayed(familyTreeBy);
		logger.info("Is family tree displayed? " + isFamilyTreeDisplayed);
		return isFamilyTreeDisplayed;
	}
}
