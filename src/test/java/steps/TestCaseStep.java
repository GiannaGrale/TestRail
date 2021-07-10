package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.*;

public class TestCaseStep extends BaseStep {
    public TestCaseStep(WebDriver driver) {
        super(driver);
    }

    public void createTestCase(String projectName, String preconditions, String steps, String expectedResult) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getChosenProject().click();
        ProjectOverViewPage projectOverViewPage = new ProjectOverViewPage(driver, false);
        projectOverViewPage.getTestCaseADDButton().click();
        CasePage casePage = new CasePage(driver, false);
        casePage.getTestCaseTitle().sendKeys(projectName);
        casePage.getTestCasePreconditions().sendKeys(preconditions);
        casePage.getTestCaseSteps().sendKeys(steps);
        casePage.getTestCaseExpectedResult().sendKeys(expectedResult);
        casePage.getTestCaseADD().click();
    }

    public void editTestCase(String newProjectName, String newPreconditions, String newSteps, String newExpectedResult)  {
        CaseViewPage caseViewPage = new CaseViewPage(driver, false);
        caseViewPage.getEditButton().click();
        CasePage casePage = new CasePage(driver, false);
        casePage.getTestCaseTitle().sendKeys(Keys.CONTROL, "a");
        casePage.getTestCaseTitle().sendKeys(newProjectName);
        casePage.getTestCasePreconditions().sendKeys(Keys.CONTROL, "a");
        casePage.getTestCasePreconditions().sendKeys(newPreconditions);
        casePage.getTestCaseSteps().sendKeys(Keys.CONTROL, "a");
        casePage.getTestCaseSteps().sendKeys(newSteps);
        casePage.getTestCaseExpectedResult().sendKeys(Keys.CONTROL, "a");
        casePage.getTestCaseExpectedResult().sendKeys(newExpectedResult);
        casePage.getTestCaseADD().click();
    }

    public void deleteTestCase() throws InterruptedException {
        CaseViewPage caseViewPage = new CaseViewPage(driver, false);
        caseViewPage.getTestCasesNavigationButton().click();
        SuitesViewPage suitesViewPage = new SuitesViewPage(driver, false);
        suitesViewPage.getSelectedTestCasesButton().click();
        suitesViewPage.getDeleteTestCasesButton().click();
        suitesViewPage.getDeleteFirstConfirmationButton().click();
        Thread.sleep(1000);
        suitesViewPage.getDeleteSecondConfirmationButton().click();
        Thread.sleep(1000);
    }
}
