package com.wln.components.alert;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class CreateAlertComponent extends BaseComponent{
	
	private static final By createAlertContainerBy = By.id("co_createAlertNavContent");
	
	private static final String ALERT_TYPE_FORMAT = ".//li//a[contains(.,'%s')]";

	public CreateAlertComponent(DriverUtils driver) {
		super(driver);
	}
	
	public void selectAlertType(String alertType) {
		logger.info("Select " + alertType + " alert.");
		String alertTypeLink = String.format(ALERT_TYPE_FORMAT, alertType);
		driver.findElement(createAlertContainerBy).findElement(By.xpath(alertTypeLink)).click();
	}

}
