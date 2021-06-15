package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.components.companyinvestigator.PublicRecordsComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.browse.BrowsePage;

public class CompanyInvestigatorPage extends BrowsePage {

	private static final By companyNameTxtBy = By.id("co_search_advancedSearch_NA");
	private static final By addressTxtBy = By.id("co_search_advancedSearch_ADDR");
	private static final By searchBtnBy = By.id("co_search_advancedSearchButton_top");

	private PublicRecordsComponent publicRecordsComponent;

	public CompanyInvestigatorPage(DriverUtils driver) {
		super(driver);
		publicRecordsComponent = new PublicRecordsComponent(driver);
	}

	public PublicRecordsComponent getPublicRecordsComponent() {
		return publicRecordsComponent;
	}

	public CompanyInvestigatorPage enterCompanyName(String companyName) {
		logger.info("Enter Company Name: " + companyName);
		driver.findElement(companyNameTxtBy).clear();
		driver.findElement(companyNameTxtBy).sendKeys(companyName);
		return this;
	}

	public CompanyInvestigatorPage enterAddress(String address) {
		logger.info("Enter Address: " + address);
		driver.findElement(addressTxtBy).clear();
		driver.findElement(addressTxtBy).sendKeys(address);
		return this;
	}

	public CompanyInvestigatorSeachResultsPage clickSearchButton() {
		logger.info("Click Search button.");
		driver.findElement(searchBtnBy).click();
		return new CompanyInvestigatorSeachResultsPage(driver);
	}

}
