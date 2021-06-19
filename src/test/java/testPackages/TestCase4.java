package testPackages;

import Common.UIModule;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase4 extends UIModule {
	HomePage homePage = new HomePage();
	CartPage cartPage = new CartPage();
	ShopPage shopPage = new ShopPage();

	@Parameters("url")
	@Test
	public void Test4(String url) throws Exception {

		initialiseDriver();
		navigateUrl(url);
		homePage.goToShopPage();
		shopPage.waitUntilPageLoads();
		shopPage.buyStuffedFrog(2);
		shopPage.buyFluffyBunny(5);
		shopPage.buyValentineBear(3);
		homePage.goToCart();

		int priceIndex = cartPage.getIndexofPrice();
		int subTotalIndex = cartPage.getIndexofSubTotal();

		String stuffedFrogPrice = shopPage.getFrogPrice();
		Assert.assertEquals(getText(cartPage.getStuffedFogIndexValue(priceIndex)), stuffedFrogPrice);
		String fluffyBunnyPrice = shopPage.getFluffyBunnyPrice();
		Assert.assertEquals(getText(cartPage.getFluffyBunnyIndexValue(priceIndex)), fluffyBunnyPrice);
		String valentineBearPrice = shopPage.getValentineBearPrice();
		Assert.assertEquals(getText(cartPage.getValentineBearIndexValue(priceIndex)), valentineBearPrice);
		Assert.assertEquals(getText(cartPage.getStuffedFogIndexValue(subTotalIndex)),
				cartPage.getActualTotal(2, stuffedFrogPrice));

		Assert.assertEquals(getText(cartPage.getFluffyBunnyIndexValue(subTotalIndex)),
				cartPage.getActualTotal(5, fluffyBunnyPrice));

		Assert.assertEquals(getText(cartPage.getValentineBearIndexValue(subTotalIndex)),
				cartPage.getActualTotal(3, valentineBearPrice));

		closeDriver();
	}

}
