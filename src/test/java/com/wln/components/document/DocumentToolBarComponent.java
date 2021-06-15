package com.wln.components.document;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.search.SearchResultsPage;

public class DocumentToolBarComponent extends BaseComponent {
	
	private static final By createAlertBtnBy = By.id("co_docKeyCiteAlertAnchor");
	private static final By returnToListBtnBy = By.id("co_docToolbarBackToResults");

	public DocumentToolBarComponent(DriverUtils driver) {
		super(driver);
	}

	
	public CreateKeyCiteAlertPage clickCreateKeyCiteAlert() {
		logger.info("Click Create KeyCite Alert Anchor.");
		driver.findElement(createAlertBtnBy).click();
		return new CreateKeyCiteAlertPage(driver);
	}
	
	public SearchResultsPage clickReturnToListButton() {
		logger.info("Click Return To List Button.");
		driver.findElement(returnToListBtnBy).click();
		return new SearchResultsPage(driver);
	}
}
