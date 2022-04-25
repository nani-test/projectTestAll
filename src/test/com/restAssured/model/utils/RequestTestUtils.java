package restAssured.model.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import restAssured.model.config.BaseTest;
import java.util.HashMap;
import java.util.Map;

public class RequestTestUtils extends BaseTest {

    public static Response postRequest(String pathResource, Object body)
    {
        Map<String, Object> headers= new HashMap<>();
        headers.put("Content-type","application/json");
        headers.put("Accept","application/json");

        return RestAssured.given().headers(headers)
                .when()
                .body(body)
                .post(pathResource)
                .then().extract().response();
    }

    public static Response getRequest(String pathResource)
    {
        Map<String, Object> headers= new HashMap<>();
        headers.put("Content-type","application/json");

        return RestAssured.given().headers(headers)
                .when().get(pathResource).then()
                .extract().response();
    }

    public static Response putRequest(String pathResource, String body)
    {
        Map<String, Object> headers= new HashMap<>();
        headers.put("Content-type","application/json");

        return RestAssured.given().headers(headers)
                .body(body)
                .when().put(pathResource).then()
                .extract().response();
    }

    public static Response patchRequest(String pathResource, String body)
    {
        Map<String, Object> headers= new HashMap<>();
        headers.put("Content-type","application/json");

        return RestAssured.given().headers(headers)
                .body(body)
                .when().patch(pathResource).then()
                .extract().response();
    }
}
