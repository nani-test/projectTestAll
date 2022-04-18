package restAssured.config.utils;

import restAssured.test.dto.ProductDTO;
import restAssured.test.dto.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
        ProductDTO productDTO= new ProductDTO();
        productDTO.setCategory("nany category");
        productDTO.setDescription("test");
        productDTO.setPrice(234.65);
        productDTO.setTitle("Test Test");
        productDTO.setRating(new Rating(56.87,9));
        productDTO.setImg("path here");

        return productDTO;
    }
}
