package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private final static String endpoint = "index.php?/dashboard";
    private final static By navigation_Dashboard_By = By.id("navigation-dashboard");
    private final static By add_Project_Button_By = By.id("sidebar-projects-add");
    private final static String choose_project_By = "//*[contains(text(), 'replace')] ";


    public DashboardPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getDashboardButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getDashboardButton() {
        return driver.findElement(navigation_Dashboard_By);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(add_Project_Button_By);
    }

    public WebElement getChosenProject(String projectName) { return driver.findElement(By.xpath(choose_project_By.replace("replace", projectName))); }

    public String getDashboardButtonText() {
        return getDashboardButton().getText();
    }
}