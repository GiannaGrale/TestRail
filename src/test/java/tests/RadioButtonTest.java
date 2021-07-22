package tests;

import baseEntities.BaseTest;
import com.sun.net.httpserver.Authenticator;
import elements.RadioButton;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import utils.Retry;

public class RadioButtonTest extends BaseTest {


    @Feature("Feature_1")
    @Link(value = "#_testng", url = "https://docs.qameta.io/allure/")
    @TmsLink("20")
    @Issue("21")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Test(retryAnalyzer = Retry.class)
    public void radioButtonTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        // radioButton.selectByIndex(2);
        radioButton.selectByText("Use multiple test suites to manage cases");
        Thread.sleep(2000);
    }

    @Features(value = {@Feature("Feature_1"), @Feature("Feature_2")})
    @Stories(value = {@Story("Story_1"), @Story("Story_2")})
    @Link(name = "allure", type = "mylink", url = "#_testng")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void radioButtonTest2() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        // radioButton.selectByIndex(2);
        radioButton.selectByText("Use multiple test suites to manage cases");
        Thread.sleep(2000);
    }
}
