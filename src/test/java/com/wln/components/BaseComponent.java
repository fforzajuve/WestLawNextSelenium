package com.wln.components;

import com.wln.drivers.DriverUtils;
import com.wln.utils.MyLogger;

public class BaseComponent {
	
    protected DriverUtils driver;
	protected MyLogger logger = MyLogger.getInstance();

	public BaseComponent(DriverUtils driver) {
		this.driver = driver;

	}


}
