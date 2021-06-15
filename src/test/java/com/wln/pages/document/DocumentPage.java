package com.wln.pages.document;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import com.wln.components.document.DocumentToolBarComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class DocumentPage extends WlnPostSignOnPage {
	
	private static final By headerBy = By.id("co_docHeaderTitleLine");
	private static final By docContainerBy = By.id("coid_website_documentWidgetDiv");
	private static final By docTitleBy = By.className("co_title");
	private static final By docCourtBy = By.id("courtline");
	private static final By docCitationBy = By.className("co_cites");
	private static final By docHeaderCitationBy = By.xpath("//h3[@id='co_docHeaderCitation']/span[contains(@id,'cite')]");
	private static final By investextLblBy = By.id("issuedate");
	
	private DocumentToolBarComponent toolbarComponent;

	public DocumentPage(DriverUtils driver) {
		super(driver);
		toolbarComponent = new DocumentToolBarComponent(driver);
	}
	
	public DocumentToolBarComponent getToolbarComponent() {
		return toolbarComponent;
	}
	
	public String getDocumentHeader() {
		logger.info("Get Document Header.");
		String header = driver.findElement(headerBy).getText().trim();
		logger.info("Document Header: " + header);
		return header;
	}
 
	public String getDocumentTitle() {
		logger.info("Get Document Title.");
		String title = driver.findElement(docContainerBy).findElement(docTitleBy).getText().trim();
		logger.info("Document Title: " + title);
		return title;
	}
	
	public String getDocumentCitation() {
		logger.info("Get Document Citation.");
		String citation = driver.findElement(docContainerBy).findElement(docCitationBy).getText();
		logger.info("Document Citation: " + citation);
		return citation;
	}
	
	public String getCourt() {
		logger.info("Get Document Court.");
		String court = driver.findElement(docCourtBy).getText();
		logger.info("Document Court: " + court);
		return court;
	}
	
	public List<String> getHeaderCitations() {
		logger.info("Get Document Citations.");
		List<String> citations = driver.findElements(docHeaderCitationBy).stream().map(cite -> cite.getText()).collect(Collectors.toList());
		logger.info("Citations: " + citations);
		return citations;
	}
	
	public boolean isInvestextDisplayed() {
		boolean isInvestextDisplayed = driver.isElementDisplayed(investextLblBy);
		logger.info("Is investext displayed on the document? " + isInvestextDisplayed);
		return isInvestextDisplayed;
	}
	
	public String getInvestext() {
		logger.info("Get investext.");
		String investext = driver.findElement(investextLblBy).getText().split(" ")[1];
		logger.info("Investext: " + investext );
		return investext;
	}
}
