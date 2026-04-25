package pack2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParameters {

    //  http://reqres.in/api/users?page=2&id=5

    @Test
    void testPathAndQueryParameter(){

        given()
                .pathParam("mypath","users")   //path parameter
                .queryParam("page",2)    //query parameter
                .queryParam("id",5)      //query parameter

                .when()
                //here we don't need to provide any query parameter we already gave in given() method
                .get("http://reqres.in/api/{mypath}")

                .then()
                .statusCode(200)
                .log().all();
    }
}
