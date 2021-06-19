package testPackages;

import Common.UIModule;
import PageObjects.CartPage;
import PageObjects.HomePage;
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

			// From Home Page Go to shop page
			navigateUrl(url,driver);
			homePage.goToShopPage(driver);

			shopPage.waitUntilPageLoads(driver);

			// Click 2 times on Funny Cow
			shopPage.buyFunnyCow(2,driver);

			// click 1 time on fluffy bunny
			shopPage.buyFluffyBunny(1,driver);

			// Click on Cart menu
			homePage.goToCart(driver);
			int quantityIndex = cartPage.getIndexofQuantity(driver);

			// Verify Cart Menu
			Assert.assertEquals(getValueAttribute(cartPage.getFunnyCowquantity(quantityIndex),driver), "2");

			Assert.assertEquals(getValueAttribute(cartPage.getFluffyBunnyquantity(quantityIndex),driver), "1");
		} catch (Exception e) {
e.printStackTrace();
		} finally {
			closeDriver(driver);
		}
	}

}
