package restAssured.config.utils;

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
}
