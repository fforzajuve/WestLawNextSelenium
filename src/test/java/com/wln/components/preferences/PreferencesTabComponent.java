package com.wln.components.preferences;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.preferences.PreferenceTab;

public class PreferencesTabComponent extends BaseComponent {

	private static final By tabsContainerBy = By.id("coid_userSettingsTabs");
	private static final By activeTabBy = By.className("co_tabActive");

	public PreferencesTabComponent(DriverUtils driver) {
		super(driver);
	}

	public void selectTab(PreferenceTab tab) {
		logger.info("Select tab: " + tab);
		if (tab != getActiveTab()) {
			driver.findElement(tabsContainerBy).findElement(By.linkText(tab.getName())).click();
		}
	}

	public PreferenceTab getActiveTab() {
		String tabName = driver.findElement(tabsContainerBy).findElement(activeTabBy).findElement(By.tagName("a"))
				.getText();
		logger.info("Active tab: " + tabName);
		return PreferenceTab.getFrom(tabName);
	}
}
