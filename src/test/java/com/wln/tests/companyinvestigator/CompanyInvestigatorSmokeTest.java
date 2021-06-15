package com.wln.tests.companyinvestigator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.alert.AlertType;
import com.wln.enums.common.Frequency;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.ci.CreateCompanyInvestigatorAlertPage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.CompanyInvestigatorSeachResultsPage;
import com.wln.pages.companyinvestigator.CompanyPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class CompanyInvestigatorSmokeTest extends WLNBaseTest {

	private static final String GOOGLE_COMPANY_NAME = "google";
	private static final String COMPANY_INVESTIGATOR = "Company Investigator";
	private static final String ALERT_SAVED_MESSAGE = "The alert (.*) has been saved. Return to Company Landing Page";

	@Test
	public void companyInvestigatorTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();
		String pageTitle = companyInvestigatorPage.getBrowseHeaderComponent().getPageTitle();
		Assert.assertEquals(pageTitle, COMPANY_INVESTIGATOR, "Company Investigator Title is wrong");

		// Do search for google
		companyInvestigatorPage.enterCompanyName(GOOGLE_COMPANY_NAME);
		CompanyInvestigatorSeachResultsPage companyResultsPage = companyInvestigatorPage.clickSearchButton();

		// Verify title and number of companies on page

		String title = companyResultsPage.getPageTitle();
		Assert.assertEquals(title, COMPANY_INVESTIGATOR, "Company Investigator title is wrong");

		int companiesCount = companyResultsPage.getNumberOfCompaniesOnPage();
		Assert.assertTrue(companiesCount > 0, "Companies number is greater then 1");

		// Is ALPHABET INC. Present in list
		boolean isComanyPresentInList = companyResultsPage.getResultListComponent()
				.isCompanyPresentInList("ALPHABET INC.");
		Assert.assertTrue(isComanyPresentInList, "ALPHABET INC. is not in list");
	}

	@Test
	public void createCompanyAlertTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Do search for google
		companyInvestigatorPage.enterCompanyName(GOOGLE_COMPANY_NAME);
		CompanyInvestigatorSeachResultsPage companyResultsPage = companyInvestigatorPage.clickSearchButton();

		// Open first company
		CompanyPage companyPage = companyResultsPage.getResultListComponent().openCompanyByIndex(0);

		// Click Create Alert button button
		CreateCompanyInvestigatorAlertPage createCIAlertPage = companyPage.getCompanyToolbar().clickCreateAlertButton();

		// Fill In Basics Section
		createCIAlertPage.getBasicsSectionComponent().enterAlertName("ALPHABET INC. ALERT");
		createCIAlertPage.getBasicsSectionComponent().enterDescription("CI ALERT");
		createCIAlertPage.getBasicsSectionComponent().clickContinueButton();

		// Fill In Content Section
		createCIAlertPage.getContentSectionComponent().waitForContentSection();
		createCIAlertPage.getContentSectionComponent().deselectAllContent();
		createCIAlertPage.getContentSectionComponent().selectContent("Corporate Filing", true);
		createCIAlertPage.getContentSectionComponent().clickContinueButton();

		// Fill in Delivery Section
		createCIAlertPage.getDeliverySectionComponent().waitForDeliverySection();
		createCIAlertPage.getDeliverySectionComponent().selectFromMyContacts(0);
		createCIAlertPage.getDeliverySectionComponent().enterDeliveryNote("CI");
		createCIAlertPage.getDeliverySectionComponent().clickContinueButton();

		// Fill in Schedule Section
		createCIAlertPage.getScheduleSectionComponent().waitForScheduleSection();
		createCIAlertPage.getScheduleSectionComponent().selectFrequency(Frequency.WEEKLY);
		AlertsCenterPage alertsCenterPage = createCIAlertPage.getScheduleSectionComponent().clickSaveAlertButton();

		// Verify Alert Created Message
		String infoMessage = alertsCenterPage.getInfoMessage();
		Assert.assertTrue(infoMessage.matches(ALERT_SAVED_MESSAGE), "CI message is wrong.");

		// Verify CI alert in alert list
		alertsCenterPage.getAlertTypeComponent().selectAlertType(AlertType.COMPANY_INVESTIGATOR);
		boolean isAlertPresent = alertsCenterPage.getAlertResultListComponent()
				.isAlertPresentInList("ALPHABET INC. ALERT");
		Assert.assertTrue(isAlertPresent, "Alert is not present.");

	}

	@Test
	public void returnToComInvResultsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Do search for google
		companyInvestigatorPage.enterCompanyName(GOOGLE_COMPANY_NAME);
		CompanyInvestigatorSeachResultsPage companyResultsPage = companyInvestigatorPage.clickSearchButton();

		// Is ALPHABET INC. Present in list
		boolean isComanyPresentInList = companyResultsPage.getResultListComponent()
				.isCompanyPresentInList("ALPHABET INC.");
		Assert.assertTrue(isComanyPresentInList, "ALPHABET INC. is not in list");

		// Open first company
		CompanyPage companyPage = companyResultsPage.getResultListComponent().openCompanyByIndex(0);

		// Click Return to Search Results button
		companyPage.getCompanyToolbar().clickReturnToSearchResultsButton();

		// Is ALPHABET INC. Present in list
		isComanyPresentInList = companyResultsPage.getResultListComponent().isCompanyPresentInList("ALPHABET INC.");
		Assert.assertTrue(isComanyPresentInList, "ALPHABET INC. is not in list");

	}

}
