package com.wln.tests.search;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.search.ContentType;
import com.wln.enums.search.resultlist.PageSize;
import com.wln.pages.document.DocumentPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.pages.search.SearchResultsPage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class SearchTest extends WLNBaseTest {

	private static final List<Integer> SELECTED_INDEXES = Arrays.asList(1, 3, 5);
	private static final String SECOND_DOCUMENT_TITLE = "Legal Voice v. Stormans Inc.";
	private static final PageSize PAGE_SIZE = PageSize.FIFTY;
	private static final ContentType CASES = ContentType.CASES;
	private static final ContentType FORMS = ContentType.FORMS;

	@Test
	public void searchTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases and Verify
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);
		ContentType activeContentType = searchResultsPage.getContentTypeComponent().getActiveContentType();
		Assert.assertEquals(activeContentType, CASES, "Active Content Type is wrong");

		// Select Forms and Verify
		searchResultsPage.getContentTypeComponent().selectContentType(FORMS);
		activeContentType = searchResultsPage.getContentTypeComponent().getActiveContentType();
		Assert.assertEquals(activeContentType, FORMS, "Active Content Type is wrong");
	}

	@Test
	public void resultListPageSizeTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Verify Page Size
		searchResultsPage.getSearchFooterComponent().setPageSize(PAGE_SIZE);
		PageSize pageSize = searchResultsPage.getSearchFooterComponent().getPageSize();
		Assert.assertEquals(pageSize, PAGE_SIZE, "Page Size is wrong");

		// Verify Number Items on Page
		int itemNumbersOnPage = searchResultsPage.getResultListComponent().getResultsNumberOnPage();
		Assert.assertTrue(itemNumbersOnPage == 50, "Number of Items on page  is wrong");
	}

	@Test
	public void returnToListTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Set Page Size to TWENTY
		searchResultsPage.getSearchFooterComponent().setPageSize(PageSize.TWENTY);

		// Get First item title
		String firstItemTitle = searchResultsPage.getResultListComponent().getItemTitleByIndex(0);

		// Click first item
		DocumentPage docPage = searchResultsPage.getResultListComponent().clickItemByIndex(0);

		// Verify First Document Title
		String firstDocTitle = docPage.getDocumentHeader();
		Assert.assertEquals(firstDocTitle, firstItemTitle, "First Document title is wrong");

		// Click Return to List Button
		docPage.getToolbarComponent().clickReturnToListButton();

		// Click second item by title
		docPage = searchResultsPage.getResultListComponent().clickItemByTitle(SECOND_DOCUMENT_TITLE);

		// Verify Second Document Title
		String secondDocTitle = docPage.getDocumentHeader();
		Assert.assertEquals(secondDocTitle, SECOND_DOCUMENT_TITLE, "Second Document title is wrong");
	}

	@Test
	public void resultListNavigationTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Set Page Size to TWENTY
		searchResultsPage.getSearchFooterComponent().setPageSize(PageSize.TWENTY);

		// Get first item pos
		int itemPos = searchResultsPage.getResultListComponent().getItemPositionByIndex(0);

		// Navigate to next page result
		searchResultsPage.getResultListToolbarComponent().getNavigationPagesComponent().clickNextButton();

		// Get first item pos on next page
		int nextPageItemPos = searchResultsPage.getResultListComponent().getItemPositionByIndex(0);

		// Get Nav Range and Verify
		int rangePerPage = searchResultsPage.getResultListToolbarComponent().getNavigationPagesComponent()
				.getRangePerPage();
		Assert.assertEquals(rangePerPage, nextPageItemPos - itemPos, "Range per page is wrong");

		// Navigate to previous page result
		searchResultsPage.getResultListToolbarComponent().getNavigationPagesComponent().clickPreviousButton();

		// Verify second item position
		int secondPos = searchResultsPage.getResultListComponent().getItemPositionByIndex(1);
		Assert.assertEquals(secondPos, 2, "Position is wrong");
	}

	@Test
	public void resultListSelectItemsTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search
		SearchResultsPage searchResultsPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearch("legal");

		// Select Cases
		searchResultsPage.getContentTypeComponent().selectContentType(CASES);

		// Select all items
		searchResultsPage.getResultListToolbarComponent().getSelectItemsComponent().selectAllItems(true);

		// Get number of selected items
		int seletedItemsNumber = searchResultsPage.getResultListToolbarComponent().getSelectItemsComponent()
				.getNumberOfSelectedItems();
		Assert.assertTrue(seletedItemsNumber == 20, "Number of selected items is wrong");

		// Clear all items
		searchResultsPage.getResultListToolbarComponent().getSelectItemsComponent().clearAllItems();

		// Select 3 items by indexes
		searchResultsPage.getResultListComponent().selectItemsByIndex(SELECTED_INDEXES);

		// Get number of selected items
		seletedItemsNumber = searchResultsPage.getResultListToolbarComponent().getSelectItemsComponent()
				.getNumberOfSelectedItems();
		Assert.assertTrue(seletedItemsNumber == SELECTED_INDEXES.size(), "Number of selected items is wrong");
	}

}
