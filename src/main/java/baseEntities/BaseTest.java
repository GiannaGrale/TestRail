package baseEntities;


import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected ReadProperties properties;

    @BeforeTest
    public void setupTest(){
        properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod(){
        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void teardownMethod(){
        driver.quit();
    }

}