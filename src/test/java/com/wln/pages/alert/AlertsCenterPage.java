package com.wln.pages.alert;

import org.openqa.selenium.By;

import com.wln.components.alert.AlertListToolbarComponent;
import com.wln.components.alert.AlertNavigationMenuComponent;
import com.wln.components.alert.AlertResultListComponent;
import com.wln.components.alert.AlertTypeComponent;
import com.wln.components.alert.CreateAlertComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.alert.AlertType;
import com.wln.pages.WlnPostSignOnPage;
import com.wln.pages.alert.newsletter.CreateNewsletterPage;

public class AlertsCenterPage extends WlnPostSignOnPage {

	private static final By alertsCenterContainerBy = By.id("co_alertCenter");
	private static final By createAlertBtnBy = By.id("co_createAlertMenu");
	private static final By createNewsletterBtnBy = By.id("co_createNewsletter");
	private static final By infoMessageBy = By.xpath(".//div[@class='co_infoBox_message']");

	private AlertTypeComponent alertTypeComponent;
	private AlertResultListComponent alertResultListComponent;
	private AlertListToolbarComponent alertListToolbarComponent;
	private AlertNavigationMenuComponent navMenuComponent;

	public AlertsCenterPage(DriverUtils driver) {
		super(driver);
		alertTypeComponent = new AlertTypeComponent(driver);
		alertResultListComponent = new AlertResultListComponent(driver);
		alertListToolbarComponent = new AlertListToolbarComponent(driver);
		navMenuComponent = new AlertNavigationMenuComponent(driver);
	}

	public AlertTypeComponent getAlertTypeComponent() {
		return alertTypeComponent;
	}

	public AlertResultListComponent getAlertResultListComponent() {
		return alertResultListComponent;
	}

	public AlertListToolbarComponent getAlertListToolbarComponent() {
		return alertListToolbarComponent;
	}

	public AlertNavigationMenuComponent getNavMenuComponent() {
		return navMenuComponent;
	}

	public boolean isAlertsCenterDisplayed() {
		boolean isAlertsCenterDisplayed = driver.isElementDisplayed(alertsCenterContainerBy);
		logger.info("Is Alerts Center Displayed? " + isAlertsCenterDisplayed);
		return isAlertsCenterDisplayed;
	}

	public <P extends WlnPostSignOnPage> P createAlert(AlertType alertType, Class<P> pageClass) {
		logger.info("Click Create Alert button");
		driver.findElement(createAlertBtnBy).click();
		CreateAlertComponent createAlertComponent = new CreateAlertComponent(driver);
		logger.info("Select " + alertType.getName() + " to create.");
		createAlertComponent.selectAlertType(alertType.getName());

		try {
			P pageObject = (P) pageClass.getConstructor(DriverUtils.class).newInstance(driver);
			return pageObject;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ClassCastException(
					"QualityLibrary: Failed to create a new page window with the class: " + pageClass.toString());
		}

	}

	public String getInfoMessage() {
		logger.info("Get Info Message.");
		String message = driver.findElement(alertsCenterContainerBy).findElement(infoMessageBy).getText();
		logger.info("Info Message: " + message);
		return message;
	}

	public CreateNewsletterPage clickCreateNewsletterButton() {
		logger.info("Click Create Newsletter button.");
		driver.findElement(createNewsletterBtnBy).click();
		return new CreateNewsletterPage(driver);
	}
}
