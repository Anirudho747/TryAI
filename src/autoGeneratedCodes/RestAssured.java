package automation.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
import java.io.PrintStream;

public class GetAllCountriesTest {

    @BeforeMethod
    public void setUp() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://restcountries.com/v3.1";
    }

    @Test
    public void testGetAllCountries() {
        // Send a GET request to /all endpoint
        Response response = given()
                .when()
                .get("/all");

        // Print the response body
        response.body().prettyPrintTo(System.out);

        // Assert the response status code
        response.then().statusCode(200);

        // Assert the response body is not null
        assertNotNull(response.body(), "Response body should not be null");

        // Assert the response contains JSON data
        response.then()
                .header("Content-Type", "application/json")
                .header("Content-Encoding", "gzip");
    }
}