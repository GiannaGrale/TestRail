package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private WebDriver driver;
    private WebElement parentElement;
    private List<UIElement> navElements = new ArrayList<>();

    /***
     *
     * @param driver
     * @param by search of all elements in the dropdown
     * @param parentBy show the list of the dropdown
     */

    public DropDown(WebDriver driver, By by, By parentBy) {
        this.driver = driver;
        this.parentElement = new UIElement(driver, parentBy);

        for (WebElement webElement : driver.findElements(by)) {
            navElements.add(new UIElement(driver, webElement));
        }
    }

    public void chooseDropDown() {
        this.parentElement.click();
    }

    public void selectByText(String optionName) {
        for (WebElement uiElement : navElements) {
            String textValue = uiElement.getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                uiElement.click();
                break;
            }
        }
    }
}