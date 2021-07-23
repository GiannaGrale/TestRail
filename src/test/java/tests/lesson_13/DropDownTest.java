package tests.lesson_13;

import baseEntities.BaseTest;
import elements.DropDown;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;


public class DropDownTest extends BaseTest {

    @Test
    public void dropDownTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.isPageOpened();
        DropDown dropDown = new DropDown(driver, By.cssSelector(".dropdown-menu-link"), By.id("navigation-menu"));
        dropDown.chooseDropDown();
        dropDown.selectByText("About TestRail");
        waits.waitForVisibility(By.className("dialog-logo"));
    }
}
