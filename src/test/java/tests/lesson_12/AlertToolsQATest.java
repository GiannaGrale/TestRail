package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertToolsQATest extends BaseTest {

    @Test
    public void infoAlertTest()  {
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlertButton = driver.findElement(By.id("alertButton"));
        infoAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert infoAlert = wait.until(ExpectedConditions.alertIsPresent());
        infoAlert.accept();
    }

    @Test
    public void timerAlertTest() {
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlertButton = driver.findElement(By.id("timerAlertButton"));
        infoAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert timerAlert = wait.until(ExpectedConditions.alertIsPresent());
        timerAlert.accept();
    }

    @Test
    public void confirmAlertTest() {
        driver.get("https://demoqa.com/alerts");
        WebElement infoAlertButton = driver.findElement(By.id("confirmButton"));
        infoAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        confirmAlert.accept();
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmResult")));
        Assert.assertEquals(result.getText(), "You selected Ok");
    }

    @Test
    public void promptAlertTest() {
        driver.get("https://demoqa.com/alerts");
        WebElement promptAlertButton = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", promptAlertButton);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

        promptAlert.sendKeys("Anna");
        promptAlert.accept();
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptResult")));
        Assert.assertEquals(result.getText(), "You entered Anna");
    }
}
