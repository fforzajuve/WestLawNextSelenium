package com.wln.components.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.ci.CreateCompanyInvestigatorAlertPage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorSeachResultsPage;

public class CompanyToolbarComponent extends BaseComponent {
	
	private static final By toolbarContainerBy = By.id("co_docToolbarContainer");
	private static final By createAlertBtnBy = By.id("co_docBusinessInvestigatorAnchor");
	private static final By returnToSearchResultsBtnBy = By.cssSelector("a#co_returnToSearchResults");
;
	public CompanyToolbarComponent(DriverUtils driver) {
		super(driver);
	}
	
	public CreateCompanyInvestigatorAlertPage clickCreateAlertButton() {
		logger.info("Click Create Alert Button");
		driver.findElement(toolbarContainerBy).findElement(createAlertBtnBy).click();
		return new CreateCompanyInvestigatorAlertPage(driver);
	}
	
	public CompanyInvestigatorSeachResultsPage clickReturnToSearchResultsButton() {
		logger.info("Click Return to Search Results");
		driver.findElement(toolbarContainerBy).findElement(returnToSearchResultsBtnBy).click();
		return new CompanyInvestigatorSeachResultsPage(driver);
	}

}
