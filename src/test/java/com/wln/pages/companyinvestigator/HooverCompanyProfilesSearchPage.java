package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.pages.browse.BrowsePage;

public class HooverCompanyProfilesSearchPage extends BrowsePage {
	
	private static final By companyNameTxtBy = By.id("co_search_advancedSearch_CN");
	private static final By tickerTxtBy = By.id("co_search_advancedSearch_CTIK");

	public HooverCompanyProfilesSearchPage(DriverUtils driver) {
		super(driver);
	}
	
	public HooverCompanyProfilesSearchPage enterCompanyName(String companyName) {
		logger.info("Enter Company Name: " + companyName);
		driver.findElement(companyNameTxtBy).sendKeys(companyName);
		return this;
	}
	
	public HooverCompanyProfilesSearchPage enterTickerSymbol(String ticker) {
		logger.info("Enter Ticker: " + ticker);
		driver.findElement(tickerTxtBy).sendKeys(ticker);
		return this;
	}

}
