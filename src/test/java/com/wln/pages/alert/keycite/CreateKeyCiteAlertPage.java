package com.wln.pages.alert.keycite;

import org.openqa.selenium.By;

import com.wln.components.alert.section.BasicsSectionComponent;
import com.wln.components.alert.section.ContentSectionComponent;
import com.wln.components.alert.section.DeliverySectionComponent;
import com.wln.components.alert.section.ScheduleSectionComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.CreateAlertPage;

public class CreateKeyCiteAlertPage extends CreateAlertPage {

	private static final By editBasicsLnkBy = By.id("coid_editLink_Basics");
	private static final By editContentLnkBy = By.id("coid_editLink_Content");
	private static final By editDeliveryLnkBy = By.id("coid_editLink_Delivery");

	private BasicsSectionComponent basicsSectionComponent;
	private ContentSectionComponent contentSection;
	private DeliverySectionComponent deliverySectionComponent;
	private ScheduleSectionComponent scheduleSectionAlert;

	public CreateKeyCiteAlertPage(DriverUtils driver) {
		super(driver);
		basicsSectionComponent = new BasicsSectionComponent(driver);
		contentSection = new ContentSectionComponent(driver);
		deliverySectionComponent = new DeliverySectionComponent(driver);
		scheduleSectionAlert = new ScheduleSectionComponent(driver);
	}

	public BasicsSectionComponent getBasicsSectionComponent() {
		return basicsSectionComponent;
	}

	public ContentSectionComponent getContentSection() {
		return contentSection;
	}

	public DeliverySectionComponent getDeliverySectionComponent() {
		return deliverySectionComponent;
	}

	public ScheduleSectionComponent getScheduleSectionAlert() {
		return scheduleSectionAlert;
	}

	public CreateKeyCiteAlertPage clickEditBasicsLink() {
		logger.info("Click Edit link for Basics section.");
		driver.findElement(editBasicsLnkBy).click();
		return this;
	}

	public CreateKeyCiteAlertPage clickEditContentLink() {
		logger.info("Click Edit link for Content section.");
		driver.findElement(editContentLnkBy).click();
		return this;
	}

	public CreateKeyCiteAlertPage clickEditDeliveryLink() {
		logger.info("Click Edit link for Delivery section.");
		driver.findElement(editDeliveryLnkBy).click();
		return this;
	}
}
