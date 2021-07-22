package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Log into system with correct credentials '{username}', '{password}'")
    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
    }
}


