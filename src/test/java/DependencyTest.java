import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test(dependsOnMethods = "stepa3")
    public void stepb1(){
        System.out.println("Step 1...");
    }

    @Test
    public void steps2(){
        System.out.println("Step 2...");
        Assert.assertTrue(false);

    }
    @Test(dependsOnMethods = "steps2", alwaysRun = true)
    public void stepa3(){
        System.out.println("Step 3...");

    }
    @Test(dependsOnMethods = {"steps2", "stepb1"} , alwaysRun = true /*enabled = false*/)
    public void stepc4(){
        System.out.println("Step 4...");

    }

}
