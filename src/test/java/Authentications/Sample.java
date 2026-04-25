package Authentications;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

public class Sample {

    private static String authToken = null;

    public static String getAuthToken() {

        if (authToken == null) {

            RestAssured.baseURI = "https://fl-htgqa-dyp-sb-01.hhstechgroup.com";

            String requestBody = """
                    {
                      "email": "harsih@sharklasers.com",
                      "password": "Abcd@123",
                      "pemUser": false
                    }
                    """;

            Response response = RestAssured
                    .given()
                    .relaxedHTTPSValidation()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/api/providermgmt/authenticate/login")
                    .then()
                    //.log().all()
                    .extract()
                    .response();

            // Get all cookies
            Cookies cookies = response.getDetailedCookies();

            // Print all cookies (to see what RestAssured captured)
//            cookies.forEach(cookie -> System.out.println(cookie.getName() + " = " + cookie.getValue()));

            // Extract auth_token specifically
            String authToken = cookies.getValue("auth_token");

            System.out.println("Auth Token from Cookie = " + authToken);
        }

        return authToken;
    }

    public static void main(String[] args){
        getAuthToken();
    }
}
