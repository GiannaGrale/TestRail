package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsHomeTest extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        alertButton.click();
        Alert infoAlert = driver.switchTo().alert();
        infoAlert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(result.getText(), "You successfully clicked an alert");
    }

    @Test
    public void choiceAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        alertButton.click();
        Alert choiceAlert = driver.switchTo().alert();
        choiceAlert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(result.getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        alertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hey, there is a prompt message");
        promptAlert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(result.getText(), "You entered: Hey, there is a prompt message");
    }
}
