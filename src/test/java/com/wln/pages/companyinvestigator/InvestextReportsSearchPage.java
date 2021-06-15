package com.wln.pages.companyinvestigator;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.wln.drivers.DriverUtils;
import com.wln.enums.ci.ReportDate;
import com.wln.pages.browse.BrowsePage;

public class InvestextReportsSearchPage extends BrowsePage {

	private static final By companyNameTxtBy = By.id("co_search_advancedSearch_NA");
	private static final By tickerTxtBy = By.id("co_search_advancedSearch_TS");
	private static final By reportDateSelectBy = By.id("co_dateWidget_DA");
	private static final By reportDateSelectedBy = By.id("co_dateWidget_DA_dropdown_span");
	private static final By industrySelectBy = By.id("co_search_advancedSearch_TRBC");
	private static final By reportTypeContainerBy = By.className("co_search_advancedSearch_verticalList");

	private static final String REPORT_DATE_FORMAT = ".//div[@class='co_facet_sad_footerRight']//li/span/a[contains(.,'%s')]";

	public InvestextReportsSearchPage(DriverUtils driver) {
		super(driver);
	}

	public InvestextReportsSearchPage enterCompanyName(String companyName) {
		logger.info("Enter Company Name: " + companyName);
		driver.findElement(companyNameTxtBy).sendKeys(companyName);
		return this;
	}

	public String getCompanyName() {
		logger.info("Get Company Name.");
		String companyName = driver.findElement(companyNameTxtBy).getAttribute("value");
		logger.info("Company Name: " + companyName);
		return companyName;
	}

	public InvestextReportsSearchPage enterTickerSymbol(String ticker) {
		logger.info("Enter Ticker: " + ticker);
		driver.findElement(tickerTxtBy).sendKeys(ticker);
		return this;
	}

	public InvestextReportsSearchPage selectReportDate(ReportDate date) {
		logger.info("Select Report Date: " + date);
		if (date != getReportDate()) {
			expandReportDateDropdown();
			String reportDateLink = String.format(REPORT_DATE_FORMAT, date.getName());
			driver.findElement(reportDateSelectBy).findElement(By.xpath(reportDateLink)).click();
		}

		return this;
	}

	public ReportDate getReportDate() {
		logger.info("Get Report Date.");
		String reportDate = driver.findElement(reportDateSelectBy).findElement(reportDateSelectedBy).getText();
		logger.info("Report Date: " + reportDate);
		return ReportDate.getFrom(reportDate);
	}

	private void expandReportDateDropdown() {
		if (!isReportDateExpanded()) {
			driver.findElement(reportDateSelectBy).click();
		}
	}

	private boolean isReportDateExpanded() {
		String classAttr = driver.findElement(reportDateSelectBy).getAttribute("class");
		return "co_facet_sad co_expanded".equals(classAttr);
	}

	public InvestextReportsSearchPage selectIndustry(String industry) {
		logger.info("Select Industry: " + industry);
		Select industrySelect = new Select(driver.findElement(industrySelectBy));
		industrySelect.selectByVisibleText(industry);
		return this;
	}

	public String getIndustry() {
		logger.info("Get Industry.");
		Select industrySelect = new Select(driver.findElement(industrySelectBy));
		String industry = industrySelect.getFirstSelectedOption().getText();
		logger.info("Industry: " + industry);
		return industry;
	}

	public void selectReportType(String type, boolean selected) {
		logger.info("Select Report Type: " + type);
		WebElement checkbox = driver.findElement(reportTypeContainerBy).findElements(By.tagName("li")).stream()
				.filter(element -> element.findElement(By.tagName("label")).getText().equals(type)).findFirst().get()
				.findElement(By.tagName("input"));

		if (checkbox.isSelected() != selected) {
			checkbox.click();
		}
	}

	public List<String> getReportTypes() {
		logger.info("Get Report Type.");
		List<String> reportTypes = driver.findElement(reportTypeContainerBy).findElements(By.tagName("li")).stream()
				.filter(e -> e.findElement(By.tagName("input")).isSelected())
				.map(e -> e.findElement(By.tagName("label")).getText()).collect(Collectors.toList());
		logger.info("Get Report Type: " + reportTypes);
		return reportTypes;
	}

}
