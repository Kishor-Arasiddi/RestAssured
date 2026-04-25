package diffWaysToCreatePostRequestBody;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsingExternalJsonFile {

    //post request body using external json file

    @Test(priority = 1)
    void testPostUsingHashmap() throws FileNotFoundException {

        File f=new File(".\\body.json");
        FileReader fr=new FileReader(f);
        JSONTokener jt=new JSONTokener(fr);
        JSONObject data=new JSONObject(jt);


        given()
                .contentType("application/json")
                .body(data.toString())

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
