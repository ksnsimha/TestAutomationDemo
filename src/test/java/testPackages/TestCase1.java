package testPackages;
import Common.UIModule;
import PageObjects.AssertionTexts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends UIModule {
    HomePage homePage = new HomePage();
    ContactsPage contactsPage = new ContactsPage();
    AssertionTexts assertText = new AssertionTexts();
    WebDriver driver;
    @Test
    @Parameters("url")
    public void Test1(String url) {
    	try {

    		driver=initialiseDriver();
        navigateUrl(url,driver);
        homePage.goToConatactsPage(driver);
        contactsPage.submit(driver);
        Assert.assertEquals(contactsPage.getForeNameFieldErrorText(driver), assertText.getMTFORENAMEMANDATORY());
        Assert.assertEquals(contactsPage.getEmailFieldErrorText(driver), assertText.getMTEMAILMANDATORY());
        Assert.assertEquals(contactsPage.getMessageFieldErrorText(driver), assertText.getMTMESSAGEMANDATORY());
        contactsPage.enterForeNameField("Test",driver);
        contactsPage.enterEmailField("Test.test@test.com.au",driver);
        contactsPage.enterMessageField("Test",driver);
       
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getFORENAMEFIELDERROR(),driver));
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getEMAIlFIELDERROR(),driver));
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getMESSAGEFILEDERROR(),driver));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
        closeDriver(driver);
    	}
    }


}
