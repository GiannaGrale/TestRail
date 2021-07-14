package baseEntities;


import core.BrowserService;
import core.ReadProperties;
import core.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ReadProperties properties;
    protected Waits waits;

    @BeforeTest
    public void setupTest(){
        properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod(){
        driver = new BrowserService().getDriver();
        waits = new Waits(driver, properties.getTimeout());
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }
}