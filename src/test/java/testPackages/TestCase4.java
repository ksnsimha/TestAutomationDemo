package testPackages;

import Common.UIModule;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.Products;
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
	public void Test4(String url) {
		try {

			driver = initialiseDriver();
			navigateUrl(url, driver);

			homePage.goToShopPage(driver);
			shopPage.waitUntilPageLoads(driver);

			shopPage.buyProduct(Products.StuffedFrog, 2, driver);
			shopPage.buyProduct(Products.FluffuBunny, 2, driver);
			shopPage.buyProduct(Products.ValentineBear, 2, driver);

			String stuffedFrogPrice = shopPage.getPrice(Products.StuffedFrog, driver);
			String fluffyBunnyPrice = shopPage.getPrice(Products.FluffuBunny, driver);
			String valentineBearPrice = shopPage.getPrice(Products.ValentineBear, driver);

			homePage.goToCart(driver);
			String cartStuffedFrogPrice = cartPage.getCartPriceForProduct(Products.StuffedFrog, driver);
			String cartFluffyBunnyPrice = cartPage.getCartPriceForProduct(Products.FluffuBunny, driver);
			String cartValentineBearPrice = cartPage.getCartPriceForProduct(Products.ValentineBear, driver);

			Assert.assertEquals(cartStuffedFrogPrice, stuffedFrogPrice);

			Assert.assertEquals(cartFluffyBunnyPrice, fluffyBunnyPrice);

			Assert.assertEquals(cartValentineBearPrice, valentineBearPrice);

			String actual = cartPage.getSubTotalForProduct(Products.StuffedFrog, driver);
			String expected = cartPage.getActualTotal(2, stuffedFrogPrice);

			Assert.assertEquals(actual, expected);
			actual = cartPage.getSubTotalForProduct(Products.FluffuBunny, driver);
			expected = cartPage.getActualTotal(2, fluffyBunnyPrice);

			Assert.assertEquals(actual, expected);

			actual = cartPage.getSubTotalForProduct(Products.ValentineBear, driver);
			expected = cartPage.getActualTotal(2, valentineBearPrice);

			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeDriver(driver);
		}
	}

}
