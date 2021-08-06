package tests.lesson_12;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrameTest extends BaseTest {


    @Test
    public void iFrameNumberTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame(); //переключение на один уровень выше
        driver.switchTo().defaultContent(); //переключение на основной сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role='menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @Test
    public void iFrameStringTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame(); //переключение на один уровень выше
        driver.switchTo().defaultContent(); //переключение на основной сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role='menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @Test
    public void iFrameWebElementTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame(); //переключение на один уровень выше
        driver.switchTo().defaultContent(); //переключение на основной сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role='menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }
}
