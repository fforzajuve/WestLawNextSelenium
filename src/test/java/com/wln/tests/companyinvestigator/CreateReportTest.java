package com.wln.tests.companyinvestigator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorSeachResultsPage;
import com.wln.pages.companyinvestigator.CompanyPage;
import com.wln.pages.companyinvestigator.CompanyReportPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class CreateReportTest extends WLNBaseTest {

	private static final String GOOGLE_COMANY_NAME = "google";

	@Test
	public void createCompanyReportTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Do search for google
		companyInvestigatorPage.enterCompanyName(GOOGLE_COMANY_NAME);
		CompanyInvestigatorSeachResultsPage companyResultsPage = companyInvestigatorPage.clickSearchButton();

		// Open first company
		CompanyPage companyPage = companyResultsPage.getResultListComponent().openCompanyByIndex(0);

		// Create Report test
		CompanyReportPage reportPage = companyPage.createReport("Company Investigator Report (Premier)");

		// Verify report image
		boolean isImageDisplayed = reportPage.isReportImageDisplayed();
		Assert.assertTrue(isImageDisplayed, "Report image is not displayed");
	}

}
