package testPackages;

import Common.UIModule;
import PageObjects.AssertionTexts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;
import PageObjects.SuccessPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase2 extends UIModule {
	HomePage homePage = new HomePage();
	ContactsPage contactsPage = new ContactsPage();
	SuccessPage successPage = new SuccessPage();
	AssertionTexts assertText = new AssertionTexts();
	 WebDriver driver;

	@Parameters("url")
	@Test(invocationCount = 5)
	public void Test2(String url) throws Exception {
		try {

			 driver=initialiseDriver();
			navigateUrl(url,driver);
			homePage.goToConatactsPage(driver);
			contactsPage.enterForeNameField("Test",driver);
			contactsPage.enterEmailField("Test.test@test.com.au",driver);
			contactsPage.enterMessageField("Test",driver);
			contactsPage.submit(driver);
			successPage.waitUntilPageLoads(driver);
			Assert.assertTrue(verifyPageSourceContains(assertText.getMTSUCCESSPART1(),driver));
			Assert.assertTrue(verifyPageSourceContains(assertText.getMTSUCCESSPART2(),driver));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDriver(driver);
		}
	}

}
