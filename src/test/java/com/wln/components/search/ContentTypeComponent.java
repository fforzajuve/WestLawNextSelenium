package com.wln.components.search;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.search.ContentType;
import com.wln.pages.search.SearchResultsPage;

public class ContentTypeComponent extends BaseComponent {

	private static final By contentTypeContainerBy = By.id("co_contentTypeLinksBox");
	private static final By activeContentTypeBy = By.className("co_leftColumn_activePage");

	private static final String CONTENT_TYPE_FORMAT = ".//li//a[contains(.,'%s')]";

	public ContentTypeComponent(DriverUtils driver) {
		super(driver);
	}

	public ContentType getActiveContentType() {
		logger.info("Get Active Content Type.");
		String content = driver.findElement(contentTypeContainerBy).findElement(activeContentTypeBy)
				.findElement(By.tagName("strong")).getText();
		logger.info("Active Content Type: " + content);
		return ContentType.getFrom(content);
	}

	public SearchResultsPage selectContentType(ContentType contentType) {
		logger.info("Set Active Content Type to: " + contentType);
		if (!contentType.equals(getActiveContentType())) {
			String contentTypeLink = String.format(CONTENT_TYPE_FORMAT, contentType.toString());
			driver.findElement(contentTypeContainerBy).findElement(By.xpath(contentTypeLink)).click();
		}
		return new SearchResultsPage(driver);
	}

	public int getContentTypeResultCount(ContentType contentType) {
		logger.info("Get Result Number for Content Type: " + contentType);
		if (!contentType.equals(getActiveContentType())) {
			String contentTypeLink = String.format(CONTENT_TYPE_FORMAT, contentType.toString());
			String count = driver.findElement(contentTypeContainerBy).findElement(By.xpath(contentTypeLink))
					.findElement(By.xpath("./preceding-sibling::span")).getText().replaceAll(",", "");
			logger.info("Result Number for Content Type " + contentType + " : " + count );
			return Integer.parseInt(count);
		} else {
			String count = driver.findElement(contentTypeContainerBy).findElement(activeContentTypeBy)
					.findElement(By.tagName("span")).getText().replaceAll(",", "");
			logger.info("Result Number for Content Type " + contentType + " : " + count );
			return Integer.parseInt(count);
		}
	}
}
