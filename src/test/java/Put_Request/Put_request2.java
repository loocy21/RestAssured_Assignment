package Put_Request;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Put_request2 
{
	

	
	    @Test
	    public void validateResponseCodeAndUserInfoAfterUpdate() {
	        int userId = 1; // Replace with the actual user ID retrieved in the previous step

	        // Request payload for updating user information
	        String requestBody = "{\"name\": \"Updated Name\", \"job\": \"Updated Job\"}";

	        // PUT request to update user information
	        Response response = given()
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .put("https://reqres.in/api/users/" + userId);

	        // Validate the response code
	        response.then().statusCode(200);

	        // Validate the updated user information
	        response.then().body("name", equalTo("Updated Name"))
	                .body("job", equalTo("Updated Job"))
	                .body("updatedAt", notNullValue());

	        // Print the response body
	        System.out.println("Response Body:");
	        System.out.println(response.getBody().asString());
	    }
	}



