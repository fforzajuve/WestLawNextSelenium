package com.wln.tests.document;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wln.bo.User;
import com.wln.drivers.DriverManager;
import com.wln.pages.alert.keycite.CreateKeyCiteAlertPage;
import com.wln.pages.document.DocumentPage;
import com.wln.pages.login.ClientIdPage;
import com.wln.pages.login.SignOnPage;
import com.wln.pages.login.WlnHomePage;
import com.wln.tests.base.WLNBaseTest;
import com.wln.utils.PropertiesUtil;

public class DocumentTest extends WLNBaseTest {

	private static final String CITATION = "2014 WL 2186473";
	private static final List<String> DOCUMENT_CITATIONS = Arrays.asList("325 P.3d 1053", "2014 WL 2186473",
			"2014 CO 40");

	@Test
	public void documentCitationsTest() {

		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search by Citation
		DocumentPage documentPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearchByCitation(CITATION);

		// Verify Citations
		List<String> citations = documentPage.getHeaderCitations();
		Assert.assertEquals(citations, DOCUMENT_CITATIONS, "Citations are wrong");

	}

	@Test
	public void documentCreateAlertTest() {

		// Login to WLN
		User user = new User(PropertiesUtil.getUserName(), PropertiesUtil.getPassword());
		SignOnPage signOnPage = new SignOnPage(DriverManager.getDriver());
		ClientIdPage clientIdPage = signOnPage.setUsernamePasswordAndSignOn(user);
		WlnHomePage wlnHomePage = clientIdPage.setClientIdAndContinueToHomePage("TEST");

		// Do search by Citation
		DocumentPage documentPage = wlnHomePage.getHeaderComponent().getSearchComponent().doSearchByCitation(CITATION);

		// Get Document main citation
		String docCitation = documentPage.getDocumentCitation();

		// Create Alert
		CreateKeyCiteAlertPage createKeyCiteAlertPage = documentPage.getToolbarComponent().clickCreateKeyCiteAlert();

		// Verify Top Breadcrumb
		String topBreadcrumb = createKeyCiteAlertPage.getTopBreadcrumb();
		Assert.assertEquals(topBreadcrumb, docCitation, "Top breadcrumb is wrong");

		// Verify Citation
		String citation = createKeyCiteAlertPage.getBasicsSectionComponent().getCitation();
		Assert.assertEquals(citation, docCitation, "Citation in basics section is wrong");
	}

}
