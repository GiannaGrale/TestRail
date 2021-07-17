package tests.lesson_11;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class AdvancedElementsHomeTaskTest extends BaseTest {

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
    public void dynamicsControlTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        WebElement checkBox = driver.findElement(By.id("checkbox"));
        WebElement enableButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(button)
                .click()
                .build().perform();

        waits.waitForVisibility(By.id("message"));
        waits.waitForInvisibility(checkBox);
        waits.waitForVisibility(By.id("input-example"));
        waits.waitForPresence(By.cssSelector("input[disabled]"));

        actions
                .moveToElement(enableButton)
                .click()
                .build().perform();

        waits.waitForVisibility(By.id("message"));

        int numberOfElement = driver.findElements(By.cssSelector("input[disabled]")).size();
        Assert.assertEquals(numberOfElement, 0, "Oops, input is disabled!");
    }

    @Test
    public void uploadFileTest()   {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        File file = new File(System.getProperty("user.dir") + "/Man-Silhouette.jpg");
        String picturePath = file.getAbsolutePath();
        uploadFile.sendKeys(picturePath);
        driver.findElement(By.id("file-submit")).submit();
        String nameOfPicture = driver.findElement(By.id("uploaded-files")).getText();
        waits.waitForVisibility(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertEquals(nameOfPicture, "Man-Silhouette.jpg");

    }
}