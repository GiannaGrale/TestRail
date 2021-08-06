package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedElementsTestPart2 extends BaseTest {

    @Test
    public void simpleAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(result.getText(), "You successfully clicked an alert");

    }

    @Test
    public void choiceAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(result.getText(), "You clicked: Cancel");

    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("some text");
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(result.getText(), "You entered: some text");
    }
}
