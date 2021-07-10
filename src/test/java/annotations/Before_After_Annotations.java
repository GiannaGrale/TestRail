package annotations;


import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class Before_After_Annotations {
    protected WebDriver driver;
    protected ReadProperties properties;

    @BeforeTest
    public void setupTest() {
        properties = new ReadProperties();
        System.out.println("Beginning of the Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("End of the Test");
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new BrowserService().getDriver();
        System.out.println("Beginning of the Method");
    }

    @AfterMethod
    public void teardownMethod() {
        driver.quit();
        System.out.println("End of the Method");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Beginning of the Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("End of the Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Beginning of the Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("End of the Class");
    }


}


