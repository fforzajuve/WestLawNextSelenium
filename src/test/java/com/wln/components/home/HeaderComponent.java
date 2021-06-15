package com.wln.components.home;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.components.search.SearchComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.alert.AlertsCenterPage;
import com.wln.pages.login.WlnHomePage;

public class HeaderComponent extends BaseComponent {

	private static final By foldersLnkBy = By.xpath("//li[@id='co_recentFoldersContainer']//a");
	private static final By historyLnkBy = By.xpath("//li[@id='co_recentHistoryContainer']//a");
	private static final By alertLnkBy   = By.xpath("//li[@id='co_alertsCenterContainer']/a");
	private static final By logoLnkBy    = By.id("coid_website_logo");
	private static final By signOffContainerBy = By.id("co_signOffContainer");
	private static final By headerContainerBy = By.id("co_headerContainer");
	
	private SearchComponent searchComponent;

	public HeaderComponent(DriverUtils driver) {
		super(driver);
		searchComponent = new SearchComponent(driver);
	}
	
	public SearchComponent getSearchComponent() {
		return searchComponent;
	}
	
	
	public boolean isLogoDisplayed() {
		boolean isLogoDisplayed = driver.isElementDisplayed(logoLnkBy);
		logger.info("Is Logo displyed? " + isLogoDisplayed);
		return isLogoDisplayed;
	}
	
	public WlnHomePage openHomePage() {
		logger.info("Open Home Page.");
		driver.findElement(logoLnkBy).click();
		return new WlnHomePage(driver);
	}
	
	public ProfileComponent openProfileComponent() {
		logger.info("Open Profile widget");
		if(!isProfileExpanded()) {
			driver.findElement(signOffContainerBy).findElement(By.tagName("button")).click();
		}
		return new ProfileComponent(driver);
	}
	
	private boolean isProfileExpanded() {
		String containerClass = driver.findElement(signOffContainerBy).findElement(By.tagName("div")).getAttribute("class");
		return   "co_dropdownTabExpanded".equals(containerClass);
	}


	public AlertsCenterPage openAlertsCenterPage() {
		logger.info("Open Alerts Center Page.");
		driver.findElement(alertLnkBy).click();
		return new AlertsCenterPage(driver);
	}

}
