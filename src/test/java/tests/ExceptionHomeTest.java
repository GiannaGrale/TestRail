package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.InvalidArgumentException;
import org.testng.annotations.Test;

public class ExceptionHomeTest extends BaseTest {

    @Test(expectedExceptions = InvalidArgumentException.class)
        public void exceptionTest () {
        driver.get("");
    }

    @Test(enabled = false)
    public  void enableTest(){
        driver.get("https://aqa06onl01.testrail.io/");
    }

    @Test(timeOut = 4000, description = "open website")
    public void waitLongTimeTest()   {
        driver.get("https://aqa06onl01.testrail.io/");

    }
}
