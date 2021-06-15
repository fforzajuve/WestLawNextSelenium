package com.wln.components.search.resultlist.toolbar;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.search.resultlist.toolbar.DetailLevel;

public class DetailLevelComponent extends BaseComponent {

	private static final By detailLevelContainerBy = By.id("co_searchDetailSliderTab");
	private static final By detailLevelOpenBtnBy = By.className("a11yDropdown-button");

	private static final String DETAILS_LEVEL_FORMAT = ".//span[contains(.,'%s')]/parent::li";

	public DetailLevelComponent(DriverUtils driver) {
		super(driver);
	}

	public void selectDetailLevel(DetailLevel detailLevel) {
		logger.info("Select Detail Level: " + detailLevel.getName());
		openComponent();
		String detailLevelLink = String.format(DETAILS_LEVEL_FORMAT, detailLevel.getName());
		driver.findElement(detailLevelContainerBy).findElement(By.xpath(detailLevelLink)).click();
	}

	public DetailLevel getDetailLevel() {
		logger.info("Get Detail Level.");
		openComponent();
		String detailLevel = driver.findElement(detailLevelContainerBy).findElements(By.tagName("li")).stream()
				.filter(e -> e.getAttribute("aria-checked").equals("true")).findFirst().get()
				.findElement(By.className("a11yDropdown-itemText")).getText();
		logger.info("Detail Level: " + detailLevel);
		return DetailLevel.getFrom(detailLevel);
	}

	private void openComponent() {
		if (!isComponentOpened()) {
			driver.findElement(detailLevelContainerBy).findElement(detailLevelOpenBtnBy).click();
		}

	}

	private boolean isComponentOpened() {
		String attr = driver.findElement(detailLevelContainerBy).findElement(detailLevelOpenBtnBy)
				.getAttribute("aria-expanded");
		return "true".equals(attr);
	}
}
