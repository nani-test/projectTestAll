package restAssured.config.utils;


import restAssured.test.dto.ProductDTO;
import restAssured.test.dto.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilsCommun.DataLoadPro;

import java.util.*;
import static io.restassured.RestAssured.*;

public class ProductTestUtils {


    public static Response callApiUtils(String url)
    {
        Map<String,Object> headers= new HashMap<>();
        headers.put("Content-type", ContentType.JSON);

        return given().headers(headers)
                        .log().all().
                when()
                .get(url)
                .then().extract().response();
    }

    public static Response callApiCreateProduct(String url)
    {
        Map<String,Object> headers= new HashMap<>();
        headers.put("Content-type", ContentType.JSON);

        return given().headers(headers)
                .log().all().
                body(createRequest())
                .when()
                .post(url)
                .then().extract().response();
    }

    public static List<Integer> getAllProductsId(String response)  {
        try {
            List<Integer> idsProducts = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            List<ProductDTO> productDTOS = objectMapper.readValue(response,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, ProductDTO.class));
            for (ProductDTO productDTO : productDTOS) {
                idsProducts.add(productDTO.getId());
            }
            return idsProducts;
        }
        catch (Exception e)
        {
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }

    }


    public static ProductDTO createRequest()
    {
        DataLoadPro dataLoadPro= new DataLoadPro();
        ProductDTO productDTO= new ProductDTO();
        productDTO.setCategory("Category "+ Utils.generateRandomString(5));
        productDTO.setDescription(Utils.generateRandomString(10));
        productDTO.setPrice(Utils.generateRandomDouble(0,2));
        productDTO.setTitle("Test "+ Utils.generateRandomString(5));
        productDTO.setImg(dataLoadPro.getDriverPath("img"));

        return productDTO;
    }

    public static String searchCategory(List<String> category)
    {
        DataLoadPro dataLoadPro= new DataLoadPro();
        for (String s : category) {
            if (s.equals(dataLoadPro.getDriverPath("category"))) {
                return s;
            }
        }
        return dataLoadPro.getDriverPath("msg");
    }
}
