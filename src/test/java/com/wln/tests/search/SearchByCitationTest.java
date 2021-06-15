package com.wln.tests.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.document.DocumentPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class SearchByCitationTest extends WLNBaseTest {

	private static final String CITATION = "2014 WL 2186473";
	private static final String DOCUMENT_HEADER = "Robinson v. Legro";
	private static final String DOCUMENT_COURT = "Supreme Court of Colorado.";

	@Test
	public void searcByCitationTest() {
		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search by Citation
		DocumentPage documentPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearchByCitation(CITATION);

		// Verify Document Header
		String docHeader = documentPage.getDocumentHeader();
		Assert.assertEquals(docHeader, DOCUMENT_HEADER, "Document header is wrong");

		// Verify Court
		String court = documentPage.getCourt();
		Assert.assertEquals(court, DOCUMENT_COURT, "Court is wrong");
	}

}
