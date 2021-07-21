package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private final static String endpoint = "index.php?/admin/projects/add";
    private final static By input_Project_Name_By = By.xpath("//div[@class='form-group']/input[@id='name']");
    private final static By announcement_Message_By = By.id("show_announcement");
    private final static By input_Announcement_By = By.xpath("//textarea[@id='announcement']");
    private final static By add_Project_Button_By = By.cssSelector(".form-buttons .button-ok");

    public ProjectPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAnnouncement_Message_Element().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProjectNameInput() {
        return driver.findElement(input_Project_Name_By);
    }

    public WebElement getAnnouncementInput() {
        return driver.findElement(input_Announcement_By);
    }

    public WebElement getAnnouncement_Message_Element() {
        return driver.findElement(announcement_Message_By);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(add_Project_Button_By);
    }
}
