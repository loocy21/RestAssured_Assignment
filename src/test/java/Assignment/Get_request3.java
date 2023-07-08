package Assignment;



import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_request3 
{
       @Test
		public void validateResponseCodeAndUserDetails() {
			// GET request to retrieve the users
			Response response = given()
					.queryParam("page", 1)
					.get("https://reqres.in/api/users");

			// Validate the response code
			response.then().statusCode(200);

			// Validate user details
			response.then().body("data", notNullValue())
			.body("data.id", hasItems(1, 2, 3)) //validate specific user IDs
			.body("data.first_name", hasItems("George", "Janet", "Emma")); //validate specific first names
		}
	}



