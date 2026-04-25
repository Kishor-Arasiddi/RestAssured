package Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PreemptiveAuthentication {

    @Test
    void testPreemptiveAuthentication(){
        given()
                .auth().preemptive().basic("postman","password")

                .when()
                .get("https://postman-echo.com/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated",equalTo(true))
                .log().all();
    }
}
