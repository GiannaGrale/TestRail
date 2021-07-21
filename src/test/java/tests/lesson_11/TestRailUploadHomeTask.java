package tests.lesson_11;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CasePage;
import pages.DashboardPage;
import pages.ProjectOverViewPage;
import steps.LoginStep;
import steps.ProjectStep;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class TestRailUploadHomeTask extends BaseTest {

    @Test
    public void uploadTestCaseCreationTest() throws InterruptedException, AWTException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUsername(), properties.getPassword());
        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProject();
        String projectName = "Lesson_10_Anna_addedProject";
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getChosenProject(projectName).click();
        ProjectOverViewPage projectOverViewPage = new ProjectOverViewPage(driver, false);
        projectOverViewPage.getTestCaseADDButton().click();
        CasePage casePage = new CasePage(driver, false);
        casePage.getTestCaseTitle().sendKeys("Add a file");

        waits.waitForVisibility(By.id("entityAttachmentListEmptyIcon")).click();

        waits.waitForVisibility(By.id("libraryAttachmentsAddItem")).click();

        Thread.sleep(3000);
        StringSelection stringSelection = new StringSelection(getFile());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //когда добавлен файл, появлется кнопка delete
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("libraryDeleteAttachment")));

        WebElement attachElement = driver.findElement(By.id("attachmentNewSubmit"));
        attachElement.click();
        casePage.getTestCaseADD();
    }

    String getFile(){
        return new File("Man-Silhouette.jpg").getAbsolutePath();
    }
}

