package com.wln.pages.companyinvestigator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.wln.components.companyinvestigator.CompanyToolbarComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class CompanyPage extends WlnPostSignOnPage {

	private static final By reportTabBy = By.id("ReportTab");
	private static final By familyTreeTabTabBy = By.id("Family_TreeTab");
	private static final By recordTabTabBy = By.id("RecordTab");
	private static final By reportDropdownBy = By.id("pm_DropDownNavContent");
	private static final By reportArrowBy = By.id("companyReportDropdown");

	private CompanyToolbarComponent companyToolbar;

	public CompanyPage(DriverUtils driver) {
		super(driver);
		companyToolbar = new CompanyToolbarComponent(driver);
	}

	public CompanyToolbarComponent getCompanyToolbar() {
		return companyToolbar;
	}

	public CompanyReportPage createReport(String report) {
		logger.info("Create Company Report: " + report);
		driver.waitForElementDisplayed(reportTabBy);
		// Open Report Tab
		expandReportDropdown();
		// Actions builder = new Actions(driver.getDriver());
		// builder.moveToElement(reportTab).build().perform();
		// Select Report Type
		driver.findElement(reportTabBy).findElement(By.partialLinkText(report)).click();
		driver.waitForAjaxCompleted();
		return new CompanyReportPage(driver);
	}

	public CompanyFamilyTreePage createFamilyTree() {
		logger.info("Create Family Tree.");
		driver.findElement(familyTreeTabTabBy).click();
		driver.waitForAjaxCompleted();
		return new CompanyFamilyTreePage(driver);
	}
	
	public CompanyReportPage openCompanyPage() {
		logger.info("Click Record tab.");
		driver.findElement(recordTabTabBy).click();
		return new CompanyReportPage(driver);
	}
	
	private void expandReportDropdown() {
		if (!isReportDropdownExpanded()) {
			driver.waitForElementDisplayed(reportArrowBy);
			WebElement arrowElement = driver.findElement(reportTabBy).findElement(reportArrowBy);
			System.out.println("Open Report Tab");
			driver.jsClick(arrowElement);
		}

	}

	private boolean isReportDropdownExpanded() {
		String classValue = driver.findElement(reportTabBy).findElement(reportDropdownBy).getAttribute("class");
		return "co_dropdownBoxExpanded".equals(classValue);
	}


}
