package tests.lesson_13;

import baseEntities.BaseTest;
import elements.Checkbox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectPage;
import steps.LoginStep;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkBoxTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys("Lesson_13_Anna_Checkbox");
        projectPage.getAnnouncementInput().sendKeys("Just some text here");
        Checkbox checkbox = new Checkbox(driver, By.id("show_announcement"));
        checkbox.click();
        projectPage.getAddProjectButton().click();
    }

    public void checkBoxTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys("Lesson_13_Anna_Checkbox");
        projectPage.getAnnouncementInput().sendKeys("Just some text here");
        Checkbox checkbox = new Checkbox(driver, By.id("show_announcement"));
        checkbox.changeState(true);
        projectPage.getAddProjectButton().click();
    }
}
