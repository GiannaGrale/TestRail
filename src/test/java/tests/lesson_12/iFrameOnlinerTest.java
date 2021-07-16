package tests.lesson_12;

import baseEntities.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class iFrameOnlinerTest extends BaseTest {

    @Test
    public void iFrameSearchMatchTest() {

        driver.get("https://www.onliner.by/");
        WebElement searchInput = driver.findElement(By.className("fast-search__input"));
        searchInput.sendKeys("Xiaomi", Keys.ENTER);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        WebElement firstXiaomi = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[1]//../div[@class='product__details']/div/a")));
        String phoneName = firstXiaomi.getText();
        WebElement inputIframe = driver.findElement(By.className("search__input"));
        inputIframe.sendKeys(Keys.CONTROL + "a");
        inputIframe.sendKeys(phoneName);
        WebElement closeCross = driver.findElement(By.className("search__close"));
        closeCross.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text_match")));

    }

    @Test
    public void iFrameProductPageTest2() {
        driver.get("https://www.onliner.by/");
        WebElement searchInput = driver.findElement(By.className("fast-search__input"));
        searchInput.sendKeys("Xiaomi", Keys.ENTER);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        WebElement firstXiaomi = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[1]//../div[@class='product__details']/div/a")));
        String phoneName = firstXiaomi.getText();
        WebElement inputIframe = driver.findElement(By.className("search__input"));
        inputIframe.sendKeys(Keys.CONTROL + "a");
        WebElement chosenPic = driver.findElement(By.xpath("//ul/li[1]/div/div/child::a"));
        inputIframe.sendKeys(phoneName);
        chosenPic.click();
        driver.switchTo().parentFrame();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("catalog-masthead__title")));
    }
}
