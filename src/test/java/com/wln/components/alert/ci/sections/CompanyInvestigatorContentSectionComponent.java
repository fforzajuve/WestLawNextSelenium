package com.wln.components.alert.ci.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class CompanyInvestigatorContentSectionComponent extends BaseComponent {
	
	private static final By contentSectionBy = By.xpath("//li[@id='contentSection'and not(@class='co_collapsed')]");
	private static final By continueBtnBy = By.id("co_button_continue_Content");
	private static final By allItemsChkBy = By.id("checkbox_all_items_select");
	
	private static final String CONTENT_FORMAT = ".//input[@displayname='%s']";

	public CompanyInvestigatorContentSectionComponent(DriverUtils driver) {
		super(driver);
	}
	
	public CompanyInvestigatorContentSectionComponent selectContent(String content, boolean selected) {
		logger.info("Select: " + content + " Status: " + selected);
		String contentCheckBox = String.format(CONTENT_FORMAT, content);
		WebElement contentElement  = driver.findElement(contentSectionBy).findElement(By.xpath(contentCheckBox));
		if(contentElement.isSelected() != selected) {
			contentElement.click();
		}
		return this;				
	}
	
	public void selectAllContent() {
		logger.info("Select All Contents");
		WebElement allItemsElement = driver.findElement(contentSectionBy).findElement(allItemsChkBy);
		if(!allItemsElement.isSelected()) {
			allItemsElement.click();
		}
	}

	public void deselectAllContent() {
		logger.info("DeSelect All Contents");
		WebElement allItemsElement = driver.findElement(contentSectionBy).findElement(allItemsChkBy);
		if(!allItemsElement.isSelected()) {
			allItemsElement.click();
		}
		allItemsElement.click();
	}
	
	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}
	
	public boolean isContentSectionDisplayed() {
		boolean isContentDisplayed = driver.isElementDisplayed(contentSectionBy);
		logger.info("Is Content section displayed? " + isContentDisplayed);
		return isContentDisplayed;
	}
	
	public void waitForContentSection() {
		logger.info("Wait For Content section to be displayed.");
		driver.waitForElementDisplayed(contentSectionBy);
	}
}
