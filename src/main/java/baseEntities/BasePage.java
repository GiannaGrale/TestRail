package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import utils.Waits;
import org.openqa.selenium.WebDriver;


public abstract class BasePage {
    protected WebDriver driver;
    protected static int waitForPageLoadingSec = 15;
    protected ReadProperties properties = new ReadProperties();
    protected BrowserService browserService;
    protected Waits waits;

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByURL) {
        this.driver = driver;
        this.waits = new Waits(driver, properties.getTimeout());
        properties = new ReadProperties();

        if (openPageByURL) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;

        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < waitForPageLoadingSec) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}