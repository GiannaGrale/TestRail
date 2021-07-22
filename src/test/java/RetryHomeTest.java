import annotations.Before_After_Annotations;
import core.BrowserService;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;


public class RetryHomeTest extends Before_After_Annotations {
    private int attempt = 1;
    protected WebDriver driver = new BrowserService().getDriver();

    @Test(retryAnalyzer = Retry.class)
    public void flakyTest()   {
        driver.get("https://aqa06onl01.testrail.io/");
        if (attempt == 4) {
            Assert.assertTrue(true);
            driver.quit();
        } else {
            attempt++;
            System.out.println(attempt);
            throw new NullPointerException();
        }
    }
}
