import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest1 extends BaseTest{

    private Calculator calculator = new Calculator("CalcTest");

    @Test (invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void testSum1 () throws InterruptedException {
        Assert.assertEquals(5, calculator.sum(2,3));
        Thread.sleep(1001);
    }

}
