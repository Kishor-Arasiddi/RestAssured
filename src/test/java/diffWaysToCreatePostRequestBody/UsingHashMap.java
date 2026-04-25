package diffWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UsingHashMap {

    // Post request body using HashMap

    @Test(priority = 1)
    void testPostUsingHashmap(){
        HashMap data=new HashMap();
        data.put("name","john");
        data.put("location","india");
        data.put("phone","1234567890");

        String courseArr[]={"java","selenium"};
        data.put("courses",courseArr);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("john"))
                .body("location",equalTo("india"))
                .body("phone",equalTo("1234567890"))
                .body("courses[0]",equalTo("java"))
                .body("courses[1]",equalTo("selenium"))
                .log().all();
    }

    @Test(priority = 2)
    void testDelete(){
        given()

                .when()
                .delete("http://localhost:3000/students/1")

                .then()
                .statusCode(200);

    }
}
