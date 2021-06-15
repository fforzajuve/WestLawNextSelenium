package com.wln.tests.alert;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.dialogs.alert.DeleteAlertsDialog;
import com.wln.drivers.DriverManager;
import com.wln.enums.alert.AlertType;
import com.wln.enums.common.Frequency;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class CreateKeyCiteAlertTest extends WLNBaseTest {

	private static final String ALERT_NAME = "KeyCite001";
	private static final String ALERT_SAVED = "The alert (.*) has been saved.";
	private static final String ALERT_DELETED = "(.*) has been successfully deleted";
	private static final String CITATION_2 = "2012 WL 1521521";

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
		createKeyCiteAlertPage.getBasicsSectionComponent().enterAlertName(ALERT_NAME);
		createKeyCiteAlertPage.getBasicsSectionComponent().enterDescription("Masha");
		createKeyCiteAlertPage.getBasicsSectionComponent().enterCitation(CITATION_2);
		createKeyCiteAlertPage.getBasicsSectionComponent().clickContinueButton();

		// Fill in Content Section
		createKeyCiteAlertPage.getContentSection().waitForContentSection();
		createKeyCiteAlertPage.getContentSection().clickContinueButton();

		// Fill in Delivery Section
		createKeyCiteAlertPage.getDeliverySectionComponent().waitForDeliverySection();
		createKeyCiteAlertPage.getDeliverySectionComponent().clickContinueButton();

		// Fill in Schedule Section
		createKeyCiteAlertPage.getScheduleSectionAlert().waitForScheduleSection();
		createKeyCiteAlertPage.getScheduleSectionAlert().selectFrequency(Frequency.WEEKLY);

		// Click Save Alert button
		alertsCenterPage = createKeyCiteAlertPage.getScheduleSectionAlert().clickSaveAlertButton();

		// Verify Alert Created Message
		String infoMessage = alertsCenterPage.getInfoMessage();
		System.out.println("MESAGE: " + infoMessage);
		Assert.assertTrue(infoMessage.matches(ALERT_SAVED), "Alert Saved message is wrong.");

		boolean isAlertPresent = alertsCenterPage.getAlertResultListComponent().isAlertPresentInList(ALERT_NAME);
		Assert.assertTrue(isAlertPresent, "Alert is not saved.");

	}

	@Test
	public void deleteKeyCiteAlertTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();

		// Select Alert by Name
		alertsCenterPage.getAlertResultListComponent().selectAlertByName("KeyCite001", true);

		// Click Delete Button
		DeleteAlertsDialog deleteAlertDialog = alertsCenterPage.getAlertListToolbarComponent().clickDeleteAlertButton();

		// Delete Alert
		alertsCenterPage = deleteAlertDialog.clickDeleteButton();

		// Verify Alert Deleted Message
		String infoMessage = alertsCenterPage.getInfoMessage();
		Assert.assertTrue(infoMessage.matches(ALERT_DELETED), "Alert Deleted message is wrong.");

	}

}
