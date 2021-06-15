package com.wln.pages.alert.newsletter;

import org.openqa.selenium.By;

import com.wln.components.alert.newsletter.sections.NewsletterAlertsSectionComponent;
import com.wln.components.alert.newsletter.sections.NewsletterBasicsSectionComponent;
import com.wln.components.alert.newsletter.sections.NewsletterDeliverySectionComponent;
import com.wln.components.alert.newsletter.sections.NewsletterScheduleSectionComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.CreateAlertPage;

public class CreateNewsletterPage extends CreateAlertPage {

	private static final By editBasicsLnkBy = By.id("coid_editLink_Basics");
	private static final By editAlertsLnkBy = By.id("coid_editLink_Content");
	private static final By editDeliveryLnkBy = By.id("coid_editLink_Delivery");

	private NewsletterBasicsSectionComponent basicsSectionComponent;
	private NewsletterAlertsSectionComponent alertsSectionComponent;
	private NewsletterDeliverySectionComponent deliverySectionComponent;
	private NewsletterScheduleSectionComponent scheduleSectionComponent;

	public CreateNewsletterPage(DriverUtils driver) {
		super(driver);
		basicsSectionComponent = new NewsletterBasicsSectionComponent(driver);
		alertsSectionComponent = new NewsletterAlertsSectionComponent(driver);
		deliverySectionComponent = new NewsletterDeliverySectionComponent(driver);
		scheduleSectionComponent = new NewsletterScheduleSectionComponent(driver);
	}

	public NewsletterBasicsSectionComponent getBasicsSectionComponent() {
		return basicsSectionComponent;
	}

	public NewsletterAlertsSectionComponent getAlertsSectionComponent() {
		return alertsSectionComponent;
	}

	public NewsletterDeliverySectionComponent getDeliverySectionComponent() {
		return deliverySectionComponent;
	}

	public NewsletterScheduleSectionComponent getScheduleSectionComponent() {
		return scheduleSectionComponent;
	}

	public CreateNewsletterPage clickEditBasicsLink() {
		logger.info("Click Edit link for Basics section.");
		driver.findElement(editBasicsLnkBy).click();
		return this;
	}

	public CreateNewsletterPage clickEditAlertsLink() {
		logger.info("Click Edit link for Alerts section.");
		driver.findElement(editAlertsLnkBy).click();
		return this;
	}

	public CreateNewsletterPage clickEditDeliveryLink() {
		logger.info("Click Edit link for Delivery section.");
		driver.findElement(editDeliveryLnkBy).click();
		return this;
	}

}
