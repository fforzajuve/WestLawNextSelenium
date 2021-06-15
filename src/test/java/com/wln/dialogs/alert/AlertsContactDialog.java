package com.wln.dialogs.alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.dialogs.BaseDialog;
import com.wln.drivers.DriverUtils;

public class AlertsContactDialog extends BaseDialog {
	
	private static final By alertContactsContainerBy = By.id("coid_contacts_lightbox");
	private static final By contactsListBy = By.id("coid_contacts_peopleListItems_contacts");
	private static final By contactItemBy = By.xpath("//li[contains(@class,'ui-draggable')]");
	private static final By contactNameBy = By.xpath("//a[contains(@id,'contactListBoxContent')]");
	private static final By addContactBtnBy = By.id("coid_contacts_closeButton");

	public AlertsContactDialog(DriverUtils driver) {
		super(driver);
		driver.waitForElementDisplayed(contactsListBy);
	}

	public void selectContactByIndex(int index) {
		logger.info("Select contact by index.");
		if(!isContactSelectedByIndex(index)) {
			WebElement contacElement = driver.findElement(contactsListBy).findElements(contactItemBy).get(0);
			contacElement.click();
		}
	}
	
	private boolean isContactSelectedByIndex(int index) {
		WebElement contacElement = driver.findElement(contactsListBy).findElements(contactItemBy).get(0);
		String classAttr = contacElement.findElement(contactNameBy).getAttribute("class");
		return classAttr.contains("co_checkbox_selected");
	}

	public void clickAddSelectedToAlertButton() {
		logger.info("Click Add Selected to Alert button.");
		driver.findElement(addContactBtnBy).click();
	}
}
