package com.wln.tests.companyinvestigator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.ExperianBusinessReportsSearchPage;
import com.wln.pages.companyinvestigator.reports.BusinessCreditReportPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class ExperianBusinessCreditReportsTest extends WLNBaseTest {

	@Test
	public void experianBusinessCreditReportTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Experian Business Reports Search page
		ExperianBusinessReportsSearchPage businessReportsSearchPage = companyInvestigatorPage
				.getPublicRecordsComponent().openExperianBusinessReportsSearchPage();

		// Do search for Experian Business Reports
		businessReportsSearchPage.enterCompanyName("google");
		businessReportsSearchPage.selectState("Colorado");
		SearchResultsPage resultsPage = businessReportsSearchPage.clickSearchButton();

		// Select first report
		BusinessCreditReportPage businessReportPage = resultsPage.getResultListComponent().clickItemByIndex(0,
				BusinessCreditReportPage.class);

		// Verify Report
		boolean isReportDisplayed = businessReportPage.isReportDisplayed();
		Assert.assertTrue(isReportDisplayed, "Busines Credit Report is not displayed");
	}

}
