package tests.testrail_tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminOverviewPage;
import steps.LoginStep;
import steps.ProjectStep;
import tests.valueObjects.Project;


public class ValueObjectProjectTest extends BaseTest {

    Project project = setUpProject();

    @Test
    public void positiveDeleteProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(project.getUsername(), project.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        projectStep.deleteProject(project.getProjectName());
        Assert.assertEquals(new AdminOverviewPage(driver, false).getSuccessConfirmationMessage().getText(), "Successfully deleted the project.");
    }

    private Project setUpProject() {
        Project project = new Project();
        project.setUsername("atrostyanko+0601@gmail.com");
        project.setPassword("hYE/RiquvQVIzXfiBwm3");
        project.setProjectName("Lesson_10_Anna_addedProject");
        return project;
    }
}
