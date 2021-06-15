package com.wln.components.search.resultlist.toolbar;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.westclip.CreateWestClipAlertPage;

public class CreateAlertComponent extends BaseComponent {
	
	private static final By createAlertContainerBy = By.id("co_search_alertMenuControl");
	private static final By createAlertLnkBy = By.id("co_search_alertMenuOptionLink_WestClip");
	private static final By createAlertBtnBy = By.id("co_search_alertMenuLink");//NEED TO VERIFY

	public CreateAlertComponent(DriverUtils driver) {
		super(driver);
	}

	
	public CreateWestClipAlertPage clickCreateAlert() {
		logger.info("Click Create Alert link.");
		openComponent();
		driver.findElement(createAlertContainerBy).findElement(createAlertLnkBy).click();
		return new CreateWestClipAlertPage(driver);
	}


	private void openComponent() {
		if(!isComponentOpened()) {
			driver.findElement(createAlertBtnBy).click();
		}
		
	}
	
	private boolean isComponentOpened(){
		String className = driver.findElement(createAlertContainerBy).getAttribute("class");
		return className.contains("expanded");
	}
	
}
