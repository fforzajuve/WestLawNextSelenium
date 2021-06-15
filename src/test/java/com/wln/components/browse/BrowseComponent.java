package com.wln.components.browse;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.browse.BrowsePage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;

public class BrowseComponent extends BaseComponent {

	private static final By browseContainerBy = By.id("co_browseWidget");

	private BrowseTabComponent browseTabComponent;

	public BrowseComponent(DriverUtils driver) {
		super(driver);
		browseTabComponent = new BrowseTabComponent(driver);
	}

	public BrowseTabComponent getBrowseTabComponent() {
		return browseTabComponent;
	}

	public CompanyInvestigatorPage openCompanyInvestigatorPage() {
		logger.info("Open Company Investigator page.");
		driver.findElement(browseContainerBy).findElement(By.linkText("Company Investigator")).click();
		return new CompanyInvestigatorPage(driver);
	}

	public BrowsePage openBrowsePage(String page) {
		logger.info("Open " + page + " page.");
		driver.findElement(browseContainerBy).findElement(By.linkText(page)).click();
		return new BrowsePage(driver);
	}

}
