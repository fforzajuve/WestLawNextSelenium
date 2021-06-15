package com.wln.pages;

import com.wln.drivers.DriverUtils;
import com.wln.utils.MyLogger;

public class BasePage {

	protected DriverUtils driver;
	protected MyLogger logger = MyLogger.getInstance();

	public BasePage(DriverUtils driver) {
		this.driver = driver;
	}

}
