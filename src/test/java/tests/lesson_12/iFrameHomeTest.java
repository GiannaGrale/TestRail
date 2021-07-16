package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrameHomeTest extends BaseTest {

    @Test
    public void iframeWebElementTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement textInput = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(textInput.isDisplayed());
        textInput.sendKeys(Keys.CONTROL + "a");
        textInput.sendKeys("Here is some text for iframe input.");
        driver.switchTo().parentFrame();
        WebElement leftAlignment = driver.findElement(By.xpath("//div[@title='alignment']/button[@title ='Align left']"));
        leftAlignment.click();
        WebElement alignment = driver.findElement(By.cssSelector("[title = 'alignment']"));
        Assert.assertTrue(alignment.isDisplayed());
    }

    @Test
    public void iframeNumberTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement textInput = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(textInput.isDisplayed());
        textInput.sendKeys(Keys.CONTROL + "a");
        textInput.sendKeys("Here is some text for iframe input.");
        driver.switchTo().parentFrame();
        WebElement leftAlignment = driver.findElement(By.xpath("//div[@title='alignment']/button[@title ='Align left']"));
        leftAlignment.click();
        WebElement alignment = driver.findElement(By.cssSelector("[title = 'alignment']"));
        Assert.assertTrue(alignment.isDisplayed());
    }

    @Test
    public void iframeStringTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInput = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(textInput.isDisplayed());
        textInput.sendKeys(Keys.CONTROL + "a");
        textInput.sendKeys("Here is some text for iframe input.");
        driver.switchTo().parentFrame();
        WebElement leftAlignment = driver.findElement(By.xpath("//div[@title='alignment']/button[@title ='Align left']"));
        leftAlignment.click();
        WebElement alignment = driver.findElement(By.cssSelector("[title = 'alignment']"));
        Assert.assertTrue(alignment.isDisplayed());

    }
}
