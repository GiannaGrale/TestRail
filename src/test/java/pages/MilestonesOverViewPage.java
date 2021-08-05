package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesOverViewPage extends BasePage {
    private final static String endpoint = "index.php?/milestones/overview";

    private final static By milestone_AddedSuccess_Message_By = By.className("message-success");


    public MilestonesOverViewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSuccessMessage().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(milestone_AddedSuccess_Message_By);
    }

}
