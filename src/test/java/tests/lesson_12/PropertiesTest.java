package tests.lesson_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    protected Properties properties;

    public PropertiesTest() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("test.properties"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public String getTestName() {
        return properties.getProperty("testName");
    }

    public String getTestValue() {
        return properties.getProperty("testValue");
    }


    @Test
    public void returnPropertiesToConsole() {
        Assert.assertEquals(getTestName(), "someName");
        Assert.assertEquals(getTestValue(), "someValue");
    }
}
