package com.wln.components.search;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.document.DocumentPage;
import com.wln.pages.search.SearchResultsPage;

public class SearchComponent extends BaseComponent {

	private static final By searchInputBy = By.id("searchInputId");
	private static final By searchBtnBy = By.id("searchButton");
	private static final By jurisdictionsContainerBy = By.id("co_jurisdictionWidgetContainer");
	private static final By searchCategoryBy = By.id("co_currentSelectedCategoryText");

	public SearchComponent(DriverUtils driver) {
		super(driver);
	}

	
	public DocumentPage doSearchByCitation(String citation) {
		driver.findElement(searchInputBy).clear();
		driver.findElement(searchInputBy).sendKeys(citation);
		driver.findElement(searchBtnBy).click();
		return new DocumentPage(driver);
	}
	
	public SearchResultsPage doSearch(String searchTerm) {
		driver.findElement(searchInputBy).clear();
		driver.findElement(searchInputBy).sendKeys(searchTerm);
		driver.findElement(searchBtnBy).click();
		return new SearchResultsPage(driver);
	}
	
	public String getSearchCategory() {
		logger.info("Get Search Category.");
		String searchCategory = driver.findElement(searchCategoryBy).getText();
		logger.info("Search Category: " + searchCategory);
		return searchCategory;
	}
	
	public SearchResultsPage clickSearchButton() {
		driver.findElement(searchBtnBy).click();
		return new SearchResultsPage(driver);
	}
}
