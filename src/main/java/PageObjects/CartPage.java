package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;

public class CartPage extends UIModule {
	private By CHECKOUTBUTTON = By.partialLinkText("Check Out");

	public By getCHECKOUTBUTTON() {
		return CHECKOUTBUTTON;
	}

	public void setCHECKOUTBUTTON(By cHECKOUTBUTTON) {
		CHECKOUTBUTTON = cHECKOUTBUTTON;
	}

	public void waitUntilPageLoads() throws Exception {

		@SuppressWarnings("deprecation")
		WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getCHECKOUTBUTTON()));
	}



	public By returnByLocatorForPrice(String productName) {
		By anchor = By.xpath("//td[contains(text(),'" + productName + "')]/following-sibling::*");
		return anchor;
	}
	
	public By returnByLocatorForQuantity(String productName) {

		By anchor = By.xpath("//td[contains(text(),'" + productName
				+ "')]/following-sibling::*/following-sibling::*/child::input");
		

		return anchor;
	}
	
	public String getProductQuantity(String product,WebDriver Driver) throws Exception {
		By by = returnByLocatorForQuantity(product);
		return getValueAttribute(by,Driver);
	}

	public By returnByLocatorForSubTotal(String productName) {

		By anchor = By.xpath("//td[contains(text(),'" + productName
				+ "')]//following-sibling::*/following-sibling::*/following-sibling::*");

		return anchor;
	}

	public String getCartPriceForProduct(String product, WebDriver driver) throws Exception {
		By by = returnByLocatorForPrice(product);

		String result = getText(by, driver);
		return result;

	}

	public String getSubTotalForProduct(String product, WebDriver driver) throws Exception {
		By by = returnByLocatorForSubTotal(product);
		String result = getText(by, driver);
		return result;

	}

	public String getActualTotal(float i, String price) {
		price = price.replace("$", "");
		String totalPrice = new BigDecimal(price).multiply(new BigDecimal(i)).toString();
		return "$" + totalPrice;
	}

}
