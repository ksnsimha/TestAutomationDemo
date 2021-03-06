package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage extends UIModule {

	private By STUFFEDFROGPRICEFIELD = By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//p//span");
	private By FLUFFYBUNNYPRICEFIELD = By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//p//span");
	private By VALENTINEBEARPRICEFIELD = By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//p//span");
	private By BUYFUNNYCOWLINK = By.xpath(".//h4[contains(text(),'Funny Cow')]/ancestor::li//a");
	private By BUYFLUFFYBUNNYLINK = By.xpath(".//h4[contains(text(),'Fluffy Bunny')]/ancestor::li//a");
	private By BUYSTUFFEDFROGLINK = By.xpath(".//h4[contains(text(),'Stuffed Frog')]/ancestor::li//a");
	private By BUYVALENTINEBEARLINK = By.xpath(".//h4[contains(text(),'Valentine Bear')]/ancestor::li//a");

	public By getSTUFFEDFROGPRICEFIELD() {
		return STUFFEDFROGPRICEFIELD;
	}

	public void setSTUFFEDFROGPRICEFIELD(By sTUFFEDFROGPRICEFIELD) {
		STUFFEDFROGPRICEFIELD = sTUFFEDFROGPRICEFIELD;
	}

	public By getFLUFFYBUNNYPRICEFIELD() {
		return FLUFFYBUNNYPRICEFIELD;
	}

	public void setFLUFFYBUNNYPRICEFIELD(By fLUFFYBUNNYPRICEFIELD) {
		FLUFFYBUNNYPRICEFIELD = fLUFFYBUNNYPRICEFIELD;
	}

	public By getVALENTINEBEARPRICEFIELD() {
		return VALENTINEBEARPRICEFIELD;
	}

	public void setVALENTINEBEARPRICEFIELD(By vALENTINEBEARPRICEFIELD) {
		VALENTINEBEARPRICEFIELD = vALENTINEBEARPRICEFIELD;
	}

	public By getBUYFUNNYCOWLINK() {
		return BUYFUNNYCOWLINK;
	}

	public void setBUYFUNNYCOWLINK(By bUYFUNNYCOWLINK) {
		BUYFUNNYCOWLINK = bUYFUNNYCOWLINK;
	}

	public By getBUYFLUFFYBUNNYLINK() {
		return BUYFLUFFYBUNNYLINK;
	}

	public void setBUYFLUFFYBUNNYLINK(By bUYFLUFFYBUNNYLINK) {
		BUYFLUFFYBUNNYLINK = bUYFLUFFYBUNNYLINK;
	}

	public By getBUYSTUFFEDFROGLINK() {
		return BUYSTUFFEDFROGLINK;
	}

	public void setBUYSTUFFEDFROGLINK(By bUYSTUFFEDFROGLINK) {
		BUYSTUFFEDFROGLINK = bUYSTUFFEDFROGLINK;
	}

	public By getBUYVALENTINEBEARLINK() {
		return BUYVALENTINEBEARLINK;
	}

	public void setBUYVALENTINEBEARLINK(By bUYVALENTINEBEARLINK) {
		BUYVALENTINEBEARLINK = bUYVALENTINEBEARLINK;
	}

	public By returnByLocatorForPrice(String productName) {
		By anchor = By.xpath("//h4[contains(text(),'" + productName + "')]");

		By locator = RelativeLocator.with(By.tagName("span")).below(anchor);
		return locator;
	}

	public By returnByLocatorForBuy(String productName) {
		By anchor = By.xpath("//h4[contains(text(),'" + productName + "')]");
		By locator = RelativeLocator.with(By.xpath("//a[contains(text(),'Buy')]")).below(anchor);
		return locator;

	}

	public void buyProduct(String Product, int number, WebDriver driver) throws Exception {

		for (int i = 0; i < number; i++) {
			click(returnByLocatorForBuy(Product), driver);
		}
	}

	public String getPrice(String Product, WebDriver driver) throws Exception {
		String resultText = null;
		try {
			resultText = getText(returnByLocatorForPrice(Product), driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultText;
	}

	public void waitUntilPageLoads(WebDriver driver) throws Exception {
		@SuppressWarnings("deprecation")
		WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Buy")));
	}

}
