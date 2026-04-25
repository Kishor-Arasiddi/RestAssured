package diffWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Using_POJO {

    // Post request body using POJO

    @Test(priority = 1)
    void testPostUsingPOJO(){

        Pojo_PostRequest data=new Pojo_PostRequest();
        data.setName("john");
        data.setLocation("india");
        data.setPhone("123456");

        String courseArr[]={"java","python"};
        data.setCourses(courseArr);

        given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("http://localhost:3000/students")

                .then()
                .statusCode(201)
                .body("name",equalTo("john"))
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
