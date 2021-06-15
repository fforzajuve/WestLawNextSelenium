package com.wln.dialogs.alert;

import org.openqa.selenium.By;

import com.wln.dialogs.BaseDialog;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.AlertsCenterPage;

public class DeleteAlertsDialog extends BaseDialog {
	
	private static final By yesBtnBy = By.id("co_delete_item_yes");
	private static final By cancelBtnBy = By.id("co_delete_item_cancel");

	public DeleteAlertsDialog(DriverUtils driver) {
		super(driver);
	}
	
	public AlertsCenterPage clickDeleteButton() {
		logger.info("Click Yes button.");
		driver.findElement(yesBtnBy).click();
		driver.waitForElementDisplayed(By.xpath("//*[contains(text(),'has been successfully deleted')]"));
		return new AlertsCenterPage(driver);
	}

	public AlertsCenterPage clickCancelButton() {
		logger.info("Click Cancel button.");
		driver.findElement(cancelBtnBy).click();
		return new AlertsCenterPage(driver);
	}
}
