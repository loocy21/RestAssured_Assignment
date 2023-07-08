package Assignment;



import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Get_Request1 {

    @Test
    public void filterUserDetails() {
        // GET request to retrieve the users
        Response response = given()
                .queryParam("page", 1)
                .get("https://reqres.in/api/users");

        // Validate the response code
        response.then().statusCode(200);

        // Extract the first names and emails from the response
        String[] firstNames = response.jsonPath().get("data.first_name");
        String[] emails = response.jsonPath().get("data.email");

        // Print the first names and emails
        for (int i = 0; i < firstNames.length; i++) {
            System.out.println("First Name: " + firstNames[i]);
            System.out.println("Email: " + emails[i]);
            System.out.println("------------------------");
        }
    }
}












