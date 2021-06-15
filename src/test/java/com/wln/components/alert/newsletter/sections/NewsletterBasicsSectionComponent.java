package com.wln.components.alert.newsletter.sections;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;

public class NewsletterBasicsSectionComponent extends BaseComponent {

	private static final By basicSectionBy = By.xpath("//li[@id='basicsSection'and not(@class='co_collapsed')]");
	private static final By newsletterNameTxtBy = By.id("optionsAlertName");
	private static final By newsletterDescriptionTxtBy = By.id("optionsAlertDescription");
	private static final By continueBtnBy = By.id("co_button_continue_Basics");

	public NewsletterBasicsSectionComponent(DriverUtils driver) {
		super(driver);
	}

	public NewsletterBasicsSectionComponent enterNewsletterName(String name) {
		logger.info("Enter Newsletter Name: " + name);
		driver.findElement(newsletterNameTxtBy).sendKeys(name);
		return this;
	}

	public String getAlertName() {
		logger.info("Get Newsletter Name.");
		String name = driver.findElement(newsletterNameTxtBy).getAttribute("value").trim();
		logger.info("Newsletter Name: " + name);
		return name;
	}

	public NewsletterBasicsSectionComponent enterDescription(String desc) {
		logger.info("Enter Newsletter Description: " + desc);
		driver.findElement(newsletterDescriptionTxtBy).sendKeys(desc);
		return this;
	}

	public String getAlertDescription() {
		logger.info("Get Newsletter Description.");
		String desc = driver.findElement(newsletterDescriptionTxtBy).getAttribute("value").trim();
		logger.info("Newsletter Description: " + desc);
		return desc;
	}

	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}

	public boolean isBasicsSectionDisplayed() {
		boolean isBasicsDisplayed = driver.isElementDisplayed(basicSectionBy);
		logger.info("Is Basics section displayed? " + isBasicsDisplayed);
		return isBasicsDisplayed;
	}

	public void waitForBasicsSection() {
		logger.info("Wait For Basics section to be displayed.");
		driver.waitForElementDisplayed(basicSectionBy);
	}
}
