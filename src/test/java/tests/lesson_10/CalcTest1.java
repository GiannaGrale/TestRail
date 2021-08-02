package tests.lesson_10;

import calculator.Calculator;
import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.lesson_10.BaseTest;

public class CalcTest1 extends BaseTest {

    private Calculator calculator = new Calculator("tests.lesson_10.CalcTest");

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSum1 () throws InterruptedException {
        Assert.assertEquals(5, calculator.sum(2,3));
        Thread.sleep(1001);
    }
}
