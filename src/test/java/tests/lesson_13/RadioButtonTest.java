package tests.lesson_13;

import baseEntities.BaseTest;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectPage;
import steps.LoginStep;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonByIndexTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys("Lesson_13_Anna_RadioButton");
        projectPage.getAnnouncementInput().sendKeys("Just some text here");
        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByIndex(3);
        projectPage.getAddProjectButton().click();
        Thread.sleep(2000);
    }

    @Test
    public void radioButtonByTextTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getAddProjectButton().click();
        ProjectPage projectPage = new ProjectPage(driver, true);
        projectPage.getProjectNameInput().sendKeys("Lesson_13_Anna_RadioButton");
        projectPage.getAnnouncementInput().sendKeys("Just some text here");
        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByText("Use a single repository with baseline support");
        radioButton.getNumberOfButtons();
        projectPage.getAddProjectButton().click();
        Thread.sleep(2000);
    }
}
