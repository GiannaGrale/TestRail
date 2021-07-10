package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaseViewPage extends BasePage {
    private final static String endpoint = "index.php?/cases/view";
    private final static By message_Success_By = By.className("message-success");
    private final static By test_Cases_EDIT_By = By.cssSelector(".toolbar .toolbar-button-last");
    private final static By test_Cases_Navigation_Button_By = By.id("navigation-cases-section");

    public CaseViewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getMessageSuccess().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getMessageSuccess() {
        return driver.findElement(message_Success_By);
    }

    public WebElement getEditButton() {
        return driver.findElement(test_Cases_EDIT_By);
    }

    public WebElement getTestCasesNavigationButton() {
        return driver.findElement(test_Cases_Navigation_Button_By);
    }

    public String getMessageSuccessText() {
        return getMessageSuccess().getText();
    }
}
