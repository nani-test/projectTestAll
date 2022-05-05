package restAssured.test.booking;

import org.testng.Assert;
import org.testng.annotations.Test;
import restAssured.model.config.BaseTest;
import restAssured.model.utils.RequestTestUtils;
import restAssured.model.utils.Utils;
import restAssured.test.dto.response.BookingsResponse;
import utilsCommun.DataLoadPro;

public class BookingTest extends BaseTest {

    DataLoadPro dataLoadPro= new DataLoadPro();

    @Test
    public void createBookingCorrectly() {

        BookingsResponse response= RequestTestUtils.postRequest("/booking",Utils.createRequestBooking())
                .then().assertThat().statusCode(200).extract().response()
                .as(BookingsResponse.class);
        Assert.assertNotNull(response.getBookingid());

    }

}
