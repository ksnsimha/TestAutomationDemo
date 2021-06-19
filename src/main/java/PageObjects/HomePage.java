package PageObjects;

import org.openqa.selenium.By;

import Common.UIModule;

public class HomePage extends UIModule {
		private By CONTACTSLINK = By.linkText("Contact");
	    private By SHOPLINK = By.linkText("Shop");
	    private By CARTLINK = By.partialLinkText("Cart");
	

    public void goToConatactsPage() throws Exception {
        click(CONTACTSLINK);
    }

    public void goToShopPage() throws Exception {
        click(SHOPLINK);
    }

    public void goToCart() throws Exception {
        click(CARTLINK);
    }
}
