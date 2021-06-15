package com.wln.tests.preferences;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.dialogs.preferences.PreferencesDialog;
import com.wln.drivers.DriverManager;
import com.wln.enums.preferences.PreferenceTab;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class PreferencesTabTest extends WLNBaseTest {

	@Test
	public void checkProfileTabTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Preferences Dialog
		PreferencesDialog preferencesDialog = wlnHomePage.getFooterComponent().openPreferencesDialog();

		// Verify Profile tab is default
		PreferenceTab tab = preferencesDialog.getPreferencesTabComponent().getActiveTab();
		Assert.assertEquals(tab, PreferenceTab.PROFILE, "Profile tab is not default");
	}

	@Test
	public void checkSearchTabTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Open Preferences Dialog
		PreferencesDialog preferencesDialog = wlnHomePage.getFooterComponent().openPreferencesDialog();

		// Select Search tab
		preferencesDialog.getPreferencesTabComponent().selectTab(PreferenceTab.SEARCH);

		// Verify Profile tab is default
		PreferenceTab tab = preferencesDialog.getPreferencesTabComponent().getActiveTab();
		Assert.assertEquals(tab, PreferenceTab.SEARCH, "Search tab is not selected");
	}

}
