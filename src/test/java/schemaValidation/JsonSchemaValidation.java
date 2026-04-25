package schemaValidation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation {

    @Test
    void jsonSchemaValidation(){
        given()

                .when()
                .get("http://localhost:3000/store")

                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));
    }
}
