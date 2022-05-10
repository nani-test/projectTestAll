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
        System.out.println("texto = " + reverseString("RahulShettyAcademy"));
    }

    //given a string obtain the number and return the summ
    public static Integer addNumber (String value)
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
            if (numeros[i] + 1 == numeros[i + 1])
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

    //swap two numbers
    public static void swapNumbers(int number1, int number2)
    {
        System.out.println("before = " + number1);
        System.out.println("before = " + number2);
        if(number1!=0 && number2!=0)
        {
            number1= number1 + number2;
            number2= number1- number2;
            number1= number1- number2;
        }else
        {
            System.out.println("This numbers have value zero ");
        }

        System.out.println("after = " + number1);
        System.out.println("after = " + number2);
    }

    //reverse a string
    public static String reverseString(String texto)
    {
      /*  StringBuilder stringBuffer= new StringBuilder(texto);
        return String.valueOf(stringBuffer.reverse()); */
        StringBuilder reverse= new StringBuilder();
        if(texto.length()!=0)
        {
            for (int i = 0; i < texto.length()-1; i++) {
              //  reverse.append(stringBuffer.charAt(i));
                reverse.append(texto.charAt((texto.length() -1) - i));
            }
        }
       return reverse.toString();
    }

}
