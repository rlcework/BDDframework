package base.testbase;

import base.utilities.BrowserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class TestBase {


    private final BrowserManager browser;

    public TestBase(BrowserManager browser) {
        this.browser = browser;
    }

    private static Logger logger = LogManager.getLogger(TestBase.class.getName());

    public void explicitWait(String obj) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(browser.getDriver(), Duration.ofSeconds(10));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
    }

    public void switchToDefault() throws Exception {
        try {
            browser.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            setSteptoFail(e.toString());
        }
    }

    public void setSteptoFail(String message) throws Exception {
        logger.debug(message);
        Assert.fail(message);
    }

    public void navigate(String obj) {

        browser.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        browser.getDriver().get(obj);
    }

    public void enter(String text, String obj) {
        browser.getDriver().findElement(By.xpath(obj)).sendKeys(text);
    }

    public void click(String obj) throws Exception {
        try {
            browser.getDriver().findElement(By.xpath(obj)).click();
        } catch (Exception e) {
            setSteptoFail(e.toString());
        }
    }

    public void verifyVisibility(String obj) throws Exception {
        try {
            browser.getDriver().findElement(By.xpath(obj)).isDisplayed();
        } catch (Exception e) {
            setSteptoFail(e.toString());
        }
    }


}
