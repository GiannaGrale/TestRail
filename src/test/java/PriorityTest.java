import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {

    @Test(priority = 1 )
    public void stepb1() {
        System.out.println("Step 1...");
    }

    @Test(priority = 2)
    public void steps2() {
        System.out.println("Step 2...");

    }

    @Test(priority = 3)
    public void stepa3() {
        System.out.println("Step 3...");

    }

    @Test(priority = 4)
    public void stepc4() {
        System.out.println("Step 4...");

    }
}