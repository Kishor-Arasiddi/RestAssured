package pack2;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Headers {

//    @Test
    void testHeaders(){
        given()

                .when()
                .get("https://www.google.com/")

                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding","gzip")
                .header("Server","gws");

    }

    @Test
    void getHeaders(){
        Response res = given()

                .when()
                .get("https://www.google.com/");

        //To get single header value
        String headerValue = res.getHeader("Content-Type");
        System.out.println("Value of header ===> "+headerValue);


        //To get all headers info
        io.restassured.http.Headers myHeaders = res.getHeaders();

        for(Header hd:myHeaders){
            System.out.println(hd.getName()+"          "+hd.getValue());
        }


    }
}
