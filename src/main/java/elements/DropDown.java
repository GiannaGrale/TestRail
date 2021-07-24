package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDown {

    private WebDriver driver;
    private WebElement parentElement;
    private List<WebElement> navElements;

    /***
     *
     * @param driver
     * @param by search of all elements in the dropdown
     * @param parentBy show the list of the dropdown
     */

    public DropDown(WebDriver driver, By by, By parentBy) {
        this.driver = driver;
        navElements = driver.findElements(by);
        this.parentElement = new UIElement(driver, parentBy);
    }

    public void chooseDropDown() {
        this.parentElement.click();
    }

    public void selectByText(String optionName) {
        for (WebElement element : navElements) {
            String textValue = element.getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }
}

