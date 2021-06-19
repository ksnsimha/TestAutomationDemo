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

public class TestCase3 extends UIModule {
	HomePage homePage = new HomePage();
	ShopPage shopPage = new ShopPage();
	CartPage cartPage = new CartPage();
	 WebDriver driver;
	@Test
	@Parameters("url")
	public void Test3(String url) {
		try {

			driver=initialiseDriver();

			navigateUrl(url,driver);
			homePage.goToShopPage(driver);

			shopPage.buyProduct(Products.FunnyCow, 2, driver);
			shopPage.buyProduct(Products.FluffuBunny, 1, driver);

			shopPage.waitUntilPageLoads(driver);


			homePage.goToCart(driver);
		

			String actual =cartPage.getProductQuantity(Products.FunnyCow,driver);
			Assert.assertEquals(actual, "2");
			actual =cartPage.getProductQuantity(Products.FluffuBunny,driver);
			Assert.assertEquals(actual, "1");
		} catch (Exception e) {
e.printStackTrace();
		} finally {
			closeDriver(driver);
		}
	}

}
