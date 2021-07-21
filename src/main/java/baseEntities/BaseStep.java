package baseEntities;

import org.openqa.selenium.WebDriver;
import utils.Waits;

public class BaseStep {
    protected WebDriver driver;
    protected Waits wait;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.wait= new Waits(driver, 20);
    }
}