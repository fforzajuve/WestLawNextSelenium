package com.wln.components.alert.section;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.enums.common.Frequency;
import com.wln.enums.common.Time;
import com.wln.enums.common.TimeZone;
import com.wln.enums.common.Weekday;
import com.wln.pages.alert.AlertsCenterPage;

public class ScheduleSectionComponent extends BaseComponent{
	
	private static final By frequencySelectBy = By.id("frequencySelect");
	private static final By weekdaySelectBy = By.id("weekdayDropDown");
	private static final By timeSelectBy = By.id("hourDropDown");
	private static final By timeZonesSelectBy = By.id("co_formSelect_timeZones");
	private static final By endDayTxtBy = By.id("endDate");
	private static final By scheduleSectionBy = By.xpath("//li[@id='scheduleSection'and not(@class='co_collapsed')]");
	private static final By saveAlertBtnBy = By.id("co_button_saveAlert");

	public ScheduleSectionComponent(DriverUtils driver) {
		super(driver);
	}

	
	public ScheduleSectionComponent selectFrequency(Frequency frequency) {
		logger.info("Select Frequency: " + frequency.getName());
		Select frequencySelect = new Select(driver.findElement(frequencySelectBy));
		frequencySelect.selectByVisibleText(frequency.getName());
		return this;
	}
	
	public ScheduleSectionComponent selectWeekDay(Weekday weekDay) {
		logger.info("Select Weekday: " + weekDay.getName());
		Select weekDaySelect = new Select(driver.findElement(weekdaySelectBy));
		weekDaySelect.selectByVisibleText(weekDay.getName());
		return this;
	}
	
	public ScheduleSectionComponent selectTime(Time time) {
		logger.info("Select Time: " + time.getName());
		Select timeSelect = new Select(driver.findElement(timeSelectBy));
		timeSelect.selectByVisibleText(time.getName());
		return this;
	}
	
	public ScheduleSectionComponent selectTimeZone(TimeZone timeZone) {
		logger.info("Select Time Zone: " + timeZone.getName());
		Select timeZoneSelect = new Select(driver.findElement(timeZonesSelectBy));
		timeZoneSelect.selectByVisibleText(timeZone.getName());
		return this;
	}
	
	public ScheduleSectionComponent enterEndDay(String endDay) {
		logger.info("Enter End Day: " + endDay);
		driver.findElement(endDayTxtBy).sendKeys(endDay);
		driver.findElement(scheduleSectionBy).click();
		return this;
	}
	
	public AlertsCenterPage clickSaveAlertButton() {
		logger.info("Click Save Alert button.");
		driver.findElement(saveAlertBtnBy).click();
		return new AlertsCenterPage(driver);
	}
	
	public boolean isScheduleSectionDisplayed() {
		boolean isScheduleDisplayed = driver.isElementDisplayed(scheduleSectionBy);
		logger.info("Is Schedule section displayed? " + isScheduleDisplayed);
		return isScheduleDisplayed;
	}
	
	public void waitForScheduleSection() {
		logger.info("Wait For Schedule section to be displayed.");
		driver.waitForElementDisplayed(scheduleSectionBy);
	}
	
}
