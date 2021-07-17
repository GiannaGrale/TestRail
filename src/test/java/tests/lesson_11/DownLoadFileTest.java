package tests.lesson_11;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;


public class DownLoadFileTest {
    @Test
    public void downloadFile() throws InterruptedException {

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/download");

        WebElement fileDown = driver.findElement(By.xpath("//*[@id='content']/div/a[1]"));
        fileDown.click();
        Thread.sleep(4000);
        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File text = null;

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String file = fileDown.getText();
                System.out.println("File " + listOfFile.getName());
                if (file.matches(file)) {
                    text = new File(file);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        text.deleteOnExit();
        driver.quit();
    }
}