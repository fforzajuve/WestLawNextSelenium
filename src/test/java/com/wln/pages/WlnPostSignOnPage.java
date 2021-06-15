package com.wln.pages;

import com.wln.components.home.FooterComponent;
import com.wln.components.home.HeaderComponent;
import com.wln.drivers.DriverUtils;

public class WlnPostSignOnPage extends BasePage {

	private HeaderComponent headerComponent;
	private FooterComponent footerComponent;

	public WlnPostSignOnPage(DriverUtils driver) {
		super(driver);
		headerComponent = new HeaderComponent(driver);
		footerComponent = new FooterComponent(driver);
	}

	public HeaderComponent getHeaderComponent() {
		return headerComponent;
	}

	public FooterComponent getFooterComponent() {
		return footerComponent;
	}



}
