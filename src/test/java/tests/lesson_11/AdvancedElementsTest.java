package tests.lesson_11;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class AdvancedElementsTest extends BaseTest {

    @Test
    public void hoverTest() {

        driver.get("http://the-internet.herokuapp.com/hovers");
        List<WebElement> list = driver.findElements(By.className("figure"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(list.get(0))
                .pause(1000)
                .moveToElement(list.get(2))
                .pause(1000)
                .moveToElement(list.get(0))
                .build().perform();

        waits.waitForVisibility(By.xpath("//h5[text()= 'name: user1']"));
    }

    @Test
    public void contextTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(hotSpot)
                .contextClick()
                .build().perform();
    }

    @Test
    public void uploadFileTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        uploadFile.sendKeys("C:\\Users\\Lenovo\\Pictures\\nextjs.png");
        driver.findElement(By.id("file-submit")).submit();
        waits.waitForVisibility(By.xpath("//h3[text()='File Uploaded!']"));
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);

        actions
                .dragAndDrop(a, b)
                .build()
                .perform();
        Thread.sleep(2000);
    }
}
