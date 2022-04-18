package restAssured.config.model;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI="https://fakestoreapi.com";
    }
}
