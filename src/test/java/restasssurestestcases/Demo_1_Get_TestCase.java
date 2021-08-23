package restasssurestestcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/*
given()
	set cookies, add auth, add param, set headers info etc....
when()
	get, post,put,delete...	

then()
	validate status code, extract response, extract headers cookies & response body....
 */


public class Demo_1_Get_TestCase {
	
	
	@Test
	public void getWeatherDetails()
	{

		//all is single statement but writing in different lines
		
		given()
		.when()
			.get("https://demoqa.com/utilities/weather/city/mumbai")
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("City", equalTo("mumbai"))
		.header("Content-Type","application/json; charset=utf-8");
	
			
	}

}
