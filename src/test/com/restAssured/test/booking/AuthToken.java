package restAssured.test.booking;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restAssured.model.config.BaseTest;
import restAssured.model.utils.RequestTestUtils;
import restAssured.model.utils.Utils;
import utilsCommun.DataLoadPro;
import java.util.ArrayList;
import java.util.List;

public class AuthToken extends BaseTest {

    DataLoadPro dataLoadPro= new DataLoadPro();

    @Test
    public void verifyUserStatusCode() throws JsonProcessingException {
        String body= Utils.userBody(dataLoadPro.getDriverPath("user"),dataLoadPro.getDriverPath("pass"));
        Response response= RequestTestUtils.postRequest("/auth",body);
        System.out.println("response.jsonPath() = " + response.jsonPath().get("token"));
        Assert.assertEquals(response.getStatusCode(),200);

    }

    public static void main(String[] args) {

       // System.out.println("args = " + mumberTest("sgfhj543jhsdgfhj98hhhh65"));

        int [] numeros= { 4, 3, 25, 6, 7, 8, 9, 10,7,9,5 };

        System.out.println("numero = " + testExample(numeros));
    }

    public static Integer mumberTest (String value)
    {
        StringBuilder aux= new StringBuilder();
        List<String> array= new ArrayList<>();
        int numberValue=0;
        for (int i = 0; i < value.length(); i++) {
            if(Character.isDigit(value.charAt(i)))
            {
                aux.append(value.charAt(i));

            }else {
                array.add(String.valueOf(aux));
                aux= new StringBuilder();
            }
        }
        array.add(String.valueOf(aux));
        for (String s : array) {
            if(!s.equals("")) {
                numberValue += Integer.parseInt(s.trim());
            }
        }
        return numberValue;
    }

    // find the larger integer succession
    public static Integer testExample(int[] numeros)
    {
        int count=0;
        int max=0;
        for (int i = 0; i < numeros.length -1; i++) {

            int value= numeros[i] + 1;

            if (value == numeros[i + 1])
            {
                count++ ;
            }
            else
            {
                if(count > max)
                {
                    max=count;
                }
                else
                {
                    count=0;
                }
            }
        }
        return  Math.max(max,count);
    }
}
