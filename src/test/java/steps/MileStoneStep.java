package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.MilestonePage;
import pages.ProjectOverViewPage;

public class MileStoneStep extends BaseStep {
    public MileStoneStep(WebDriver driver) {
        super(driver);
    }

    public void createMilestone(String name, String description ) {
        String projectName = "Lesson_10_Anna_addedProject";
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getChosenProject(projectName).click();
        ProjectOverViewPage projectOverViewPage = new ProjectOverViewPage(driver, false);
        projectOverViewPage.clickMilestoneButton();
        MilestonePage milestonePage = new MilestonePage(driver, false);
        milestonePage.putMilestoneName(name);
        milestonePage.putMilestoneDescription(description);
        milestonePage.addMilestone();
    }
}
