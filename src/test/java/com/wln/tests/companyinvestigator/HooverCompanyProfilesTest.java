package com.wln.tests.companyinvestigator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.HooverCompanyProfilesSearchPage;
import com.wln.pages.companyinvestigator.reports.HooverReportPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class HooverCompanyProfilesTest extends WLNBaseTest {

	private static final String HOOVER_HEADER = "Hoover's Company Profiles";
	private static final String HOOVER_REPORT_HEADER = "Hoover's Company Profile";

	@Test
	public void hooverCompanyProfileTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Hoover's Company Profiles Search page
		HooverCompanyProfilesSearchPage hooverSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openHooverCompanyProfilesSearchPage();

		// Do search for google
		hooverSearchPage.enterCompanyName("google");
		SearchResultsPage resultsPage = hooverSearchPage.getHeaderComponent().getSearchComponent().clickSearchButton();

		// Verify Page Header
		String pageHeader = resultsPage.getHeader();
		Assert.assertEquals(pageHeader, HOOVER_HEADER, "Page Header is wrong");

		// Open first result item
		HooverReportPage hooverReportPage = resultsPage.getResultListComponent().clickItemByIndex(0,
				HooverReportPage.class);

		// Verify Report Header
		String reportHeader = hooverReportPage.getReportHeader();
		Assert.assertEquals(reportHeader, HOOVER_REPORT_HEADER, "Report Header is wrong");

		// Verify Company Name
		String companyName = hooverReportPage.getCompanyName();
		System.out.println("Company Name: " + companyName);
	}

}
