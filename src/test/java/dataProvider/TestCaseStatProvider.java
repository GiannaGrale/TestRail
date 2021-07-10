package dataProvider;

import org.testng.annotations.DataProvider;

public class TestCaseStatProvider {

    @DataProvider(name = "TestCases")
    public static Object[][] dataForTestCases() {
        return new Object[][]{
                {"Anna's Test Case", "some preconditions", "first step, second step", "expected result"}
        };
    }

    @DataProvider(name = "EditTestCases")
    public static Object[][] dataForEditedTestCases() {
        return new Object[][]{
                {
                        "Anna's Test Case",
                        "Anna's Edited Test Case",
                        "some preconditions",
                        "some edited preconditions",
                        "first step, second step",
                        "first step, second step, third step",
                        "expected result",
                        "updated expected result"}
        };
    }
}





