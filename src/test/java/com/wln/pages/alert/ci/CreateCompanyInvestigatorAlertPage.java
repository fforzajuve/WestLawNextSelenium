package com.wln.pages.alert.ci;

import org.openqa.selenium.By;

import com.wln.components.alert.ci.sections.CompanyInvestigatorBasicsSectionComponent;
import com.wln.components.alert.ci.sections.CompanyInvestigatorContentSectionComponent;
import com.wln.components.alert.ci.sections.CompanyInvestigatorDeliverySectionComponent;
import com.wln.components.alert.ci.sections.CompanyInvestigatorScheduleSectionComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.CreateAlertPage;

public class CreateCompanyInvestigatorAlertPage extends CreateAlertPage {

	private static final By editBasicsLnkBy = By.id("coid_editLink_Basics");
	private static final By editContentLnkBy = By.id("coid_editLink_Content");
	private static final By editDeliveryLnkBy = By.id("coid_editLink_Delivery");

	private CompanyInvestigatorBasicsSectionComponent basicsSectionComponent;
	private CompanyInvestigatorContentSectionComponent contentSectionComponent;
	private CompanyInvestigatorDeliverySectionComponent deliverySectionComponent;
	private CompanyInvestigatorScheduleSectionComponent scheduleSectionComponent;

	public CreateCompanyInvestigatorAlertPage(DriverUtils driver) {
		super(driver);
		basicsSectionComponent = new CompanyInvestigatorBasicsSectionComponent(driver);
		contentSectionComponent = new CompanyInvestigatorContentSectionComponent(driver);
		deliverySectionComponent = new CompanyInvestigatorDeliverySectionComponent(driver);
		scheduleSectionComponent = new CompanyInvestigatorScheduleSectionComponent(driver);
	}

	public CompanyInvestigatorBasicsSectionComponent getBasicsSectionComponent() {
		return basicsSectionComponent;
	}

	public CompanyInvestigatorContentSectionComponent getContentSectionComponent() {
		return contentSectionComponent;
	}

	public CompanyInvestigatorDeliverySectionComponent getDeliverySectionComponent() {
		return deliverySectionComponent;
	}

	public CompanyInvestigatorScheduleSectionComponent getScheduleSectionComponent() {
		return scheduleSectionComponent;
	}

	public CreateCompanyInvestigatorAlertPage clickEditBasicsLink() {
		logger.info("Click Edit link for Basics section.");
		driver.findElement(editBasicsLnkBy).click();
		return this;
	}

	public CreateCompanyInvestigatorAlertPage clickEditContentLink() {
		logger.info("Click Edit link for Content section.");
		driver.findElement(editContentLnkBy).click();
		return this;
	}

	public CreateCompanyInvestigatorAlertPage clickEditDeliveryLink() {
		logger.info("Click Edit link for Delivery section.");
		driver.findElement(editDeliveryLnkBy).click();
		return this;
	}

}
