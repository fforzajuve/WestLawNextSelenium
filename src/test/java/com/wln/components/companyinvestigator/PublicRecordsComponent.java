package com.wln.components.companyinvestigator;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.companyinvestigator.DunBradstreetReportsSearchPage;
import com.wln.pages.companyinvestigator.ExperianBusinessReportsSearchPage;
import com.wln.pages.companyinvestigator.HooverCompanyProfilesSearchPage;
import com.wln.pages.companyinvestigator.InvestextReportsSearchPage;

public class PublicRecordsComponent extends BaseComponent {
	
	private static final By experianReportsLnkBy = By.id("coid_experian_business_credit_reports");
	private static final By dunBradstreetReportsLnkBy = By.id("coid_dun___bradstreet_reports");
	private static final By investextReportsLnkBy = By.id("coid_investext_reports");
	private static final By hooverCompanyProfilesLnkBy = By.id("coid_hoover_s_company_profiles");

	public PublicRecordsComponent(DriverUtils driver) {
		super(driver);
	}
	
	public ExperianBusinessReportsSearchPage openExperianBusinessReportsSearchPage() {
		logger.info("Open Experian Business Credit Reports Page.");
		driver.findElement(experianReportsLnkBy).click();
		return new ExperianBusinessReportsSearchPage(driver);
	}

	public DunBradstreetReportsSearchPage openDunBradstreetReportsSearchPage() {
		logger.info("Open Dun & Bradstreet Reports Page.");
		driver.findElement(dunBradstreetReportsLnkBy).click();
		return new DunBradstreetReportsSearchPage(driver);
	}
	
	public InvestextReportsSearchPage openInvestextReportsSearchPage() {
		logger.info("Open Investext Reports Page.");
		driver.findElement(investextReportsLnkBy).click();
		return new InvestextReportsSearchPage(driver);
	}
	
	public HooverCompanyProfilesSearchPage openHooverCompanyProfilesSearchPage() {
		logger.info("Open Hoover's Company Profiles Page.");
		driver.findElement(hooverCompanyProfilesLnkBy).click();
		return new HooverCompanyProfilesSearchPage(driver);
	}
}
