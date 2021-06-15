package com.wln.tests.alert.newsletter;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.common.Frequency;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.newsletter.CreateNewsletterPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class CreateNewsletterTest extends WLNBaseTest {

	private static final String NEWSLETTER_SAVED = "The newsletter (.*) has been saved.";

	@Test
	public void createNewsletterTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage and click create newsletter button
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();
		CreateNewsletterPage createNewsletterPage = alertsCenterPage.clickCreateNewsletterButton();

		// Fill in Basics Section
		createNewsletterPage.getBasicsSectionComponent().enterNewsletterName("News001");
		createNewsletterPage.getBasicsSectionComponent().enterDescription("newsletter");
		createNewsletterPage.getBasicsSectionComponent().clickContinueButton();

		// Fill in Alerts Section
		createNewsletterPage.getAlertsSectionComponent().waitForAlertsSection();
		createNewsletterPage.getAlertsSectionComponent().addAlert("KeyCite001");
		createNewsletterPage.getAlertsSectionComponent().clickContinueButton();

		// Fill in Delivery Section
		createNewsletterPage.getDeliverySectionComponent().waitForDeliverySection();
		createNewsletterPage.getDeliverySectionComponent().enterDeliveryNote("My Newsletter");
		createNewsletterPage.getDeliverySectionComponent().clickContinueButton();

		// Fill in Schedule Section
		createNewsletterPage.getScheduleSectionComponent().waitForScheduleSection();
		createNewsletterPage.getScheduleSectionComponent().selectFrequency(Frequency.WEEKLY);
		createNewsletterPage.getScheduleSectionComponent().clickSaveAlertButton();

		// Verify Alert Created Message
		String infoMessage = alertsCenterPage.getInfoMessage();
		Assert.assertTrue(infoMessage.matches(NEWSLETTER_SAVED), "Newsletter Saved message is wrong.");

		// Select Newsletter View
		alertsCenterPage.getNavMenuComponent().selectNewsletters();

		boolean isNewsletterPresent = alertsCenterPage.getAlertResultListComponent().isAlertPresentInList("News001");
		Assert.assertTrue(isNewsletterPresent, "Newsletter is not present.");
	}

	@Test
	public void newsletterTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open AlertPage and click create newsletter button
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();

		// Select Newsletter View
		alertsCenterPage.getNavMenuComponent().selectNewsletters();

		boolean isNewsletterPresent = alertsCenterPage.getAlertResultListComponent().isAlertPresentInList("news001");
		Assert.assertTrue(isNewsletterPresent, "Newsletter is not present.");

		alertsCenterPage.getAlertResultListComponent().selectAlertByIndex(0, true);

		String name = alertsCenterPage.getAlertResultListComponent().getAlertNameByIndex(0);
		System.out.println(name);
	}

}
