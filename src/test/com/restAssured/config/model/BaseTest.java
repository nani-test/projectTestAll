package restAssured.config.model;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utilsCommun.DataLoadPro;


public class BaseTest {

    DataLoadPro dataLoadPro;

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI=dataLoadPro.getDriverPath("uri");
    }
}
