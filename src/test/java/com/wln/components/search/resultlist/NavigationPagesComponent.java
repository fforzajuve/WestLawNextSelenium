package com.wln.components.search.resultlist;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.search.SearchResultsPage;

public class NavigationPagesComponent extends BaseComponent {
	
	private static final By navContainerBy = By.id("co_navigationPages");
	private static final By nextPageBtnBy = By.id("co_search_header_pagination_next");
	private static final By prevPageBtnBy = By.id("co_search_header_pagination_prev");
	private static final By navRangeBy = By.xpath(".//li/span");

	public NavigationPagesComponent(DriverUtils driver) {
		super(driver);
	}
	
	public SearchResultsPage clickNextButton() {
		logger.info("Click next page button");
		driver.findElement(navContainerBy).findElement(nextPageBtnBy).click();
		return new SearchResultsPage(driver);
	}

	public SearchResultsPage clickPreviousButton() {
		logger.info("Click previous page button");
		driver.findElement(navContainerBy).findElement(prevPageBtnBy).click();
		return new SearchResultsPage(driver);
	}
	
	public int getRangePerPage() {
		logger.info("Get number of items per page.");
		String range = driver.findElement(navContainerBy).findElement(navRangeBy).getText();
		String[] ranges = range.split("-");
		return Integer.parseInt(ranges[1].trim()) - Integer.parseInt(ranges[0].trim()) + 1;
	}
}
