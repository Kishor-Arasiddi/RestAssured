package pack3;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParsingJsonResponseData {

    //    @Test
    void testJsonResponse() {

        //Approach 1: In this approach we are directly parsing json response data in then() method and it is not recommended
                     //because it doesn't support when we have large number of data.

        given()
                .contentType(ContentType.JSON)

                .when()
                .get("http://localhost:3000/store")

                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .body("book[3].title", equalTo("Moby Dick"));


        //Approach 2: In this approach here we are creating variable to do assertions and it is also not recommended
                    // Because here the data/content changing dynamically then it is difficult to locate elements.

        Response res = given()
                .contentType(ContentType.JSON)

                .when()
                .get("http://localhost:3000/store");

        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json");

        String bookName = res.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookName, "Moby Dick");
    }

    @Test
    void testJsonResponseBodyData() {

        Response res = given()
                .contentType(ContentType.JSON)

                .when()
                .get("http://localhost:3000/store");

        JSONObject jo = new JSONObject(res.asString());   //converting response to json object
        //to get the all the book titles
//        for (int i=0;i<jo.getJSONArray("book").length();i++){
//            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
//            System.out.println(bookTitle);


        //Search for the title of the book in json   -Validation 1
        boolean status = false;
        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
            String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
            if (bookTitle.equals("Moby Dick")) {
                status = true;
                break;
            }
        }
        Assert.assertEquals(status, true);

        //Validate total price of the books   -Validation 2
        double totalPrice = 0;
        for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
            String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
            totalPrice=totalPrice+Double.parseDouble(price);
        }
        System.out.println("Total price of books is: "+totalPrice);
        Assert.assertEquals(totalPrice,526.5);


    }
}
