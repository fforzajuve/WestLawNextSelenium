package com.wln.components.alert;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.dialogs.alert.DeleteAlertsDialog;
import com.wln.drivers.DriverUtils;

public class AlertListToolbarComponent extends BaseComponent {
	
	private static final By deleteAlertBtnBy = By.cssSelector(".co_deleteItemsButton a");

	public AlertListToolbarComponent(DriverUtils driver) {
		super(driver);
	}
	
	public DeleteAlertsDialog clickDeleteAlertButton() {
		logger.info("Click delete alert button.");
		driver.findElement(deleteAlertBtnBy).click();
		return new DeleteAlertsDialog(driver);
	}

}
