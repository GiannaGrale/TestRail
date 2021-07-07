import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Test
    @Parameters({"logValue", "pswValue"})
    public void testParam(@Optional("Default_login") String login, @Optional("22222") String password){
        System.out.println("login is :" + login);
        System.out.println("password is :" + password);

    }
}
