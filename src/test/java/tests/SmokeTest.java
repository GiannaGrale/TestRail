package tests;

import baseEntities.BaseTest;
import dataProvider.TestCaseStatProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.LoginStep;
import steps.ProjectStep;
import steps.TestCaseStep;

public class SmokeTest extends BaseTest {

    @Test(priority = 1, invocationCount = 2)
    public void positiveLoginTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        Assert.assertEquals(new DashboardPage(driver, false).getDashboardButtonText(), "DASHBOARD");
    }

    @Test(priority = 4, dependsOnMethods = "negativeLoginTest2")
    public void negativeLoginTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsernameWrong(), properties.getPasswordWrong());
        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(priority = 3, invocationTimeOut = 10000, threadPoolSize = 2)
    public void negativeLoginTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPasswordEmpty());
        Assert.assertEquals(new LoginPage(driver, false).getErrorPassword().getText(), "Password is required.");
    }

    @Test(priority = 2)
    public void negativeLoginTest3() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsernameEmpty(), properties.getPassword());
        Assert.assertEquals(new LoginPage(driver, false).getErrorLogin().getText(), "Email/Login is required.");
    }

    @Test(invocationCount = 2)
    public void positiveAddProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        Assert.assertEquals(new AdminOverviewPage(driver, false).getSuccessConfirmationMessage().getText(), "Successfully added the new project.");
    }

    @Test(invocationCount = 2)
    public void positiveDeleteProjectTest() {
        String projectName = "Lesson_10_Anna_addedProject";
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        projectStep.deleteProject(projectName);
        Assert.assertEquals(new AdminOverviewPage(driver, false).getSuccessConfirmationMessage().getText(), "Successfully deleted the project.");
    }

    @Test(invocationCount = 2)
    public void positiveUpdateProjectTest() {
        String projectName = "Lesson_10_Anna_addedProject";
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        projectStep.updateProject(projectName);
        Assert.assertEquals(new AdminOverviewPage(driver, false).getSuccessConfirmationMessage().getText(), "Successfully updated the project.");
    }

    @Test(dataProvider = "TestCases", dataProviderClass = TestCaseStatProvider.class)
    public void positiveTestCaseCreationTest(String testCaseName, String preconditions, String steps, String expectedResult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        TestCaseStep testCaseStep = new TestCaseStep(driver);
        testCaseStep.createTestCase(testCaseName, preconditions, steps, expectedResult);
        Assert.assertEquals(new CaseViewPage(driver, false).getMessageSuccessText(), "Successfully added the new test case. Add another");
    }

    @Test(dataProvider = "EditTestCases", dataProviderClass = TestCaseStatProvider.class)
    public void positiveTestCaseEditTest(String testCaseName, String newTestCaseName, String preconditions,
                                         String newPreconditions, String steps, String newSteps,
                                         String expectedResult, String newExpectedResult)  {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        TestCaseStep testCaseStep = new TestCaseStep(driver);
        testCaseStep.createTestCase(testCaseName, preconditions, steps, expectedResult);
        testCaseStep.editTestCase(newTestCaseName, newPreconditions, newSteps, newExpectedResult);
        Assert.assertEquals(new CaseViewPage(driver, false).getMessageSuccessText(), "Successfully updated the test case.");
    }

    @Test(dataProvider = "TestCases", dataProviderClass = TestCaseStatProvider.class)
    public void positiveTestCaseDeleteTest(String testCaseName, String preconditions, String steps, String expectedResult) throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        TestCaseStep testCaseStep = new TestCaseStep(driver);
        testCaseStep.createTestCase(testCaseName, preconditions, steps, expectedResult);
        testCaseStep.deleteTestCase();
        Assert.assertEquals(new SuitesViewPage(driver, false).getNumberOfTestCases().getText(), "0");
    }
}