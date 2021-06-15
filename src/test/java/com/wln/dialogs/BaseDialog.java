package com.wln.dialogs;

import org.openqa.selenium.By;

import com.wln.drivers.DriverUtils;
import com.wln.utils.MyLogger;

public class BaseDialog {
	
	private static final By closeDialogBtnBy = By.className("co_overlayBox_closeButton");
	
	protected DriverUtils driver;
	protected MyLogger logger = MyLogger.getInstance();

	public BaseDialog(DriverUtils driver) {
		this.driver = driver;

	}
	
	public void closeDialog() {
		driver.findElement(closeDialogBtnBy).click();
	}

}
