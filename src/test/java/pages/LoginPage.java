package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final static String endpoint = "index.php?/auth/login/";
    private final static By username_Input_By = By.xpath("//div/input[@id='name']");
    private final static By password_Input_By = By.xpath("//div/input[@id='password']");
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

    public WebElement getUsernameInput() {
        return driver.findElement(username_Input_By);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(password_Input_By);
    }

    public WebElement getLoginButton() {
        return driver.findElement(login_Button_By);
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

    public void setUsername(String text) {
        getUsernameInput().sendKeys(text);
    }

    public void setPassword(String text) {
        getPasswordInput().sendKeys(text);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

}