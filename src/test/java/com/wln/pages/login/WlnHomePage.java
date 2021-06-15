package com.wln.pages.login;

import org.openqa.selenium.By;

import com.wln.components.browse.BrowseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class WlnHomePage extends WlnPostSignOnPage {

	private static final By welcomeMessageContainerBy = By.id("co_welcomeCenterLightbox");

	private BrowseComponent browseComponent;

	public WlnHomePage(DriverUtils driver) {
		super(driver);
		browseComponent = new BrowseComponent(driver);
		handleWelcomeMessage();
	}

	public BrowseComponent getBrowseComponent() {
		return browseComponent;
	}

	private void handleWelcomeMessage() {
		if (driver.isElementDisplayed(welcomeMessageContainerBy)) {
			driver.findElement(welcomeMessageContainerBy).findElement(By.cssSelector("input[value='Close']")).click();
		}

	}
}
