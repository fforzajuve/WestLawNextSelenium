package com.wln.tests.alert.keycite;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.enums.alert.AlertType;
import com.wln.enums.alert.DeliverySectionTab;
import com.wln.enums.common.DeliveryFormat;
import com.wln.enums.common.FontSize;
import com.wln.enums.common.LinkColor;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class DeliverySectionTest extends WLNBaseTest {

	private static final LinkColor LINK_COLOR_BLACK = LinkColor.BLACK;
	private static final FontSize FONT_SIZE_LARGE = FontSize.LARGE;
	private static final DeliverySectionTab RECIPIENTS_TAB = DeliverySectionTab.RECIPIENTS;
	private static final DeliverySectionTab LAYOUT_TAB = DeliverySectionTab.LAYOUT_LIMITS;
	private static final String DELIVERY_NOTE = "Some Note";
	private static final String DELIVERY_SUBJECT = "Delivery";
	private static final DeliveryFormat DELIVERY_FORMAT = DeliveryFormat.PDF;
	private static final String CLIENT_ID = "TEST";
	private static final String ALERT_DESCRIPTION = "Masha";
	private static final String ALERT_NAME = "WescClip001";
	private static final String CITATION_1 = "2012 WL 1521521";

	@Test
	public void checkKeyCiteDeliverySectionTest() {
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
		createKeyCiteAlertPage.getContentSection().clickContinueButton();

		// Fill in Delivery Section
		createKeyCiteAlertPage.getDeliverySectionComponent().waitForDeliverySection();
		createKeyCiteAlertPage.getDeliverySectionComponent().selectFromMyContacts(0);
		createKeyCiteAlertPage.getDeliverySectionComponent().enterDeliverySubject(DELIVERY_SUBJECT);
		createKeyCiteAlertPage.getDeliverySectionComponent().enterDeliveryNote(DELIVERY_NOTE);
		createKeyCiteAlertPage.getDeliverySectionComponent().selectDeliveryFormat(DELIVERY_FORMAT);
		createKeyCiteAlertPage.getDeliverySectionComponent().clickContinueButton();

		// Verify Delivery Summary Section
		createKeyCiteAlertPage.getScheduleSectionAlert().waitForScheduleSection();

		// Summary Format
		String summaryFormat = createKeyCiteAlertPage.getDeliverySectionComponent().getDeliverySummaryComponent()
				.getSummaryFormat();
		Assert.assertEquals(summaryFormat, DELIVERY_FORMAT.getName(), "Delivery Format is wrong");

		// Open Delivery Section in Edit Mode
		createKeyCiteAlertPage.clickEditDeliveryLink();

		// Verify Delivery Section

		// Verify Subject
		String subject = createKeyCiteAlertPage.getDeliverySectionComponent().getDeliverySubject();
		Assert.assertEquals(subject, DELIVERY_SUBJECT, "Subject is wrong.");

		// Verify Note
		String note = createKeyCiteAlertPage.getDeliverySectionComponent().getDeliveryNote();
		Assert.assertEquals(note, DELIVERY_NOTE, "Note is wrong.");

		// Verify Format
		DeliveryFormat deliveryFormat = createKeyCiteAlertPage.getDeliverySectionComponent().getDeliveryFormat();
		Assert.assertEquals(deliveryFormat, DELIVERY_FORMAT, "Delivery Format is wrong.");

	}

	@Test
	public void checkDeliverySectionTabsTest() {
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
		createKeyCiteAlertPage.getContentSection().clickContinueButton();

		// Verify Delivery Section
		createKeyCiteAlertPage.getDeliverySectionComponent().waitForDeliverySection();

		// Verify LAYOUT LIMITS TAB
		createKeyCiteAlertPage.getDeliverySectionComponent().selectDeliverySectionTab(LAYOUT_TAB);
		DeliverySectionTab layoutTab = createKeyCiteAlertPage.getDeliverySectionComponent()
				.getActiveDeliverySectionTab();
		Assert.assertEquals(layoutTab, LAYOUT_TAB, "Delivery tab is wrong");

		// Select Link Color and Font Size
		createKeyCiteAlertPage.getDeliverySectionComponent().selectFontSize(FONT_SIZE_LARGE);
		createKeyCiteAlertPage.getDeliverySectionComponent().selectLinkColor(LINK_COLOR_BLACK);

		// Select Include Cover Page
		createKeyCiteAlertPage.getDeliverySectionComponent().selectIncludeCoverPage(true);

		// Verify RECIPIENTS TAB
		createKeyCiteAlertPage.getDeliverySectionComponent().selectDeliverySectionTab(RECIPIENTS_TAB);
		DeliverySectionTab recipientTab = createKeyCiteAlertPage.getDeliverySectionComponent()
				.getActiveDeliverySectionTab();
		Assert.assertEquals(recipientTab, RECIPIENTS_TAB, "Delivery tab is wrong");

		// Verify Link Color and Font Size
		createKeyCiteAlertPage.getDeliverySectionComponent().selectDeliverySectionTab(LAYOUT_TAB);

		// FONT SIZE
		FontSize fontSize = createKeyCiteAlertPage.getDeliverySectionComponent().getFontSize();
		Assert.assertEquals(fontSize, FONT_SIZE_LARGE, "Font Size is wrong");

		// Link Color
		LinkColor linkColor = createKeyCiteAlertPage.getDeliverySectionComponent().getLinkColor();
		Assert.assertEquals(linkColor, LINK_COLOR_BLACK, "Link color is wrong");

		// Verify Include Cover Page
		boolean isIncludeCoverPageSelected = createKeyCiteAlertPage.getDeliverySectionComponent()
				.isIncludeCoverPageSelected();
		Assert.assertTrue(isIncludeCoverPageSelected, "Include Cover Page is not selected.s");
	}

}
