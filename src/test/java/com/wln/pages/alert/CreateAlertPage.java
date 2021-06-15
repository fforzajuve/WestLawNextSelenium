package com.wln.pages.alert;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class CreateAlertPage extends WlnPostSignOnPage {
	
	private static final By breadcrumbBy = By.id("breadcrumb");
	private static final By alertTitleBy = By.id("co_alertWizardTitle");

	public CreateAlertPage(DriverUtils driver) {
		super(driver);
	}

	public String getTopBreadcrumb() {
		logger.info("Get Top Breadcrumb.");
		String topBreadcrumb = driver.findElement(breadcrumbBy).findElement(By.tagName("a")).getText();
		logger.info("Top Breadcrumb: " + topBreadcrumb);
		return topBreadcrumb;
	}
	
	public String getPageTitle() {
		logger.info("Get Alert Page Title.");
		String title = driver.findElement(alertTitleBy).getText();
		logger.info("Title: " + title);
		return title;
		
	}
}
