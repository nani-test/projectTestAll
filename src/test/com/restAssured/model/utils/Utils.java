package restAssured.model.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import restAssured.test.dto.BookingDTO;
import restAssured.test.dto.BookingDates;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Utils {

    public static String generateRandomString(int length) {
        Random rng = new Random();
        String alphanumeric = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        String finalString = "";
        for (int x = 0; x < length; x++) {
            finalString = finalString
                    .concat(Character.toString(alphanumeric.charAt(rng.nextInt(alphanumeric.length()))));
        }
        return finalString;
    }

    public static Double generateRandomDouble(int min, int max)
    {
         return (Math.random() * (max-min))-min;
    }

    public static Integer generateRandomInteger(int min, int max)
    {
        return (int)(Math.random() * (max-min))-min;
    }

    public static String loginUser(String user, String password,String url) throws JsonProcessingException {

       return RequestTestUtils.postRequest(url, userBody(user,password))
               .jsonPath().get("token");

    }

    public static String userBody(String user,String password) throws JsonProcessingException {
        Map<String,String> body= new HashMap<>();
        body.put("username",user);
        body.put("password",password);

        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.writeValueAsString(body);
    }

    public static BookingDTO createRequestBooking()
    {
        BookingDTO  bookingDTO= new BookingDTO();
        BookingDates bookingDates= new BookingDates();
        bookingDates.setCheckin("2022-03-23");
        bookingDates.setCheckout("2022-03-24");
        bookingDTO.setFirstname("Test");
        bookingDTO.setLastname("Test");
        bookingDTO.setTotalprice(122);
        bookingDTO.setAdditionalneeds("cosas");
        bookingDTO.setBookingdates(bookingDates);
        bookingDTO.setDepositpaid(true);

        return bookingDTO;
    }
}
