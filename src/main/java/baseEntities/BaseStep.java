package baseEntities;

import utils.Waits;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected Waits wait;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.wait= new Waits(driver, 20);
    }
}