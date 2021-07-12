package tests;


import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class GroupHomeTest {
    WebDriver driver = new BrowserService().getDriver();

    @BeforeTest(groups = "user1")
    public void beforeTest() {
        driver.get("https://aqa06onl01.testrail.io/");
    }

    @AfterTest(groups = "user1")
    public void teardownMethod() {
        driver.quit();
    }

    @Test(groups = "user1")
    public void loginToWebsite_1() {
        driver.findElement(By.id("name")).sendKeys("wwfwfwef");
        driver.findElement(By.id("password")).sendKeys("22dde");
        driver.findElement(By.id("button_primary")).click();
        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage().getText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(groups = "user1")
    public void loginToWebsite_2() {
        driver.findElement(By.id("name")).sendKeys("login@gmail.com");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("button_primary")).click();
        Assert.assertEquals(new LoginPage(driver, false).getErrorPassword().getText(), "Password is required.");
    }

    @Test(groups = "user2")
    public void loginToWebsite_3() {
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("button_primary")).click();
        Assert.assertEquals(new LoginPage(driver, false).getErrorLogin().getText(), "Email/Login is required.");
    }
}
