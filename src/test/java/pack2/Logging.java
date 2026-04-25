package pack2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Logging {

    @Test
    void testLog(){
        given()

                .when()
                .get("http://reqres.in/api/users?page=2")

                .then()
//                .log().headers();
//                .log().cookies();
//                .log().body();
                .log().all();
    }
}
