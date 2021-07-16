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
import java.util.List;

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

        List<WebElement> list = driver.findElements(By.linkText("text.txt"));
        WebElement element = list.get(list.size() - 1);
        element.click();
        Thread.sleep(4000);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();

        boolean found = false;
        File text = null;

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("text.txt")) {
                    text = new File(fileName);
                    found = true;
                }

            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        text.deleteOnExit();
        driver.close();
    }
}