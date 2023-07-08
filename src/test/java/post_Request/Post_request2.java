package post_Request;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
	

	public class Post_request2 {

	    @Test
	    public void validateResponseCodeAndUserDetails() {
	        // Request payload for creating a new user
	        String requestBody = "{\"name\": \"Shobha\", \"job\": \"Software Engineer\"}";

	        // POST request to create a new user
	        Response response = given()
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .post("https://reqres.in/api/users");

	        // Validate the response code
	        response.then().statusCode(201);

	        // Validate user details
	        response.then().body("name", equalTo("Shobha"))
	                .body("job", equalTo("Software Engineer"))
	                .body("id", notNullValue())
	                .body("createdAt", notNullValue());
	    }
	}



