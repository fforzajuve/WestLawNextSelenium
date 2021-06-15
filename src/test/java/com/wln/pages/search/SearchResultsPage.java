package com.wln.pages.search;

import org.openqa.selenium.By;

import com.wln.components.search.ContentTypeComponent;
import com.wln.components.search.resultlist.AdvancedSearchSummaryComponent;
import com.wln.components.search.resultlist.ResultListComponent;
import com.wln.components.search.resultlist.ResultListToolbarComponent;
import com.wln.components.search.resultlist.SearchFooterComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class SearchResultsPage extends WlnPostSignOnPage {

	private static final By pageHeaderBy = By.xpath("//div[@class='co_search_result_heading_content']/h1");
	private static final By searchResultCountBy = By.className("co_search_titleCount");

	private ContentTypeComponent contentTypeComponent;
	private ResultListComponent resultListComponent;
	private SearchFooterComponent searchFooterComponent;
	private ResultListToolbarComponent resultListToolbarComponent;
	private AdvancedSearchSummaryComponent advancedSearchSummaryComponent;

	public SearchResultsPage(DriverUtils driver) {
		super(driver);
		driver.waitForElementDisplayed(pageHeaderBy);
		contentTypeComponent = new ContentTypeComponent(driver);
		resultListComponent = new ResultListComponent(driver);
		searchFooterComponent = new SearchFooterComponent(driver);
		resultListToolbarComponent = new ResultListToolbarComponent(driver);
		advancedSearchSummaryComponent = new AdvancedSearchSummaryComponent(driver);
	}

	public ContentTypeComponent getContentTypeComponent() {
		return contentTypeComponent;
	}

	public ResultListComponent getResultListComponent() {
		return resultListComponent;
	}

	public SearchFooterComponent getSearchFooterComponent() {
		return searchFooterComponent;
	}

	public ResultListToolbarComponent getResultListToolbarComponent() {
		return resultListToolbarComponent;
	}

	public AdvancedSearchSummaryComponent getAdvancedSearchSummaryComponent() {
		return advancedSearchSummaryComponent;
	}

	public String getHeader() {
		logger.info("Get Page Header.");
		String header = driver.findElement(pageHeaderBy).getText();
		header = header.split("\\(")[0].trim();
		logger.info("Page Header: " + header);
		return header;
	}

	public int getSearchResultCount() {
		logger.info("Get Search Result Count.");
		String countString = driver.findElement(searchResultCountBy).getText();
		String resCount = countString.substring(1, countString.length() - 1).replaceAll(",", "");
		logger.info("Count: " + resCount);
		return Integer.parseInt(resCount);
	}
}
