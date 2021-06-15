package com.wln.components.home;

import org.openqa.selenium.By;

import com.wln.components.BaseComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.login.SignOffPage;

public class ProfileComponent extends BaseComponent {
	
	private static final By profileContainerBy = By.id("co_signOffContainer");
	private static final By userNameLblBy = By.cssSelector(".co_signOff_profile h4");
	private static final By signOffBtnBy = By.cssSelector(".co_signOff_buttons button");

	public ProfileComponent(DriverUtils driver) {
		super(driver);
	}
	
	public String getUserName() {
		logger.info("Get User Name.");
		String name = driver.findElement(userNameLblBy).getText().trim();
		logger.info("User Name: " + name);
		return name;
	}
	
	public SignOffPage signOff() {
		logger.info("Click Sign Off button.");
		driver.findElement(signOffBtnBy).click();
		return new SignOffPage(driver);
	}

}
