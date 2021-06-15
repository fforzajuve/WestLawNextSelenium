package com.wln.components.search.resultlist;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.components.BaseComponent;
import com.wln.components.search.resultlist.toolbar.CreateAlertComponent;
import com.wln.components.search.resultlist.toolbar.DetailLevelComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.common.SortOrder;
import com.wln.pages.search.SearchResultsPage;

public class ResultListToolbarComponent extends BaseComponent {


	private static final By sortBySelectBy = By.id("co_search_sortOptions");

	private NavigationPagesComponent navigationPagesComponent;
	private SelectItemsComponent selectItemsComponent;
	private CreateAlertComponent createAlertComponent;
	private DetailLevelComponent detailLevelComponent;

	public ResultListToolbarComponent(DriverUtils driver) {
		super(driver);
		navigationPagesComponent = new NavigationPagesComponent(driver);
		selectItemsComponent = new SelectItemsComponent(driver);
		createAlertComponent = new CreateAlertComponent(driver);
		detailLevelComponent = new DetailLevelComponent(driver);
	}

	public NavigationPagesComponent getNavigationPagesComponent() {
		return navigationPagesComponent;
	}
	
	public SelectItemsComponent getSelectItemsComponent() {
		return selectItemsComponent;
	}
	
	public CreateAlertComponent getCreateAlertComponent() {
		return createAlertComponent;
	}

	public DetailLevelComponent getDetailLevelComponent() {
		return detailLevelComponent;
	}
	
	public SearchResultsPage sortBy(SortOrder sortOrder) {
		logger.info("Sort Result Items By: " + sortOrder.getName());
		Select sortBySelect = new Select(driver.findElement(sortBySelectBy));
		sortBySelect.selectByVisibleText(sortOrder.getName());
		driver.waitForElementNotDisplayed(By.xpath("//*[contains(text(),'Sorting Results')]"));
		return new SearchResultsPage(driver);
	}
	
	public SortOrder getSortOrder() {
		logger.info("Get Sort Order.");
		driver.waitForElementDisplayed(sortBySelectBy);
		Select sortBySelect = new Select(driver.findElement(sortBySelectBy));
		String sortOrder = sortBySelect.getFirstSelectedOption().getText();
		logger.info("Sort Order: " + sortOrder);
		return SortOrder.getFrom(sortOrder);
	}
	
}
