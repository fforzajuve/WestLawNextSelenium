package com.wln.components.search.resultlist;

import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class AdvancedSearchSummaryComponent extends BaseComponent {

	private static final By advancedSearchContainerBy = By.id("co_search_advancedSearch_summary");
	private static final By headerTextBy = By.id("co_search_advancedSearch_summaryHeaderText");
	private static final By editLnkBy = By.id("co_search_advancedSearch_summaryEdit");

	public AdvancedSearchSummaryComponent(DriverUtils driver) {
		super(driver);
	}

	public Map<String, String> getSearchOptions() {
		Map<String, String> options = driver.findElement(advancedSearchContainerBy).findElement(headerTextBy)
				.findElements(By.tagName("strong")).stream()
				.collect(Collectors.toMap(e -> e.getText().split(":")[0], e -> e.findElement(By.xpath(".//following-sibling::span")).getText()));
		return options;
	}

	public <P extends WlnPostSignOnPage> P clickEditLink(Class<P> pageClass) {
		logger.info("Click Edit Link.");
		driver.findElement(advancedSearchContainerBy).findElement(editLnkBy).click();
		
		try {
			P pageObject = (P) pageClass.getConstructor(DriverUtils.class).newInstance(driver);
			return pageObject;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ClassCastException(
					"QualityLibrary: Failed to create a new page window with the class: " + pageClass.toString());
		}
	}
}
