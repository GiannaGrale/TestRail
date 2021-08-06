package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {
    private final static String endpoint = "index.php?/auth/login/";
    @FindBy (id = "name")
    public WebElement usernameInput;

    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("button_primary");
    private final static By error_Message_By = By.className("error-text");
    private final static By error_Password_By = By.cssSelector(".display-flex .loginpage-message");
    private final static By error_Login_By = By.cssSelector(".loginpage-message-image.loginpage-message ");

    public LoginPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLoginButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getPasswordInput() {
        return driver.findElement(password_Input_By);
    }

    public WebElement getLoginButton() {
        return waits.waitForVisibility(login_Button_By);
    }

    public WebElement getErrorMessage() {
        return driver.findElement(error_Message_By);
    }

    public WebElement getErrorPassword() {
        return driver.findElement(error_Password_By);
    }

    public WebElement getErrorLogin() {
        return driver.findElement(error_Login_By);
    }


    public void setPassword(String text) {
        getPasswordInput().sendKeys(text);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

}