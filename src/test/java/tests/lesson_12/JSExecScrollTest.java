package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JSExecScrollTest extends BaseTest {

    @Test
    public void onlinerScrollTest() {
        driver.get("https://www.onliner.by/");
        WebElement footerSocial = driver.findElement(By.className("footer-style__social"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", footerSocial);
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOf(footerSocial));
    }
}
