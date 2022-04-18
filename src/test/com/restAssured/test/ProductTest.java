package restAssured.test;

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
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    @Test
    public void createProduct()
    {
        ProductDTO productDTO = ProductTestUtils.callApiCreateProduct("/products").as(ProductDTO.class);
        logger.info("Verify the object was created");
        Assert.assertNotNull(productDTO);

    }

}
