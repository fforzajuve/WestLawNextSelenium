package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.components.companyinvestigator.CIResultListComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class CompanyInvestigatorSeachResultsPage extends WlnPostSignOnPage {

	private static final By pageTitleLblBy = By.xpath("//div[@class='co_search_result_heading_content']/h1");
	private static final By companiesCountlBy = By.className("co_search_titleCount");
	private static final By backToCIBtnBy = By.cssSelector("#coid_website_backtoCategoryPageLink a");

	private CIResultListComponent resultListComponent;

	public CompanyInvestigatorSeachResultsPage(DriverUtils driver) {
		super(driver);
		resultListComponent = new CIResultListComponent(driver);
	}

	public CIResultListComponent getResultListComponent() {
		return resultListComponent;
	}

	public String getPageTitle() {
		logger.info("Get Page Title.");
		String pageTitle = driver.findElement(pageTitleLblBy).getText().split("\\(")[0].trim();
		logger.info("Page Title: " + pageTitle);
		return pageTitle;
	}

	public int getNumberOfCompaniesOnPage() {
		logger.info("Get number of companies.");
		String pageTitle = driver.findElement(companiesCountlBy).getText();
		int strLength = pageTitle.length();
		String companiesCount = pageTitle.substring(1, strLength - 1);
		logger.info("Number of Companies: " + companiesCount);
		return Integer.parseInt(companiesCount);
	}

	public CompanyInvestigatorPage clickBackToCI() {
		logger.info("Click Back to Company Investigayor button");
		driver.findElement(backToCIBtnBy).click();
		return new CompanyInvestigatorPage(driver);
	}

}
