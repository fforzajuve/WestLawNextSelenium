package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.pages.browse.BrowsePage;
import com.wln.pages.search.SearchResultsPage;

public class DunBradstreetReportsSearchPage extends BrowsePage {
	
	private static final By companyNameTxtBy = By.id("co_search_advancedSearch_CN");
	private static final By dunsNumberTxtBy = By.id("co_search_advancedSearch_DUNS");
	private static final By cityTxtBy = By.id("co_search_advancedSearch_CY");
	private static final By searchBtnBy = By.id("co_search_advancedSearchButton_top");

	public DunBradstreetReportsSearchPage(DriverUtils driver) {
		super(driver);
	}

	public DunBradstreetReportsSearchPage enterCompanyName(String companyName) {
		logger.info("Enter Company Name: " + companyName);
		driver.findElement(companyNameTxtBy).sendKeys(companyName);
		return this;
	}

	public DunBradstreetReportsSearchPage enterDunsNumber(String number) {
		logger.info("Enter Duns Number: " + number);
		driver.findElement(dunsNumberTxtBy).sendKeys(number);
		return this;
	}
	
	public DunBradstreetReportsSearchPage enterCity(String city) {
		logger.info("Enter City: " + city);
		driver.findElement(cityTxtBy).sendKeys(city);
		return this;
	}
	
	public SearchResultsPage clickSearchButton() {
		logger.info("Click Search Button");
		driver.findElement(searchBtnBy).click();
		return new SearchResultsPage(driver);
	}
}
