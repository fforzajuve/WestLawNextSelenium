package com.wln.dialogs.preferences;

import com.wln.components.preferences.PreferencesTabComponent;
import com.wln.dialogs.BaseDialog;
import com.wln.drivers.DriverUtils;

public class PreferencesDialog extends BaseDialog {
	
	private PreferencesTabComponent preferencesTabComponent;

	public PreferencesDialog(DriverUtils driver) {
		super(driver);
		preferencesTabComponent = new PreferencesTabComponent(driver);
	}

	public PreferencesTabComponent getPreferencesTabComponent() {
		return preferencesTabComponent;
	}

}
