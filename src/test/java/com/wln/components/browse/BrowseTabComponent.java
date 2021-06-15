package com.wln.components.browse;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.common.BrowseTab;

public class BrowseTabComponent extends BaseComponent {
	
	private static final By tabsContainerBy = By.id("coid_browseTabs");
	private static final By activeTabBy = By.className("co_tabActive");

	public BrowseTabComponent(DriverUtils driver) {
		super(driver);
	}

	
	public void selectTab(BrowseTab tab) {
		logger.info("Select Browse Tab: " + tab.getName());
		if(tab != getActiveTab()) {
			driver.findElement(tabsContainerBy).findElement(By.linkText(tab.getName())).click();
		}

	}
	
	public BrowseTab getActiveTab() {
		String tabName = driver.findElement(tabsContainerBy).findElement(activeTabBy).findElement(By.tagName("a")).getText();
		logger.info("Active tab: " + tabName);
		return BrowseTab.getFrom(tabName);
	}
}
