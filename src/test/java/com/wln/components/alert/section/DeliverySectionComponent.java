package com.wln.components.alert.section;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.wln.components.BaseComponent;
import com.wln.dialogs.alert.AlertsContactDialog;
import com.wln.drivers.DriverUtils;
import com.wln.enums.alert.DeliverySectionTab;
import com.wln.enums.common.DeliveryFormat;
import com.wln.enums.common.FontSize;
import com.wln.enums.common.LinkColor;

public class DeliverySectionComponent extends BaseComponent {

	private static final By deliverySectionBy = By.xpath("//li[@id='deliverySection'and not(@class='co_collapsed')]");
	private static final By deliveryTabsContainerBy = By.id("co_deliveryOptions");
	private static final By activeTabBy = By.xpath("//li[contains(@class,'co_tabActive')]");
	private static final By continueBtnBy = By.id("co_button_continue_Delivery");
	private static final By subjectTxtBy = By.id("co_delivery_subject");
	private static final By noteTxtBy = By.id("co_delivery_note");
	private static final By myContactsLnkBy = By.id("co_delivery_open_addressBook");
	private static final By formatSelectBy = By.id("co_delivery_format_list");
	private static final By linkColorSelectBy = By.id("co_delivery_linkColor");
	private static final By fontSizeSelectBy = By.id("co_delivery_fontSize");
	private static final By includeCoverPageChkBy = By.id("coid_chkDdcLayoutCoverPage");

	private DeliverySummaryComponent deliverySummaryComponent;

	public DeliverySectionComponent(DriverUtils driver) {
		super(driver);
		deliverySummaryComponent = new DeliverySummaryComponent(driver);
	}

	public DeliverySummaryComponent getDeliverySummaryComponent() {
		return deliverySummaryComponent;
	}

	public DeliverySectionComponent selectDeliverySectionTab(DeliverySectionTab tab) {
		logger.info("Select Delivery Tab: " + tab.getName());
		driver.findElement(deliverySectionBy).findElements(By.className("co_tabLink")).stream()
				.filter(element -> element.getText().equals(tab.getName())).findFirst().get().click();
		return this;
	}

	public DeliverySectionTab getActiveDeliverySectionTab() {
		logger.info("Get Active Delivery Tab");
		String tabName = driver.findElement(deliveryTabsContainerBy).findElement(activeTabBy)
				.findElement(By.tagName("a")).getText();
		return DeliverySectionTab.getFrom(tabName);
	}

	public void enterDeliveryRecepient(String recepient) {
		logger.info("Enter Delivery Recepient: " + recepient);
	}

	public DeliverySectionComponent enterDeliverySubject(String subject) {
		logger.info("Enter Delivery Subject: " + subject);
		driver.findElement(subjectTxtBy).clear();
		driver.findElement(subjectTxtBy).sendKeys(subject);
		return this;
	}

	public String getDeliverySubject() {
		logger.info("Get Delivery Subject.");
		String subject = driver.findElement(subjectTxtBy).getAttribute("value");
		logger.info("Subject: " + subject);
		return subject;
	}

	public DeliverySectionComponent enterDeliveryNote(String note) {
		logger.info("Enter Delivery Note: " + note);
		driver.findElement(noteTxtBy).sendKeys(note);
		return this;
	}

	public String getDeliveryNote() {
		logger.info("Get Delivery Note.");
		String note = driver.findElement(noteTxtBy).getAttribute("value");
		logger.info("Note: " + note);
		return note;
	}

	public DeliverySectionComponent selectDeliveryFormat(DeliveryFormat format) {
		logger.info("Select Delivery Format: " + format.getName());
		Select formatSelect = new Select(driver.findElement(formatSelectBy));
		formatSelect.selectByVisibleText(format.getName());
		return this;
	}

	public DeliveryFormat getDeliveryFormat() {
		logger.info("Get Delivery Format.");
		Select formatSelect = new Select(driver.findElement(formatSelectBy));
		DeliveryFormat deliveryFormat = DeliveryFormat.getFrom(formatSelect.getFirstSelectedOption().getText());
		logger.info("Format: " + deliveryFormat.getName());
		return deliveryFormat;
	}

	public DeliverySectionComponent selectFontSize(FontSize fontSize) {
		logger.info("Select Font Size: " + fontSize.getName());
		Select fontSizeSelect = new Select(driver.findElement(fontSizeSelectBy));
		fontSizeSelect.selectByVisibleText(fontSize.getName());
		return this;
	}

	public FontSize getFontSize() {
		logger.info("Get Font Size.");
		Select fontSizeSelect = new Select(driver.findElement(fontSizeSelectBy));
		FontSize fontSize = FontSize.getFrom(fontSizeSelect.getFirstSelectedOption().getText());
		logger.info("Font Size: " + fontSize.getName());
		return fontSize;
	}

	public DeliverySectionComponent selectLinkColor(LinkColor linkColor) {
		logger.info("Select Link Color: " + linkColor.getName());
		Select linkColorSelect = new Select(driver.findElement(linkColorSelectBy));
		linkColorSelect.selectByVisibleText(linkColor.getName());
		return this;
	}

	public LinkColor getLinkColor() {
		logger.info("Get Link Color.");
		Select linkColorSelect = new Select(driver.findElement(linkColorSelectBy));
		LinkColor linkColor = LinkColor.getFrom(linkColorSelect.getFirstSelectedOption().getText());
		logger.info("Link Color: " + linkColor.getName());
		return linkColor;
	}

	public void selectFromMyContacts(int index) {
		logger.info("Select contact from My Contacts by index: " + index);
		AlertsContactDialog alertsContactDialog = openMyAlertContactsDialog();
		alertsContactDialog.selectContactByIndex(index);
		alertsContactDialog.clickAddSelectedToAlertButton();
	}

	public AlertsContactDialog openMyAlertContactsDialog() {
		logger.info("Open My Contacts dialog");
		driver.findElement(myContactsLnkBy).click();
		return new AlertsContactDialog(driver);
	}

	public void clickContinueButton() {
		logger.info("Click Continue button.");
		driver.findElement(continueBtnBy).click();
	}

	public boolean isDeliverySectionDisplayed() {
		boolean isDeliveryDisplayed = driver.isElementDisplayed(deliverySectionBy);
		logger.info("Is Delivery section displayed? " + isDeliveryDisplayed);
		return isDeliveryDisplayed;
	}

	public void waitForDeliverySection() {
		logger.info("Wait For Delivery section to be displayed.");
		driver.waitForElementDisplayed(deliverySectionBy);
	}

	public DeliverySectionComponent selectIncludeCoverPage(boolean select) {
		if (driver.findElement(includeCoverPageChkBy).isSelected() != select) {
			driver.findElement(includeCoverPageChkBy).click();
		}
		return this;
	}

	public boolean isIncludeCoverPageSelected() {
		boolean isSelected = driver.findElement(includeCoverPageChkBy).isSelected();
		logger.info("Is Include Cover Page Selected? " + isSelected);
		return isSelected;
	}

}
