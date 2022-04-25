package restAssured.model.utils;

import org.testng.annotations.DataProvider;

public class DataTestUtils {

    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{{"algo"},{"testing"}};
    }
}
