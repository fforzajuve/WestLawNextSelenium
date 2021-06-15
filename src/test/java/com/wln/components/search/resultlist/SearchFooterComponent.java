package com.wln.components.search.resultlist;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.search.resultlist.PageSize;
import com.wln.pages.search.SearchResultsPage;

public class SearchFooterComponent extends BaseComponent {

	private static final By pageSizeSelectBy = By.id("coid_search_pagination_size_footer");

	public SearchFooterComponent(DriverUtils driver) {
		super(driver);
	}

	public SearchResultsPage setPageSize(PageSize pageSize) {
		logger.info("Set Page Size: " + pageSize);
		Select pageSizeSelect = new Select(driver.findElement(pageSizeSelectBy));
		pageSizeSelect.selectByVisibleText(pageSize.getName());
		return new SearchResultsPage(driver);
	}

	public PageSize getPageSize() {
		logger.info("Get Page Size.");
		Select pageSizeSelect = new Select(driver.findElement(pageSizeSelectBy));
		PageSize size = PageSize.getFrom(pageSizeSelect.getFirstSelectedOption().getText());
		logger.info("Page Size: " + size);
		return size;
	}
}
