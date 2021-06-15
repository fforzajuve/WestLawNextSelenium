package com.wln.components.alert.section;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class ContentSectionComponent extends BaseComponent{
	
	private static final By contentSectionBy = By.xpath("//li[@id='contentSection'and not(@class='co_collapsed')]");
	private static final By continueBtnBy = By.id("co_button_continue_Content");
	
	
	private static final String CONTENT_FORMAT = ".//li[contains(@id,'co_wizardStep')]//a[contains(.,'%s')]/preceding-sibling::i";

	public ContentSectionComponent(DriverUtils driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public ContentSectionComponent addContent(String content) {
		logger.info("Select Content: " + content);
		String contentIcon = String.format(CONTENT_FORMAT, content);
		driver.findElement(contentSectionBy).findElement(By.xpath(contentIcon)).click();
		return this;
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
