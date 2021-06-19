package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.UIModule;

public class HomePage extends UIModule {
		private By CONTACTSLINK = By.linkText("Contact");
	    private By SHOPLINK = By.linkText("Shop");
	    private By CARTLINK = By.partialLinkText("Cart");
	

    public void goToConatactsPage(WebDriver driver) throws Exception {
        click(CONTACTSLINK,driver);
    }

    public void goToShopPage(WebDriver driver) throws Exception {
        click(SHOPLINK,driver);
    }

    public void goToCart(WebDriver driver) throws Exception {
        click(CARTLINK,driver);
    }
}
