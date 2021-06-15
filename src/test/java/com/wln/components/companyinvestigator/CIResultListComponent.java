package com.wln.components.companyinvestigator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.companyinvestigator.CompanyPage;

public class CIResultListComponent extends BaseComponent {

	private static final By companiesResultListContainerBy = By.id("cobalt_search_businessinvestigator_results");
	private static final By companyItemElementBy = By
			.xpath("//li[contains(@id, 'cobalt_search_results_businessinvestigator')]");
	private static final By companyNameBy = By.xpath(".//h3/a");
	private static final By companyCheckboxBy = By.xpath(".//input[@type='checkbox']");

	public CIResultListComponent(DriverUtils driver) {
		super(driver);
	}

	public boolean isCompanyPresentInList(String companyName) {
		logger.info("Is Company Present in List? " + companyName);
		boolean isCompanyPresent = false;
		List<WebElement> comanyElements =  driver.findElement(companiesResultListContainerBy).findElements(companyItemElementBy);
		for(int i = 0; i < comanyElements.size(); i++) {
			String name  = comanyElements.get(i).findElement(companyNameBy).getText();
			if(companyName.equals(name)) {
				isCompanyPresent = true;
				break;
			}
		}
		logger.info("Company Present in List: " + isCompanyPresent);
		return isCompanyPresent;	
	}

	public int getCompanyNumberOnPage() {
		logger.info("Get Number of Companies on page.");
		int companiesCount =  driver.findElement(companiesResultListContainerBy).findElements(companyItemElementBy).size();
		logger.info("Number of Companies on page: " + companiesCount);
		return 0;
	}

	public CompanyPage openCompanyByIndex(int index) {
		logger.info("Open Company by index: " + index);
		driver.waitForElementDisplayed(companiesResultListContainerBy);
		driver.findElement(companiesResultListContainerBy).findElements(companyItemElementBy).get(index)
				.findElement(companyNameBy).click();
		return new CompanyPage(driver);
	}

	public CompanyPage openCompanyByName(String companyName) {
		logger.info("Open Company by name: " + companyName);
		openCompanyByIndex(getCompanyIndexByName(companyName));
		return new CompanyPage(driver);
	}

	public void selectCompanyByIndex(int index, boolean selected) {
		logger.info("Select Company by index: " + index);
		WebElement companyCheckbox = driver.findElement(companiesResultListContainerBy).findElements(companyItemElementBy).get(index)
				.findElement(companyCheckboxBy);
		if (companyCheckbox.isSelected() != selected) {
			companyCheckbox.click();
		}
	}

	public void selectCompanyByName(String companyName, boolean selected) {
		logger.info("Select Company by name: " + companyName);
		selectCompanyByIndex(getCompanyIndexByName(companyName),selected);
	}

	public void createCompanyReportByIndex(int index) {

	}

	public void createCompanyReportByName(String companyName) {

	}

	public String getCompanyNameByIndex(int index) {

		return "";
	}

	private int getCompanyIndexByName(String companyName) {
		List<WebElement> items = driver.findElement(companiesResultListContainerBy).findElements(companyItemElementBy);
		for (int i = 0; i < items.size(); i++) {
			if (companyName.equals(items.get(i).findElement(companyNameBy).getText().trim())) {
				return i;
			}
		}
		
		return -1;
	}
}
