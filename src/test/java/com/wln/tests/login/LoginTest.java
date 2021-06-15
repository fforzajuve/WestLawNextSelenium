package com.wln.tests.login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.components.home.ProfileComponent;
import com.wln.drivers.DriverManager;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOffPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;
import com.wln.listeners.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class LoginTest extends WLNBaseTest {

	private static final String SIGN_OFF_MESSAGE = "You have signed off.";
	private static final String NAME = PropertiesUtil.getName();

	@Test
	public void loginTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Verify Logo
		boolean isLogoDisplayed = wlnHomePage.getHeaderComponent().isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");

		// Open Profile
		ProfileComponent profileComponent = wlnHomePage.getHeaderComponent().openProfileComponent();

		// Verify Name
		String nameInProfile = profileComponent.getUserName();
		Assert.assertEquals(nameInProfile, NAME, "Name is wrong");
	}

	@Test
	public void signOffTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Verify Logo
		boolean isLogoDisplayed = wlnHomePage.getHeaderComponent().isLogoDisplayed();
		Assert.assertTrue(isLogoDisplayed, "Logo is not displayed");

		// Open Profile
		ProfileComponent profileComponent = wlnHomePage.getHeaderComponent().openProfileComponent();

		// Sign Off from WLN
		SignOffPage signOffPage = profileComponent.signOff();

		// Verify Sign Off message
		String message = signOffPage.getSignOffMessage();
		Assert.assertEquals(message, SIGN_OFF_MESSAGE, "Sign Off message is wrong");
	}

}
