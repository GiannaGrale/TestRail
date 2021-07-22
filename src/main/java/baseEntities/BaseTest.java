package baseEntities;


import core.BrowserService;
import core.ReadProperties;
import utils.Listener;
import utils.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
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