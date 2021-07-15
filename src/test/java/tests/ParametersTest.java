package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CaseViewPage;
import steps.LoginStep;
import steps.ProjectStep;
import steps.TestCaseStep;

public class ParametersTest extends BaseTest {
    @Test
    @Parameters({"paramName", "paramPreconditions", "paramSteps", "paramExpectedResult"})
    public void positiveTestCaseCreationTestParam(@Optional("Default_Name") String paramName,
                                                  @Optional("Default_Params") String paramPreconditions,
                                                  @Optional("Default_Steps") String paramSteps,
                                                  @Optional("Default_ExpResult") String paramExpectedResult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        TestCaseStep testCaseStep = new TestCaseStep(driver);
        testCaseStep.createTestCase(paramName, paramPreconditions, paramSteps, paramExpectedResult);
        Assert.assertEquals(new CaseViewPage(driver, false).getMessageSuccessText(), "Successfully added the new test case. Add another");
    }
}