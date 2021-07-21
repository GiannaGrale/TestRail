package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasePage extends BasePage {
    private final static String endpoint = "index.php?/cases";
    private final static By test_Cases_Title_By = By.id("title");
    private final static By test_Cases_Preconditions_By = By.id("custom_preconds_display");
    private final static By test_Cases_Steps_By = By.id("custom_steps_display");
    private final static By test_Cases_ExpResult_By = By.id("custom_expected_display");
    private final static By test_Cases_ADD_By = By.xpath("//div/button[@id='accept']");

    public CasePage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTestCaseTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTestCaseTitle() {
        return driver.findElement(test_Cases_Title_By);
    }

    public WebElement getTestCasePreconditions() {
        return driver.findElement(test_Cases_Preconditions_By);
    }

    public WebElement getTestCaseSteps() {
        return driver.findElement(test_Cases_Steps_By);
    }

    public WebElement getTestCaseExpectedResult() {
        return driver.findElement(test_Cases_ExpResult_By);
    }

    public WebElement getTestCaseADD() {
        return driver.findElement(test_Cases_ADD_By);
    }
}
