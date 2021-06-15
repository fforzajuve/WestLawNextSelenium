package com.wln.components.alert.section;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.common.SortOrder;

public class SearchSectionComponent extends BaseComponent {
	
	private static final By searchSectionBy = By.xpath("//li[@id='searchSection'and not(@class='co_collapsed')]");
	private static final By continueBtnBy = By.id("co_button_continue_Search");
	private static final By searchInputBy = By.id("searchInputIdAlerts");
	private static final By sortOrderSelectBy = By.id("co_search_alertSearchPanelSortTypes");


	public SearchSectionComponent(DriverUtils driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SearchSectionComponent selectSortOrder(SortOrder sortOrder) {
		logger.info("Select Sort Order: " + sortOrder.getName());
		Select sortOrderSelect = new Select(driver.findElement(sortOrderSelectBy));
		sortOrderSelect.selectByVisibleText(sortOrder.getName());
		return this;
	}
	
	public SearchSectionComponent enterSearchTerm(String searchTerm) {
		logger.info("Enter Search term: " + searchTerm);
		driver.findElement(searchInputBy).sendKeys(searchTerm);
		return this;
	}
	
	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}
	
	public boolean isSearchSectionDisplayed() {
		boolean isSearchDisplayed = driver.isElementDisplayed(searchSectionBy);
		logger.info("Is Search section displayed? " + isSearchDisplayed);
		return isSearchDisplayed;
	}
	
	public void waitForSearchSection() {
		logger.info("Wait For Search section to be displayed.");
		driver.waitForElementDisplayed(searchSectionBy);
	}
}
