package tests.lesson_13;

import baseEntities.BaseTest;
import elements.Table;
import elements.TableRow;
import elements.UIElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;

public class TableTest extends BaseTest {

    @Test
    public void tableTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        //System.out.println(table.rowsCount());
        //System.out.println(table.getElementFromCell(6, 0).getText());
        UIElement editButton = table.getElementFromCell("Hello_Project", 0, 1);
        //UIElement editButton = table.getElementFromCell("Hello_Project", 0, "Edit");
        editButton.click();

    }
}
