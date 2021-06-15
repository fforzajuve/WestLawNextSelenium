package com.wln.pages.alert.westclip;

import com.wln.components.alert.section.BasicsSectionComponent;
import com.wln.components.alert.section.ContentSectionComponent;
import com.wln.components.alert.section.DeliverySectionComponent;
import com.wln.components.alert.section.ScheduleSectionComponent;
import com.wln.components.alert.section.SearchSectionComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.CreateAlertPage;

public class CreateWestClipAlertPage extends CreateAlertPage {
	
	private BasicsSectionComponent basicsSectionComponent;
	private ContentSectionComponent contentSection;
	private SearchSectionComponent searchSectionComponent;
	private DeliverySectionComponent deliverySectionComponent;
	private ScheduleSectionComponent scheduleSectionAlert;

	public CreateWestClipAlertPage(DriverUtils driver) {
		super(driver);
		basicsSectionComponent = new BasicsSectionComponent(driver);
		contentSection = new ContentSectionComponent(driver);
		searchSectionComponent = new SearchSectionComponent(driver);
		deliverySectionComponent = new DeliverySectionComponent(driver);
		scheduleSectionAlert = new ScheduleSectionComponent(driver);
	}
	
	public BasicsSectionComponent getBasicsSectionComponent() {
		return basicsSectionComponent;
	}
	
	public ContentSectionComponent getContentSection() {
		return contentSection;
	}

	public SearchSectionComponent getSearchSectionComponent() {
		return searchSectionComponent;
	}

	public DeliverySectionComponent getDeliverySectionComponent() {
		return deliverySectionComponent;
	}

	public ScheduleSectionComponent getScheduleSectionAlert() {
		return scheduleSectionAlert;
	}

}
