package com.wln.components.search.resultlist;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;
import com.wln.pages.document.DocumentPage;

public class ResultListComponent extends BaseComponent {

	private static final By searchResultsContainerBy = By.id("co_fermiSearchResult_data");
	private static final By itemElementBy = By.xpath("//li[contains(@id,'cobalt_search_results')]");
	private static final By itemTitleBy = By.xpath(".//a[contains(@id,'cobalt_result')]");
	private static final By itemCheckboxBy = By.className("co_linkCheckBox_checkBox");
	private static final By itemPositionBy = By.className("co_searchCount");

	public ResultListComponent(DriverUtils driver) {
		super(driver);
	}

	public int getResultsNumberOnPage() {
		logger.info("Get Number of items on page.");
		driver.waitForElementDisplayed(searchResultsContainerBy);
		int resultsCount = driver.findElement(searchResultsContainerBy).findElements(itemElementBy).size();
		logger.info("Number of items on page: " + resultsCount);
		return resultsCount;
	}

	public DocumentPage clickItemByIndex(int index) {
		logger.info("Click item by index: " + index);
		driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index).findElement(itemTitleBy)
				.click();
		return new DocumentPage(driver);
	}
	
	public <P extends WlnPostSignOnPage> P clickItemByIndex(int index, Class<P> pageClass) {
		logger.info("Click item by index: " + index);
		driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index).findElement(itemTitleBy)
				.click();
		try {
			P pageObject = (P) pageClass.getConstructor(DriverUtils.class).newInstance(driver);
			return pageObject;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ClassCastException(
					"QualityLibrary: Failed to create a new page window with the class: " + pageClass.toString());
		}
	}

	public DocumentPage clickItemByTitle(String title) {
		logger.info("Click item by title: " + title);
		clickItemByIndex(getItemIndexByTitle(title));
		return new DocumentPage(driver);
	}

	public void selectItemByIndex(int index, boolean selected) {
		logger.info("Select item by index: " + index);
		WebElement itemCheckbox = driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index)
				.findElement(itemCheckboxBy);
		if (itemCheckbox.isSelected() != selected) {
			itemCheckbox.click();
		}
	}

	public void selectItemsByIndex(List<Integer> indexes) {
		logger.info("Select items by index: " + indexes);
		for (int index : indexes) {
			driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index)
					.findElement(itemCheckboxBy).click();
		}
	}

	public void selectItemByTitle(String title, boolean selected) {
		logger.info("Select item by title: " + title);
		selectItemByIndex(getItemIndexByTitle(title), selected);
	}

	public String getItemTitleByIndex(int index) {
		logger.info("Get item Title by index: " + index);
		String title = driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index)
				.findElement(itemTitleBy).getText();
		logger.info("Item Title: " + title);
		return title;
	}

	private int getItemIndexByTitle(String title) {
		List<WebElement> items = driver.findElement(searchResultsContainerBy).findElements(itemElementBy);
		for (int i = 0; i < items.size(); i++) {
			if (title.equals(items.get(i).findElement(itemTitleBy).getText())) {
				return i;
			}
		}
		return -1;
	}

	public int getItemPositionByIndex(int index) {
		logger.info("Get item position by index: " + index);
		String itemPos = driver.findElement(searchResultsContainerBy).findElements(itemElementBy).get(index)
				.findElement(itemPositionBy).getText();
		String position = itemPos.replace('.', ' ').trim();
		logger.info("Position: " + position);
		return Integer.parseInt(position);
	}

}
