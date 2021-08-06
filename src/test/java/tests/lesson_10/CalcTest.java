package tests.lesson_10;

import calculator.Calculator;
import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.lesson_10.BaseTest;

public class CalcTest extends BaseTest {

    private Calculator calculator = new Calculator("tests.lesson_10.CalcTest");

    @Test(description = "Critical path")
    public void testSum (){
        Assert.assertEquals(5, calculator.sum(2,3));
    }

    @Test
    public void testSum1 (){
        Assert.assertEquals(5, calculator.sum(2,3));
    }

    @Test(dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void dataProviderTest(int a, int b, int expectedResult) throws InterruptedException {
        Assert.assertEquals(expectedResult, calculator.sum(a,b));
        Thread.sleep(2000);

    }

    @Test
    public void testSum4 (){
        Assert.assertEquals(6, calculator.sum(2,3));
    }

}
