package testPackages;
import Common.UIModule;
import PageObjects.AssertionTexts;
import PageObjects.ContactsPage;
import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase1 extends UIModule {
    HomePage homePage = new HomePage();
    ContactsPage contactsPage = new ContactsPage();

    @Test
    @Parameters("url")
    public void Test1(String url) throws Exception {

        initialiseDriver();
        navigateUrl(url);
        homePage.goToConatactsPage();
        contactsPage.submit();
        Assert.assertEquals(contactsPage.getForeNameFieldErrorText(), AssertionTexts.MTFORENAMEMANDATORY);
        Assert.assertEquals(contactsPage.getEmailFieldErrorText(), AssertionTexts.MTEMAILMANDATORY);
        Assert.assertEquals(contactsPage.getMessageFieldErrorText(), AssertionTexts.MTMESSAGEMANDATORY);
        contactsPage.enterForeNameField("Test");
        contactsPage.enterEmailField("Test.test@test.com.au");
        contactsPage.enterMessageField("Test");
        
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getFORENAMEFIELD()));
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getEMAIlFIELD()));
        Assert.assertTrue(checkElementDoesNotExist(contactsPage.getMESSAGEFILED()));
        closeDriver();
    }


}
