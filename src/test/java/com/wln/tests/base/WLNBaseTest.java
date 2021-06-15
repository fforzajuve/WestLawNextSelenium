package com.wln.tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.wln.drivers.DriverManager;
import com.wln.utils.PropertiesUtil;



public class WLNBaseTest {
	
	@BeforeMethod
	public void setUp() {

		DriverManager.getDriver().get(PropertiesUtil.getBaseUrl());
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.closeDefaultDriver();
	}

}
