package com.wln.components.browse;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class BrowseHeaderComponent extends BaseComponent {

	private static final By headerContainerBy = By.className("co_browseHeaderContent");
	private static final By pageTitleBy = By.id("co_browsePageLabel");

	public BrowseHeaderComponent(DriverUtils driver) {
		super(driver);
	}

	public String getPageTitle() {
		logger.info("Get Page Title");
		String title = driver.findElement(headerContainerBy).findElement(pageTitleBy).getText();
		logger.info("Page Title: " + title);
		return title;
	}
}
