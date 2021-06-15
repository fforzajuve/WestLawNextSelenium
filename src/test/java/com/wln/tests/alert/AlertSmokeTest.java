package com.wln.tests.alert;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.alert.AlertType;
import com.wln.enums.common.Frequency;
import com.wln.enums.common.SortOrder;
import com.wln.enums.common.Time;
import com.wln.enums.common.TimeZone;
import com.wln.enums.common.Weekday;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.alert.westclip.CreateWestClipAlertPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class AlertSmokeTest extends WLNBaseTest {

	private static final AlertType DOCKET_TRACK_ALERT_TYPE = AlertType.DOCKET_TRACK;
	private static final int ALERT_TYPES_EXPECTED = 15;
//	private static final String CITATION_1 = "2014 WL 2186473";
	private static final String CITATION_2 = "2012 WL 1521521";
	private static final String WEST_CLIP_ALERT = "WescClip001";
	private static final String KEY_CITE_ALERT = "KeyCite001";

	@Test
	public void alertTypesTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();

		// Verify Alert Type is displayed
		boolean isAlertTypeDisplayed = alertsCenterPage.getAlertTypeComponent().isAlertTypesDisplayed();
		Assert.assertTrue(isAlertTypeDisplayed, "Alert Type widget is not displayed");

		// Verify Number of alert types
		int numberOfAlertTypes = alertsCenterPage.getAlertTypeComponent().getAlertTypesNumber();
		Assert.assertEquals(numberOfAlertTypes, ALERT_TYPES_EXPECTED, "Number of Alert Types are wrong");

		// Verify Alert Type selection
		alertsCenterPage.getAlertTypeComponent().selectAlertType(DOCKET_TRACK_ALERT_TYPE);
		AlertType alertType = alertsCenterPage.getAlertTypeComponent().getActiveAlertType();
		Assert.assertEquals(alertType, DOCKET_TRACK_ALERT_TYPE, "Alert Type is wrong");

	}

	@Test
	public void createWestClipAlertTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();
		CreateWestClipAlertPage createWestClipAlertPage = alertsCenterPage.createAlert(AlertType.WESTCLIP,
				CreateWestClipAlertPage.class);

		// Fill in Basics Section
		createWestClipAlertPage.getBasicsSectionComponent().enterAlertName("WescClip001");
		createWestClipAlertPage.getBasicsSectionComponent().enterDescription("Masha");
		createWestClipAlertPage.getBasicsSectionComponent().clickContinueButton();

		// Fill in Content Section
		createWestClipAlertPage.getContentSection().waitForContentSection();
		createWestClipAlertPage.getContentSection().addContent("Trial Court Orders");
		createWestClipAlertPage.getContentSection().clickContinueButton();

		// Fill in Search Section
		createWestClipAlertPage.getSearchSectionComponent().waitForSearchSection();
		createWestClipAlertPage.getSearchSectionComponent().enterSearchTerm("cat");
		createWestClipAlertPage.getSearchSectionComponent().selectSortOrder(SortOrder.DATE);
		createWestClipAlertPage.getSearchSectionComponent().clickContinueButton();

		// Fill in Delivery Section
		createWestClipAlertPage.getDeliverySectionComponent().waitForDeliverySection();
		createWestClipAlertPage.getDeliverySectionComponent().enterDeliveryNote("Delivery Note");
		createWestClipAlertPage.getDeliverySectionComponent().clickContinueButton();

		// Fill in Schedule Section
		createWestClipAlertPage.getScheduleSectionAlert().waitForScheduleSection();
		createWestClipAlertPage.getScheduleSectionAlert().selectFrequency(Frequency.WEEKLY);
		createWestClipAlertPage.getScheduleSectionAlert().clickSaveAlertButton();

		// Verify Alert is saved
		boolean isAlertPresent = alertsCenterPage.getAlertResultListComponent().isAlertPresentInList(WEST_CLIP_ALERT);
		Assert.assertTrue(isAlertPresent, "Alert is not saved.");

	}

	@Test
	public void createKeyCiteAlertTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();
		CreateKeyCiteAlertPage createKeyCiteAlertPage = alertsCenterPage.createAlert(AlertType.KEYCITE,
				CreateKeyCiteAlertPage.class);

		// Fill in Basics Section
		createKeyCiteAlertPage.getBasicsSectionComponent().enterAlertName(KEY_CITE_ALERT);
		createKeyCiteAlertPage.getBasicsSectionComponent().enterDescription("Masha");
		createKeyCiteAlertPage.getBasicsSectionComponent().enterCitation(CITATION_2);
		createKeyCiteAlertPage.getBasicsSectionComponent().clickContinueButton();

		// Fill in Content Section
		createKeyCiteAlertPage.getContentSection().waitForContentSection();
		createKeyCiteAlertPage.getContentSection().clickContinueButton();

		// Fill in Delivery Section
		createKeyCiteAlertPage.getDeliverySectionComponent().waitForDeliverySection();
		createKeyCiteAlertPage.getDeliverySectionComponent().enterDeliveryNote("Delivery Note");
		createKeyCiteAlertPage.getDeliverySectionComponent().clickContinueButton();

		// Fill in Schedule Section
		createKeyCiteAlertPage.getScheduleSectionAlert().waitForScheduleSection();
		createKeyCiteAlertPage.getScheduleSectionAlert().selectFrequency(Frequency.WEEKLY);
		// Fill in Day - Monday
		createKeyCiteAlertPage.getScheduleSectionAlert().selectWeekDay(Weekday.MONDAY);
		// Fill in Time - 10 am
		createKeyCiteAlertPage.getScheduleSectionAlert().selectTime(Time.AM_11_00);
		// Fill in End Date - 25 March 2021
		createKeyCiteAlertPage.getScheduleSectionAlert().enterEndDay("03/25/2021");
		// Fill in Time Zone - GMT Minsk
		createKeyCiteAlertPage.getScheduleSectionAlert().selectTimeZone(TimeZone.GMT__03_00);
		// Click Save Alert button
		createKeyCiteAlertPage.getScheduleSectionAlert().clickSaveAlertButton();

		// Verify Alert is saved
		boolean isAlertPresent = alertsCenterPage.getAlertResultListComponent().isAlertPresentInList(KEY_CITE_ALERT);
		Assert.assertTrue(isAlertPresent, "Alert is not saved.");

	}

}
