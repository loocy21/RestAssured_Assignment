package Assignment;


import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get_request2 
{


	@Test
	public void getUserDetailsById() {
		int userId = 2; // Specify the ID of the user you want to retrieve

		//GET request to retrieve the user details
		Response response = given()
				.pathParam("userId", userId)
				.get("https://reqres.in/api/users/{userId}");

		// Extract the user details from the response
		String firstName = response.jsonPath().get("data.first_name");
		String lastName = response.jsonPath().get("data.last_name");
		String email = response.jsonPath().get("data.email");

		// Print the user details
		System.out.println("User Details for ID " + userId);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Email: " + email);
	}
}



