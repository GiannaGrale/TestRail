package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuitesViewPage extends BasePage {
    private final static String endpoint = "index.php?/suites/view/";
    private final static By display_Deleted_TestCases_Button_By = By.id("displayDeletedTestCases");
    private final static By select_TestCases_Button_By = By.cssSelector(".checkbox .selectionCheckbox");
    private final static By delete_TestCases_Button_By = By.id("deleteCases");
    private final static By first_Deletion_Confirmation_Black_Button_By = By.cssSelector(".button-positive.button-black");
    private final static By second_Deletion_Confirmation_Black_Button_By = By.cssSelector(".dialog-action-default.button-black");
    private final static By number_of_Test_Cases_By = By.className("section-count");

    public SuitesViewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    public boolean isPageOpened() {
        try {
            return getDisplayDeletedTestCasesButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getDisplayDeletedTestCasesButton() {
        return driver.findElement(display_Deleted_TestCases_Button_By);
    }

    public WebElement getSelectedTestCasesButton() {
        return driver.findElement(select_TestCases_Button_By);
    }

    public WebElement getDeleteTestCasesButton() {
        return driver.findElement(delete_TestCases_Button_By);
    }

    public WebElement getDeleteFirstConfirmationButton() {
        return driver.findElement(first_Deletion_Confirmation_Black_Button_By);
    }

    public WebElement getDeleteSecondConfirmationButton() {
        return driver.findElement(second_Deletion_Confirmation_Black_Button_By);
    }

    public WebElement getNumberOfTestCases() {
        return driver.findElement(number_of_Test_Cases_By);
    }
}

