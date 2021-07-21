package tests;

import baseEntities.BaseTest;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add/1");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
     // radioButton.selectByIndex(2);
        radioButton.selectByText("Use multiple test suites to manage cases");
        Thread.sleep(2000);
    }
}
