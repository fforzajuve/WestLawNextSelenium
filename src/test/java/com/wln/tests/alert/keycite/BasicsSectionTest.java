package com.wln.tests.alert.keycite;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.alert.AlertType;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class BasicsSectionTest extends WLNBaseTest {

	private static final String CLIENT_ID = "TEST";
	private static final String NEW_CLIENT_ID = "ALESYA";
	private static final String ALERT_DESCRIPTION = "Masha";
	private static final String ALERT_NAME = "WescClip001";
	private static final String CITATION_1 = "2012 WL 1521521";

	@Test
	public void checkKeyCiteBasicsSectionTest() {

		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage(CLIENT_ID);

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();
		CreateKeyCiteAlertPage createKeyCiteAlertPage = alertsCenterPage.createAlert(AlertType.KEYCITE,
				CreateKeyCiteAlertPage.class);

		// Fill in Basics Section
		createKeyCiteAlertPage.getBasicsSectionComponent().enterAlertName(ALERT_NAME);
		createKeyCiteAlertPage.getBasicsSectionComponent().enterDescription(ALERT_DESCRIPTION);
		createKeyCiteAlertPage.getBasicsSectionComponent().enterCitation(CITATION_1);
		createKeyCiteAlertPage.getBasicsSectionComponent().clickContinueButton();

		// Verify Basics Summary Section
		createKeyCiteAlertPage.getContentSection().waitForContentSection();

		// Summary Alert Name
		String summaryAlertName = createKeyCiteAlertPage.getBasicsSectionComponent().getBasicsSummaryComponent()
				.getSummaryAlertName();
		Assert.assertEquals(summaryAlertName, ALERT_NAME, "Summary Alert Name is wrong");

		// Summary Client ID
		String summaryClientId = createKeyCiteAlertPage.getBasicsSectionComponent().getBasicsSummaryComponent()
				.getSummaryClientId();
		Assert.assertEquals(summaryClientId, CLIENT_ID, "Summary Client ID is wrong");

		// Summary Alert Description
		String summaryAlertDescription = createKeyCiteAlertPage.getBasicsSectionComponent().getBasicsSummaryComponent()
				.getSummaryDescription();
		Assert.assertEquals(summaryAlertDescription, ALERT_DESCRIPTION, "Summary Description is wrong");

		// Summary Citation
		String summaryCitation = createKeyCiteAlertPage.getBasicsSectionComponent().getBasicsSummaryComponent()
				.getSummaryCitation();
		Assert.assertEquals(summaryCitation, CITATION_1, "Summary Citation is wrong");

		// Open Basics Section in Edit Mode
		createKeyCiteAlertPage.clickEditBasicsLink();

		// Verify Basics Section

		// Alert Name
		String alertName = createKeyCiteAlertPage.getBasicsSectionComponent().getAlertName();
		Assert.assertEquals(alertName, ALERT_NAME, "Alert Name is wrong");

		// Alert Desc
		String desc = createKeyCiteAlertPage.getBasicsSectionComponent().getAlertDescription();
		Assert.assertEquals(desc, ALERT_DESCRIPTION, "Alert Description is wrong");

		// Alert Citation
		String citation = createKeyCiteAlertPage.getBasicsSectionComponent().getCitation();
		Assert.assertEquals(citation, CITATION_1, "Citation is wrong");

		// Client ID
		String clientId = createKeyCiteAlertPage.getBasicsSectionComponent().getClientId();
		Assert.assertEquals(clientId, CLIENT_ID, "Client ID is wrong");

	}

	@Test
	public void checkChangeClientIdOnBasicsSectionTest() {

		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage(CLIENT_ID);

		// Open AlertPage
		AlertsCenterPage alertsCenterPage = wlnHomePage.getHeaderComponent().openAlertsCenterPage();
		CreateKeyCiteAlertPage createKeyCiteAlertPage = alertsCenterPage.createAlert(AlertType.KEYCITE,
				CreateKeyCiteAlertPage.class);

		// Change Client Id on Basics Section
		createKeyCiteAlertPage.getBasicsSectionComponent().enterAlertName(ALERT_NAME);
		createKeyCiteAlertPage.getBasicsSectionComponent().changeClientId(NEW_CLIENT_ID);
		createKeyCiteAlertPage.getBasicsSectionComponent().enterDescription(ALERT_DESCRIPTION);

		// Verify Client ID
		String clientId = createKeyCiteAlertPage.getBasicsSectionComponent().getClientId();
		Assert.assertEquals(clientId, NEW_CLIENT_ID, "Client ID is wrong");
	}

}
