package elements;


import org.openqa.selenium.*;


public class Checkbox {

    private final UIElement element;

    public Checkbox(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
    }

    public boolean isSelected() {
        return this.element.isSelected();
    }

    public void changeState(boolean makeSelected) {
        if (this.isSelected() != makeSelected) this.element.click();
    }
}
