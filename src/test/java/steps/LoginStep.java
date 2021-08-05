package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.usernameInput.sendKeys(username);
        loginPage.setPassword(password);
        WebElement button = loginPage.getLoginButton();
        loginPage.clickLoginButton();
        wait.waitForInvisibility(button);
    }
}


