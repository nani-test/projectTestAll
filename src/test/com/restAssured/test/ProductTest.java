package restAssured.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import restAssured.config.model.BaseTest;
import restAssured.config.utils.ProductTestUtils;
import restAssured.test.dto.ProductDTO;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class ProductTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ProductTest.class);

    @Test(enabled = false)
    public void getProducts() {
        String products= given()
                .when()
                .get("/products")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body("category", contains("men's category"))
                .extract().response().asPrettyString();
        Assert.assertFalse(products.isEmpty());

    }

    @Test (enabled = false)
    public void getSingleProduct() {

        String product= ProductTestUtils.callApiUtils("/products").asPrettyString();

        List<Integer> idsProducts = ProductTestUtils.getAllProductsId(product);
        if(idsProducts != null) {
            int productId = idsProducts.get(new Random().nextInt(idsProducts.size() - 1));

            ProductDTO productDTO = ProductTestUtils.callApiUtils("products/" + productId).as(ProductDTO.class);

            Assert.assertEquals(productDTO.getId(), productId);
        }

    }

    @Test (enabled = false)
    public void getProductsAndOrder() {

        String response= ProductTestUtils.callApiUtils("/products").asPrettyString();
        Response response1= ProductTestUtils.callApiUtils("/products?sort=desc").andReturn();
        JsonPath jsonPath= response1.jsonPath();
        List<Integer> productDTOS= ProductTestUtils.getAllProductsId(response);
        if(productDTOS != null) {
            Integer products = Collections.max(productDTOS);

            Assert.assertEquals(products, jsonPath.get("id[0]"));
        }
    }

    @Test (enabled = false)
    public void createProduct()
    {
        ProductDTO productDTO = ProductTestUtils.callApiCreateProduct("/products").as(ProductDTO.class);
        logger.info("Verify the object was created");
        Assert.assertNotNull(productDTO);

    }

    @Test (enabled = false)
    public void getProductCategory()
    {
       Response response= ProductTestUtils.callApiUtils("/products/categories").then()
               .statusCode(200)
               .assertThat()
               .body("[0]", equalTo("electronics"))
               .body("[3]", equalTo("women's clothing"))
                .extract().response();
        List<String> categories= Collections.singletonList(response.asPrettyString());

    }

    @Test
    public void getProductCategoryOne() throws IOException, ClassNotFoundException {

        logger.info("Obtaining all the categories");
        String response = ProductTestUtils.callApiUtils("/products/categories").then()
                .extract().response().asPrettyString();
        ObjectMapper objectMapper= new ObjectMapper();
        List<String> categories= objectMapper.readValue(response,objectMapper
                .constructType(List.class));

        String cat = categories.get(0);
        String uriPart1="/products/category/";
        String uri= uriPart1 + cat.trim();
        System.out.println("uri = " + uri);

        logger.info("With the category desired verify that in the response the category is present");
        String productDTO = ProductTestUtils.callApiUtils(uri)
                .then().statusCode(200).extract().response().asPrettyString();

        List<ProductDTO> productDTO1 = objectMapper.readValue(
                productDTO, objectMapper.getTypeFactory().constructCollectionType(List.class, ProductDTO.class)
        );
        for (int i = 0; i < productDTO1.size() - 1; i++) {
            System.out.println("productDTO1.get(i).getCategory() = " + productDTO1.get(i).getCategory());
            Assert.assertEquals(productDTO1.get(i).getCategory(), cat);
        }
    }

}
