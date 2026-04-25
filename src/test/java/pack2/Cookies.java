package pack2;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.*;

public class Cookies {

//    @Test
    void testCookie(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .cookie("AEC","AVcja2fzvv7lnt5DbKXddik8IyfP_NvYh_yP58fKiTEpszIDPTcw1zeZ3OU")
                .log().all();
    }

    @Test
    void getCookiesInfo(){
        //here after creating variable in given() and ending in when() with semi-colon then only we can get cookies information
        Response res = given()

                .when()
                .get("https://www.google.com/");

        //To get single cookie info
//        String cookie_value = res.getCookie("AEC");
//        System.out.println("Value of the cookie ===> "+cookie_value);


        //To get all cookies info
        Map<String, String> cookies_value = res.getCookies();

        for(String k:cookies_value.keySet()){
            String cookie_value = res.getCookie(k);
            System.out.println(k+"      ==     "+cookie_value);
        }

    }



}
