package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class TableRow {
    private final WebDriver driver;
    private UIElement uiElement;
    private List<Cell> cellList = new ArrayList<>();

    public TableRow(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        getEachCell();
    }

    public TableRow(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
        getEachCell();
    }

    public int getCellsCount() {
        return cellList.size();
    }

    /***
     *
     * @param columnIndex index starting from 0
     * @return cell by index
     */
    public Cell getCellByIndex(int columnIndex) {
        return cellList.get(columnIndex);
    }

    public void getEachCell() {
        for (WebElement element : this.uiElement.findElements(By.tagName("td"))) {
            cellList.add(new Cell(driver, element));
        }
    }
}
