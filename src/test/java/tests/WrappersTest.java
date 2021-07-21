package tests;

import baseEntities.BaseTest;
import elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrappersTest extends BaseTest {

    @Test
    public void buttonTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Button simpleAlertButton = new Button(driver, By.xpath(("//button[.='Click for JS Prompt']")));
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
