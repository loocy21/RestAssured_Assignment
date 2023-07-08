package post_Request;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class Post_request1 
{
		    @Test
	    public void createNewUserAndGetId() {
	        // Request payload for creating a new user
	        String requestBody = "{\"name\": \"Shobha\", \"job\": \"Software Engineer\"}";

	        // POST request to create a new user
	        Response response = given()
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .post("https://reqres.in/api/users");

	        // Validate the response code
	        response.then().statusCode(201);

	        // Extract the newly created user ID from the response
	        int userId = response.jsonPath().getInt("id");

	        // Print the newly created user ID
	        System.out.println("New User ID: " + userId);
	    }
	}



