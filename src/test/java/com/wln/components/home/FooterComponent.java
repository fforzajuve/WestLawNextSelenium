package com.wln.components.home;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.dialogs.preferences.PreferencesDialog;
import com.wln.drivers.DriverUtils;

public class FooterComponent extends BaseComponent{
	
	private static final By preferencesLnkBy    = By.id("coid_websiteFooter_userSettings");

	public FooterComponent(DriverUtils driver) {
		super(driver);
	}
	
	public PreferencesDialog openPreferencesDialog() {
		logger.info("Open Preferences Dialog");
		driver.findElement(preferencesLnkBy).click();
		return new PreferencesDialog(driver);
	}

}
