package selenium.model.testConfig.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import selenium.test.HomePageTest;

public class DataProviders {

    @DataProvider
    public Object[][] getDataProduct()
    {
        return new Object[][]{{"test"},{"test"}};
    }

    @Factory
    public Object[] getData()
    {
        Object[] data= new Object[5];
        data[0]= new HomePageTest();
        return data;
    }
}
