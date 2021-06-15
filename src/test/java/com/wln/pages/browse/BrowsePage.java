package com.wln.pages.browse;

import com.wln.components.browse.BrowseHeaderComponent;
import com.wln.drivers.DriverUtils;
import com.wln.pages.WlnPostSignOnPage;

public class BrowsePage extends WlnPostSignOnPage {

	private BrowseHeaderComponent browseHeaderComponent;

	public BrowsePage(DriverUtils driver) {
		super(driver);
		browseHeaderComponent = new BrowseHeaderComponent(driver);
	}

	public BrowseHeaderComponent getBrowseHeaderComponent() {
		return browseHeaderComponent;
	}

}
