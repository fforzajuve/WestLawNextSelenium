package com.wln.components.search.resultlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class SelectItemsComponent extends BaseComponent {
	
	private static final By selectContainerBy = By.className("co_navOptions");
	private static final By selectAllBy = By.id("co_searchHeader_selectAll");
	private static final By clearAllBy = By.cssSelector("#co_searchHeader_dockItemsClear > a");
	private static final By selectedItemsNumberBy = By.cssSelector("#co_searchHeader_dockItemsSelected > strong");
	

	public SelectItemsComponent(DriverUtils driver) {
		super(driver);
	}

	public void selectAllItems(boolean selected) {
		logger.info("Select All items: " + selected);
		WebElement selectAllElement = driver.findElement(selectContainerBy).findElement(selectAllBy);
		if(selectAllElement.isSelected() != selected) {
			selectAllElement.click();
		}
	}
	
	public void clearAllItems() {
		logger.info("Clear All items.");
		driver.findElement(clearAllBy).click();
	}
	
	public int getNumberOfSelectedItems() {
		logger.info("Get Number of selected items.");
		String number = driver.findElement(selectedItemsNumberBy).getText();
		logger.info("Number of selected items: " + number);
		return Integer.parseInt(number);
	}
	
}
