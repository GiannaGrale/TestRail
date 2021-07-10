package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;

    public BrowserService() {
        switch (properties.getBrowser().toLowerCase()) {
            case "chrome" :
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(properties.getHeadless());
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox" :
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(properties.getHeadless());
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge" :
                WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new AssertionError("This browser is not supported");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}