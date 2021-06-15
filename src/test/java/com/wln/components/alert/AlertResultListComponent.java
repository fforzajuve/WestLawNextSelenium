package com.wln.components.alert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class AlertResultListComponent extends BaseComponent {

	private static final By alertResultListContainerBy = By.id("alertListBody");
	private static final By alertItemElementBy = By.xpath("//li[@class='co_user_alert_item']");
	private static final By alertNameBy = By.xpath(".//h3/label");
	private static final By alertCheckboxBy = By.xpath(".//input[@type='checkbox']");
	private static final By alertEditLnkBy = By.xpath(".//a[@title='Edit Alert']");

	public AlertResultListComponent(DriverUtils driver) {
		super(driver);
	}
	
	public boolean isAlertPresentInList(String alertName) {
		logger.info("Is Alert Present in List? " + alertName);
		boolean isAlertPresent = false;
		List<WebElement> alertElements =  driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy);
		for(int i = 0; i < alertElements.size(); i++) {
			String name  = alertElements.get(i).findElement(alertNameBy).getText().trim();
			if(alertName.equals(name)) {
				isAlertPresent = true;
				break;
			}
		}
		logger.info("Alert Present in List: " + isAlertPresent);
		return isAlertPresent;	
	}

	public int getAlertNumberOnPage() {
		logger.info("Get Number of Alerts on page.");
		driver.waitForElementDisplayed(alertResultListContainerBy);
		int alertsCount = driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy).size();
		logger.info("Number of Alerts on page: " + alertsCount);
		return alertsCount;
	}

	public void selectAlertByIndex(int index, boolean selected) {
		logger.info("Select Alert by index: " + index);
		WebElement alertCheckbox = driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy).get(index)
			.findElement(alertCheckboxBy);
		if (alertCheckbox.isSelected() != selected) {
			alertCheckbox.click();
		}
	}

	public void selectAlertByName(String alertName,boolean selected) {
		logger.info("Select Alert by name: " + alertName);
		selectAlertByIndex(getAlertIndexByName(alertName), selected);
	}

	public void editAlertByIndex(int index) {
		logger.info("Edit Alert by index: " + index);
		driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy).get(index)
		.findElement(alertEditLnkBy).click();
	}

	public void editAlertByName(String alertName) {
		logger.info("Edit Alert by name: " + alertName);
		editAlertByIndex(getAlertIndexByName(alertName));
	}

	public String getAlertNameByIndex(int index) {
		logger.info("Get Alert Name by index: " + index);
		String alertName = driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy).get(index)
				.findElement(alertNameBy).getText();
		logger.info("Alert Name: " + alertName);
		return alertName;
	}

	private int getAlertIndexByName(String alertName) {
		List<WebElement> items = driver.findElement(alertResultListContainerBy).findElements(alertItemElementBy);
		for (int i = 0; i < items.size(); i++) {
			if (alertName.equals(items.get(i).findElement(alertNameBy).getText())) {
				return i;
			}
		}
		return -1;
	}
}
