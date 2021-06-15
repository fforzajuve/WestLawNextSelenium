package com.wln.tests.companyinvestigator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.DunBradstreetReportsSearchPage;
import com.wln.pages.companyinvestigator.reports.DunBradstreetBusinessReportsPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class DunBradstreetReportsTest extends WLNBaseTest {

	private static final String DUN_PAGE_HEADER = "Dun & Bradstreet Reports";

	@Test
	public void dunBradstreetReportTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Dun&Bradstreet Reports Search page
		DunBradstreetReportsSearchPage dunBradstreetSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openDunBradstreetReportsSearchPage();

		// Do search for google
		dunBradstreetSearchPage.enterCompanyName("google");
		SearchResultsPage resultsPage = dunBradstreetSearchPage.clickSearchButton();

		// Verify Page Header
		String pageHeader = resultsPage.getHeader();
		Assert.assertEquals(pageHeader, DUN_PAGE_HEADER, "Page Header is wrong");

		// Select first result
		DunBradstreetBusinessReportsPage dunBradstreetBusinessReportPage = resultsPage.getResultListComponent()
				.clickItemByIndex(0, DunBradstreetBusinessReportsPage.class);

		// Verify duns report
		boolean isReportDisplayed = dunBradstreetBusinessReportPage.isBusinessReportDisplayed();
		Assert.assertTrue(isReportDisplayed, "Report is not displayed");

	}

}
