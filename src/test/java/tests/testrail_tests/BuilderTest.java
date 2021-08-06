package tests.testrail_tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MilestonesOverViewPage;
import steps.LoginStep;
import steps.MileStoneStep;
import steps.ProjectStep;

import tests.builder.MilestoneBuilder;


public class BuilderTest extends BaseTest {

    MilestoneBuilder milestone = MilestoneBuilder.newBuilder()
            .withUsername("atrostyanko+0601@gmail.com")
            .withPassword("hYE/RiquvQVIzXfiBwm3")
            .withMileStoneName("This is a milestone")
            .withMileStoneDescription("This is a description of the milestone")
            .build();

    @Test
    public void positiveDeleteProjectTest()  {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(milestone.getUsername(), milestone.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        MileStoneStep mileStoneStep = new MileStoneStep(driver);
        mileStoneStep.createMilestone(milestone.getMilestoneName(), milestone.getMilestoneDescription());
        Assert.assertEquals(new MilestonesOverViewPage(driver, false).getSuccessMessage().getText(), "Successfully added the new milestone.");
    }
}
