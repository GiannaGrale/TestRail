package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DropDown {

    private UIElement uiElement;
    private WebDriver driver;
    private WebElement parentElement;


    public DropDown(WebDriver driver, By by, By parentBy) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.parentElement = new UIElement(driver, parentBy);
    }

    public void chooseDropDown() {
        this.parentElement.click();
    }

    public void selectByText(String optionName) {
        List<WebElement> navElements = this.uiElement.findElements(By.cssSelector(".dropdown-menu-link"));
        for (WebElement element : navElements) {
            String textValue = element.getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }
}



