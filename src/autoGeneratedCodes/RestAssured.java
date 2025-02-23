package automation.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetAllCountriesTest {

    @BeforeMethod
    public void setup() {
        // Setting the base URI for the API endpoint
        RestAssured.baseURI = "https://restcountries.com";
    }

    @Test
    public void testGetAllCountries() {
        // Sending a GET request to /all endpoint
        Response response = given()
                .when()
                .get("/all");

        // Printing the response body for verification
        System.out.println("Response Body: " + response.body().prettyPrint());

        // Asserting the status code
        assertEquals(response.getStatusCode(), 200, "Status code should be 200");

        // Asserting the content type
        assertEquals(response.contentType, "application/json", "Content type should be JSON");

        // Asserting the response body is not empty
        assertTrue(response.body().prettyPrint().length() > 0, "Response body should not be empty");
    }
}