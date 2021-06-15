package com.wln.tests.companyinvestigator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.ci.ReportDate;
import com.wln.pages.companyinvestigator.CompanyInvestigatorPage;
import com.wln.pages.companyinvestigator.InvestextReportsSearchPage;
import com.wln.pages.document.DocumentPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class InvestextReportsTest extends WLNBaseTest {

	private static final String REPORT_TYPE = "Industry Reports";
	private static final List<String> REPORT_TYPES = Arrays.asList("Company Reports", "Industry Reports");
	private static final String INDUSTRY_ENERGY = "Energy";
	private static final String COMAPNY_NAME = "google";
	private static final String INVEST_TEXT_PAGE_HEADER = "Investext Reports";

	@Test
	public void investextReportTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Investext Reports Search page
		InvestextReportsSearchPage investextReportsSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openInvestextReportsSearchPage();

		// Do search for google
		investextReportsSearchPage.enterCompanyName(COMAPNY_NAME);
		SearchResultsPage resultsPage = investextReportsSearchPage.getHeaderComponent().getSearchComponent()
				.clickSearchButton();

		// Verify Page Header
		String pageHeader = resultsPage.getHeader();
		Assert.assertEquals(pageHeader, INVEST_TEXT_PAGE_HEADER, "Page Header is wrong");

		// Open first result item
		DocumentPage documentPage = resultsPage.getResultListComponent().clickItemByIndex(0);

		// Verify invetext
		boolean isInvestextDisplayesd = documentPage.isInvestextDisplayed();
		Assert.assertTrue(isInvestextDisplayesd, "Investext is not displayed");

		String investextNumber = documentPage.getInvestext();
		System.out.println("Investext: " + investextNumber);

	}

	@Test
	public void investextReportAdvancedSearchOptionsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Investext Reports Search page
		InvestextReportsSearchPage investextReportsSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openInvestextReportsSearchPage();

		// Do search for google
		investextReportsSearchPage.enterCompanyName(COMAPNY_NAME);

		// Verify Report Date Option
		investextReportsSearchPage.selectReportDate(ReportDate.LAST_SIX_MONTHS);
		ReportDate reportDate = investextReportsSearchPage.getReportDate();
		Assert.assertEquals(reportDate, ReportDate.LAST_SIX_MONTHS, "Report Date is wrong.");

		// Select Industry
		investextReportsSearchPage.selectIndustry(INDUSTRY_ENERGY);

		// Select Report Type
		investextReportsSearchPage.selectReportType("All", false);
		investextReportsSearchPage.selectReportType(REPORT_TYPE, true);

		SearchResultsPage resultsPage = investextReportsSearchPage.getHeaderComponent().getSearchComponent()
				.clickSearchButton();

		// Verify Page Header
		String pageHeader = resultsPage.getHeader();
		Assert.assertEquals(pageHeader, INVEST_TEXT_PAGE_HEADER, "Page Header is wrong");

		Map<String, String> searchOptions = resultsPage.getAdvancedSearchSummaryComponent().getSearchOptions();
		System.out.println(searchOptions);

		// Verify Company Name in Advanced Search Component
		String companyName = searchOptions.get("Company Name");
		Assert.assertEquals(companyName, COMAPNY_NAME, "Company Name is wrong");

		// Verify Industry in Advanced Search Component
		String industry = searchOptions.get("Industry");
		Assert.assertEquals(industry, INDUSTRY_ENERGY, "Industry is wrong");

		// Verify Report Type in Advanced Search Component
		String reportType = searchOptions.get("Report Type");
		Assert.assertEquals(reportType, REPORT_TYPE, "Report Type is wrong");
	}

	@Test
	public void editInvestextReportSearchTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Investext Reports Search page
		InvestextReportsSearchPage investextReportsSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openInvestextReportsSearchPage();

		// Do search for google
		investextReportsSearchPage.enterCompanyName(COMAPNY_NAME);

		// Verify Report Date Option
		investextReportsSearchPage.selectReportDate(ReportDate.LAST_SIX_MONTHS);
		ReportDate reportDate = investextReportsSearchPage.getReportDate();
		Assert.assertEquals(reportDate, ReportDate.LAST_SIX_MONTHS, "Report Date is wrong.");

		// Select Industry
		investextReportsSearchPage.selectIndustry(INDUSTRY_ENERGY);

		// Select Report Type
		investextReportsSearchPage.selectReportType("All", false);
		investextReportsSearchPage.selectReportType(REPORT_TYPE, true);

		SearchResultsPage resultsPage = investextReportsSearchPage.getHeaderComponent().getSearchComponent()
				.clickSearchButton();

		// Verify Page Header
		String pageHeader = resultsPage.getHeader();
		Assert.assertEquals(pageHeader, INVEST_TEXT_PAGE_HEADER, "Page Header is wrong");

		// Click Edit Link in Advanced Search Summary Component
		investextReportsSearchPage = resultsPage.getAdvancedSearchSummaryComponent()
				.clickEditLink(InvestextReportsSearchPage.class);

		// Verify Company Name
		String companyName = investextReportsSearchPage.getCompanyName();
		Assert.assertEquals(companyName, COMAPNY_NAME, "Company Name is wrong");

		// Verify Company Name
		String industry = investextReportsSearchPage.getIndustry();
		Assert.assertEquals(industry, INDUSTRY_ENERGY, "Industry is wrong");

		// Verify Report Types
		List<String> reportTypes = investextReportsSearchPage.getReportTypes();
		Assert.assertEquals(reportTypes.get(0), REPORT_TYPE, "Reports Type is wrong");
	}

	@Test
	public void investextReportReportTypesTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Company Investigator page and Verify Title
		CompanyInvestigatorPage companyInvestigatorPage = wlnHomePage.getBrowseComponent()
				.openCompanyInvestigatorPage();

		// Open Investext Reports Search page
		InvestextReportsSearchPage investextReportsSearchPage = companyInvestigatorPage.getPublicRecordsComponent()
				.openInvestextReportsSearchPage();

		// Verify Search Category
		String searchCategory = investextReportsSearchPage.getHeaderComponent().getSearchComponent()
				.getSearchCategory();
		Assert.assertEquals(searchCategory, INVEST_TEXT_PAGE_HEADER, "Search Category is wrong");

		// Do search for google
		investextReportsSearchPage.enterCompanyName(COMAPNY_NAME);

		// Select Report Type
		investextReportsSearchPage.selectReportType("All", false);
		for (String reportType : REPORT_TYPES) {
			investextReportsSearchPage.selectReportType(reportType, true);
		}

		SearchResultsPage resultsPage = investextReportsSearchPage.getHeaderComponent().getSearchComponent()
				.clickSearchButton();

		// Click Edit Link in Advanced Search Summary Component
		investextReportsSearchPage = resultsPage.getAdvancedSearchSummaryComponent()
				.clickEditLink(InvestextReportsSearchPage.class);

		// Verify Report Types
		List<String> reportTypes = investextReportsSearchPage.getReportTypes();
		Assert.assertEquals(reportTypes, REPORT_TYPES, "Reports Type is wrong");
	}
}
