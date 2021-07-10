package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminOverviewPage extends BasePage {
    private final static String endpoint = "index.php?/admin/projects/overview/";
    private final static By success_Confirmation_Message_By = By.cssSelector(".content-inner .message-success");
    private final static By edit_Project_Button_By = By.xpath("//tr/td/a[contains(text(),'Lesson_10_Anna_addedProject')]/following::div[2]");
    private final static By delete_Project_Button_By = By.xpath ("//tr/td/a[contains(text(),'Lesson_10_Anna_addedProject')]/following::div[3]");
    private final static By delete_Confirmation_Window_By = By.xpath("//div[@class='icon-progress-inline']/following::input");
    private final static By delete_Confirmation_Button_By = By.xpath("//div[@class='icon-progress-inline']/following::a[1]");

    public AdminOverviewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getSuccessConfirmationMessage().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getSuccessConfirmationMessage() {
        return driver.findElement(success_Confirmation_Message_By);
    }

    public WebElement getEditButton() {
        return driver.findElement(edit_Project_Button_By);
    }

    public WebElement getDeleteProjectButton() {
        return driver.findElement(delete_Project_Button_By);
    }

    public WebElement getDeleteConfirmationWindow() {
        return driver.findElement(delete_Confirmation_Window_By);
    }

    public WebElement getDeleteConfirmationButton() {
        return driver.findElement(delete_Confirmation_Button_By);
    }
}
