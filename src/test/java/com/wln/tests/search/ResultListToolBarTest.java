package com.wln.tests.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.common.SortOrder;
import com.wln.enums.search.ContentType;
import com.wln.enums.search.resultlist.toolbar.DetailLevel;
import com.wln.pages.alert.westclip.CreateWestClipAlertPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class ResultListToolBarTest extends WLNBaseTest {

	private static final String CLIENT_ID = "TEST";
	private static final ContentType CASES = ContentType.CASES;

	@Test
	public void createAlertTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage(CLIENT_ID);

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Click Create alert link
		CreateWestClipAlertPage createWestClipAlertPage = searchResultsPage.getResultListToolbarComponent()
				.getCreateAlertComponent().clickCreateAlert();

		// Verify Client id
		String clientId = createWestClipAlertPage.getBasicsSectionComponent().getClientId();
		Assert.assertEquals(clientId, CLIENT_ID, "Client id is wrong");
	}

	@Test
	public void sortSearchItemsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage(CLIENT_ID);

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Sort Items By Date
		searchResultsPage.getResultListToolbarComponent().sortBy(SortOrder.DATE);

		// Get Sort Order from result search page
		SortOrder sortOrder = searchResultsPage.getResultListToolbarComponent().getSortOrder();
		Assert.assertEquals(sortOrder, SortOrder.DATE, "Sort Order is wrong");
	}

	@Test
	public void detailLevelTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage(CLIENT_ID);

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Set Detail Level to Most Detail
		searchResultsPage.getResultListToolbarComponent().getDetailLevelComponent()
				.selectDetailLevel(DetailLevel.MOST_DETAIL);

		// Verify Detail Level
		DetailLevel detailLevel = searchResultsPage.getResultListToolbarComponent().getDetailLevelComponent()
				.getDetailLevel();
		Assert.assertEquals(detailLevel, DetailLevel.MOST_DETAIL, "Detail Level is wrong");

		// Set Detail Level to Less Detail
		searchResultsPage.getResultListToolbarComponent().getDetailLevelComponent()
				.selectDetailLevel(DetailLevel.LESS_DETAIL);

		// Verify Detail Level
		detailLevel = searchResultsPage.getResultListToolbarComponent().getDetailLevelComponent().getDetailLevel();
		Assert.assertEquals(detailLevel, DetailLevel.LESS_DETAIL, "Detail Level is wrong");
	}

}
