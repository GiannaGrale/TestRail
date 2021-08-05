package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonePage extends BasePage {

    private final static String endpoint = "index.php?/milestones/add/";

    private final static By milestone_Name_By = By.id("name");
    private final static By milestone_Description_By = By.id("description_display");
    private final static By add_Milestone_By = By.id("accept");
    private final static By milestone_Header_By = By.className("content-header-title");


    public MilestonePage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getMilestoneHeader().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getMilestoneHeader() {
        return driver.findElement(milestone_Header_By);
    }

    public WebElement getMilestoneName() {
        return driver.findElement(milestone_Name_By);
    }

    public WebElement getMilestoneDescription() {
        return driver.findElement(milestone_Description_By);
    }

    public WebElement getMilestoneAdd() { return driver.findElement(add_Milestone_By); }

    public void addMilestone() { getMilestoneAdd().click(); }

    public void putMilestoneName(String name) { getMilestoneName().sendKeys(name); }

    public void putMilestoneDescription( String description) { getMilestoneDescription().sendKeys(description); }

}
