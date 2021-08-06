package tests.lesson_10;

import baseEntities.BaseTest;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginStep;

public class ExceptionHomeTest extends BaseTest {

    @Test(expectedExceptions = InvalidArgumentException.class)
        public void exceptionTest () {
        driver.get("");
    }

    @Test(enabled = false)
    public  void enableTest(){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        Assert.assertEquals(new DashboardPage(driver, false).getDashboardButtonText(), "DASHBOARD");
    }

    @Test(timeOut = 4000, description = "login to the website")
    public void waitLongTimeTest()   {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsernameEmpty(), properties.getPassword());
        Assert.assertEquals(new LoginPage(driver, false).getErrorLogin().getText(), "Email/Login is required.");
    }
}
