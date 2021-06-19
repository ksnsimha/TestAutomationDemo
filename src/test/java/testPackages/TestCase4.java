package testPackages;

import Common.UIModule;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ShopPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase4 extends UIModule {
	HomePage homePage = new HomePage();
	CartPage cartPage = new CartPage();
	ShopPage shopPage = new ShopPage();
	 WebDriver driver;
	@Parameters("url")
	@Test
	public void Test4(String url)  {
		try {

			driver=initialiseDriver();
			navigateUrl(url,driver);
			
			
			homePage.goToShopPage(driver);
			shopPage.waitUntilPageLoads();
			shopPage.buyStuffedFrog(2,driver);
			shopPage.buyFluffyBunny(5,driver);
			shopPage.buyValentineBear(3,driver);
			

			
			
			String stuffedFrogPrice = shopPage.getFrogPrice(driver);
			String fluffyBunnyPrice = shopPage.getFluffyBunnyPrice(driver);
			String valentineBearPrice = shopPage.getValentineBearPrice(driver);
			
			
			homePage.goToCart(driver);
			
			int priceIndex = cartPage.getIndexofPrice();
			int subTotalIndex = cartPage.getIndexofSubTotal();
			
			
			Assert.assertEquals(getText(cartPage.getStuffedFogIndexValue(priceIndex),driver), stuffedFrogPrice);
			
			Assert.assertEquals(getText(cartPage.getFluffyBunnyIndexValue(priceIndex),driver), fluffyBunnyPrice);
			
			Assert.assertEquals(getText(cartPage.getValentineBearIndexValue(priceIndex),driver), valentineBearPrice);
			
			Assert.assertEquals(getText(cartPage.getStuffedFogIndexValue(subTotalIndex),driver),
					cartPage.getActualTotal(2, stuffedFrogPrice));

			Assert.assertEquals(getText(cartPage.getFluffyBunnyIndexValue(subTotalIndex),driver),
					cartPage.getActualTotal(5, fluffyBunnyPrice));

			Assert.assertEquals(getText(cartPage.getValentineBearIndexValue(subTotalIndex),driver),
					cartPage.getActualTotal(3, valentineBearPrice));
		} catch (Exception e) {

		} finally {

			closeDriver(driver);
		}
	}

}
