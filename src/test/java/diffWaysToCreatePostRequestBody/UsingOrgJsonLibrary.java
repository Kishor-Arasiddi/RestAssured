package diffWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsingOrgJsonLibrary {

    // Post request body using org.json library

    @Test(priority = 1)
    void testPostUsingJsonLibrary(){

        JSONObject data=new JSONObject();
        data.put("name","king");
        data.put("location","india");
        data.put("phone","123456");

        String courseArr[]={"java","python"};
        data.put("courses",courseArr);



        given()
                .contentType("application/json")
                .body(data.toString())   //here we are using json library so here we need to convert to String format using toString()..

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("king"))
                .body("location",equalTo("india"))
                .body("phone",equalTo("123456"))
                .body("courses[0]",equalTo("java"))
                .body("courses[1]",equalTo("python"))
                .log().all();
    }

    @Test(priority = 2)
    void testDelete(){
        given()

                .when()
                .delete("http://localhost:3000/students/3")

                .then()
                .statusCode(200);

    }
}
