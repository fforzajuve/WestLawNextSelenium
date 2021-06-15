package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.drivers.DriverUtils;
import com.wln.pages.browse.BrowsePage;
import com.wln.pages.search.SearchResultsPage;

public class ExperianBusinessReportsSearchPage extends BrowsePage {
	
	private static final By companyNameTxtBy = By.id("co_search_advancedSearch_CN");
	private static final By cityTxtBy = By.id("co_search_advancedSearch_CY");
	private static final By stateSelectTxtBy = By.id("co_search_advancedSearch_ST");
	private static final By searchBtnBy = By.id("co_search_advancedSearchButton_top");

	public ExperianBusinessReportsSearchPage(DriverUtils driver) {
		super(driver);
	}
	
	public ExperianBusinessReportsSearchPage enterCompanyName(String companyName) {
		logger.info("Enter Company Name: " + companyName);
		driver.findElement(companyNameTxtBy).sendKeys(companyName);
		return this;
	}

	public ExperianBusinessReportsSearchPage enterCity(String city) {
		logger.info("Enter City: " + city);
		driver.findElement(cityTxtBy).sendKeys(city);
		return this;
	}
	
	public ExperianBusinessReportsSearchPage selectState(String state) {
		logger.info("Select State: " + state);
		Select stateSelect = new Select(driver.findElement(stateSelectTxtBy));
		stateSelect.selectByVisibleText(state);
		return this;
	}
	
	public SearchResultsPage clickSearchButton() {
		logger.info("Click Search Button");
		driver.findElement(searchBtnBy).click();
		return new SearchResultsPage(driver);
	}
}
