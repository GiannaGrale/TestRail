package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.AdminOverviewPage;
import pages.DashboardPage;
import pages.ProjectPage;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }

    public void addProject() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys("Lesson_10_Anna_addedProject");
        projectPage.getAnnouncementInput().sendKeys("Just put some text here");
        projectPage.getAddProjectButton().click();
    }

    public void deleteProject(String projectName) {
        AdminOverviewPage adminOverviewPage = new AdminOverviewPage(driver, false);
        adminOverviewPage.getDeleteProjectButton(projectName).click();
        adminOverviewPage.getDeleteConfirmationWindow().click();
        adminOverviewPage.getDeleteConfirmationButton().click();
    }

    public void updateProject(String projectName) {
        AdminOverviewPage adminOverviewPage = new AdminOverviewPage(driver, false);
        adminOverviewPage.getEditButton(projectName).click();
        ProjectPage projectPage = new ProjectPage(driver, false);
        projectPage.getProjectNameInput().sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        projectPage.getProjectNameInput().sendKeys("Lesson_10_Anna_UPD_Project");
        projectPage.getAddProjectButton().click();
    }
}
