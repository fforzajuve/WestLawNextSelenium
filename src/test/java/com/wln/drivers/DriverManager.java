package com.wln.drivers;

import org.openqa.selenium.WebDriverException;

public class DriverManager {

	private static ThreadLocal<DriverUtils> defaultDriver = new ThreadLocal<DriverUtils>();

	private DriverManager() {

	}

	public static DriverUtils getDriver() {
		if (null == defaultDriver.get()) {
			getNewDriver();
		}
		return defaultDriver.get();
	}

	public static void setDefaultDriver(DriverUtils driver) {
		defaultDriver.set(driver);
	}

	public static DriverUtils reopenDefaultDriver() {
		closeDefaultDriver();
		return getDriver();
	}

	/**
	 * Close default driver
	 */
	public static void closeDefaultDriver() {
		DriverUtils current = defaultDriver.get();
		try {
			closeDriver(current);
		} finally {
			defaultDriver.set(null);
		}
	}

	private static void closeDriver(DriverUtils driver) {
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (WebDriverException exc) {
			if (exc.getMessage().contains("Error communicating with the remote browser. It may have died.")) {
				System.out.println(exc.getMessage());
			}

		}
	}

	private synchronized static DriverUtils getNewDriver() {
		DriverUtils driver = new DriverUtils();
		driver.maximizeWindow();
		defaultDriver.set(driver);
		return driver;
	}

}
