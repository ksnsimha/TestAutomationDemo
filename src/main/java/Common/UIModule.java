package Common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class UIModule {
    public  WebDriver driver;

    public WebDriver initialiseDriver() throws Exception {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public void navigateUrl(String url,WebDriver driver) throws Exception {
        driver.navigate().to(url);
    }

    public void click(By by, WebDriver driver) throws Exception {
        fluentWait(by, 10,driver).click();
    }

    public void enterText(By by, String text, WebDriver driver) throws Exception {
        fluentWait(by, 5,driver).clear();
        fluentWait(by, 5,driver).sendKeys(text);
    }

    public String getText(By by, WebDriver driver) throws Exception {
        return fluentWait(by, 15,driver).getText();
    }

    public String getValueAttribute(By by, WebDriver driver) throws Exception {
        return fluentWait(by, 15,driver).getAttribute("value");
    }

    public boolean verifyPageSourceContains(String text,WebDriver driver) throws Exception {
        return driver.getPageSource().contains(text);
    }

    public WebElement fluentWait(By by, int time,WebDriver driver) throws Exception {
        WebElement currentElement = null;
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class).
                            ignoring(StaleElementReferenceException.class);
            currentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return currentElement;

        } catch (Exception e) {
            System.out.println("Waiting for element to be displayed");
        }
        return currentElement;

    }

    public boolean checkElementDoesNotExist(By by,WebDriver driver) throws Exception {
        try {
            driver.findElement(by);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void closeDriver(WebDriver driver) {
        driver.quit();
    }


}
