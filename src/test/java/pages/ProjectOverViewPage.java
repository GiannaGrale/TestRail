package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectOverViewPage extends BasePage {
    private final static String endpoint = "index.php?/projects/overview";
    private final static By test_Cases_Add_By = By.id("sidebar-cases-add");

    public ProjectOverViewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTestCaseADDButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTestCaseADDButton() {
        return driver.findElement(test_Cases_Add_By);
    }
}
