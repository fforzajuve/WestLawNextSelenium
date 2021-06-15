package com.wln.tests.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.search.ContentType;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class ContentTypeTest extends WLNBaseTest {

	private static final ContentType JURY_VERDICTS_SETTLEMENTS = ContentType.JURY_VERDICTS_SETTLEMENTS;
	private static final ContentType CASES = ContentType.CASES;
	private static final ContentType FORMS = ContentType.FORMS;

	@Test
	public void casesTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		int casesCountInContentType = searchResultsPage.getContentTypeComponent().getContentTypeResultCount(CASES);

		// Verify Page Header
		String pageHeader = searchResultsPage.getHeader();
		Assert.assertEquals(pageHeader, CASES.getName(), "Header is wrong");

		// Verify Cases Result Count on page
		int casesCountOnPage = searchResultsPage.getSearchResultCount();
		Assert.assertEquals(casesCountOnPage, casesCountInContentType, "Cases total count is wrong on page");

	}

	@Test
	public void formsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(FORMS);

		int formsCountInContentType = searchResultsPage.getContentTypeComponent().getContentTypeResultCount(FORMS);

		// Verify Page Header
		String pageHeader = searchResultsPage.getHeader();
		Assert.assertEquals(pageHeader, FORMS.getName(), "Header is wrong");

		// Verify Cases Result Count on page
		int formsCountOnPage = searchResultsPage.getSearchResultCount();
		Assert.assertEquals(formsCountOnPage, formsCountInContentType, "Forms total count is wrong on page");

	}

	@Test
	public void juryVerdictsAndSettlementsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Jury Verdicts And Settlements
		searchResultsPage.getContentTypeComponent().selectContentType(JURY_VERDICTS_SETTLEMENTS);

		int juryCountInContentType = searchResultsPage.getContentTypeComponent()
				.getContentTypeResultCount(JURY_VERDICTS_SETTLEMENTS);

		// Verify Page Header
		String pageHeader = searchResultsPage.getHeader();
		Assert.assertEquals(pageHeader, JURY_VERDICTS_SETTLEMENTS.getName(), "Header is wrong");

		// Verify Jury Verdicts And Settlements Result Count on page
		int juryCountOnPage = searchResultsPage.getSearchResultCount();
		Assert.assertEquals(juryCountOnPage, juryCountInContentType,
				"Jury Verdicts And Settlements total count is wrong on page");

	}

}
