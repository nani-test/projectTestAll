package restAssured.model.config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import utilsCommun.DataLoadPro;


public class BaseTest {

    DataLoadPro dataLoadPro= new DataLoadPro();

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI=dataLoadPro.getDriverPath("uri");
    }
}
