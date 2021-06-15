package com.wln.tests.browse;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.common.BrowseTab;
import com.wln.pages.browse.BrowsePage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class BrowseTabTest extends WLNBaseTest {

	private static final String COMPANY_INVESTIGATOR = "Company Investigator";
	private static final String MILITARY_LAW = "Military Law";

	@Test
	public void browseTabTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Select Practice Areas tab
		wlnHomePage.getBrowseComponent().getBrowseTabComponent().selectTab(BrowseTab.PRACTICE_AREAS);

		// Get Active tab
		BrowseTab activeTab = wlnHomePage.getBrowseComponent().getBrowseTabComponent().getActiveTab();
		Assert.assertTrue(activeTab == BrowseTab.PRACTICE_AREAS, "Tab is wrong");

		// Open Military Law and Verify Title
		BrowsePage militaryLawPage = wlnHomePage.getBrowseComponent().openBrowsePage(MILITARY_LAW);
		String pageTitle = militaryLawPage.getBrowseHeaderComponent().getPageTitle();
		Assert.assertEquals(pageTitle, MILITARY_LAW, "Military Law Title is wrong");

		// Open Home page
		militaryLawPage.getHeaderComponent().openHomePage();

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();
		pageTitle = companyInvestigatorPage.getBrowseHeaderComponent().getPageTitle();
		Assert.assertEquals(pageTitle, COMPANY_INVESTIGATOR, "Company Investigator Title is wrong");
	}
}
