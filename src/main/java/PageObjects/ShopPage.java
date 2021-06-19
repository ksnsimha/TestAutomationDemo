package PageObjects;

import Common.UIModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

	public void waitUntilPageLoads() throws Exception {
		@SuppressWarnings("deprecation")
		WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Buy")));
	}

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

	public void buyFluffyBunny(int number,WebDriver driver) throws Exception {
		for (int i = 0; i < number; i++) {
			click(getBUYFLUFFYBUNNYLINK(),driver);
		}

	}

	public void buyStuffedFrog(int number,WebDriver driver ) throws Exception {
		for (int i = 0; i < number; i++) {
			click(getBUYSTUFFEDFROGLINK(),driver);
		}

	}

	public void buyValentineBear(int number,WebDriver driver) throws Exception {
		for (int i = 0; i < number; i++) {
			click(getVALENTINEBEARPRICEFIELD(),driver);
		}

	}

	public void buyFunnyCow(int number,WebDriver driver) throws Exception {
		for (int i = 0; i < number; i++) {
			click(getBUYFUNNYCOWLINK(),driver);
		}
	}

	public String getFrogPrice(WebDriver driver) {
		String resultText = null;
		try {
			resultText = getText(getSTUFFEDFROGPRICEFIELD(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultText;
	}

	public String getValentineBearPrice(WebDriver driver) {
		String resultText = null;
		try {
			resultText = getText(getBUYVALENTINEBEARLINK(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultText;
	}

	public String getFluffyBunnyPrice(WebDriver driver) {
		String resultText = null;
		try {
			resultText = getText(getFLUFFYBUNNYPRICEFIELD(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return resultText;
	}

}
