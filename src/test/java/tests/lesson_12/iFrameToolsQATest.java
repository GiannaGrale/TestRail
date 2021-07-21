package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrameToolsQATest extends BaseTest {

    @Test
    public void iframeToolsQATest() {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        WebElement textInput = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(textInput.isDisplayed());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        WebElement textInput2 = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(textInput2.isDisplayed());
        driver.switchTo().parentFrame();
        WebElement main = driver.findElement(By.className("main-header"));
        Assert.assertTrue(main.isDisplayed());
    }

    @Test
    public void nestedFramesToolsQATest() {
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame(driver.findElement(By.id("frame1")));
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
        driver.switchTo().defaultContent();
        WebElement main = driver.findElement(By.className("main-header"));
        Assert.assertTrue(main.isDisplayed());
    }
}
