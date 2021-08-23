package restasssurestestcases;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class Demo_8_Differentwaystoresponse {
	
	
	@Test(priority=1)
	public void getWeatherDetails()
	{

		
		
	/*	String response=
				given()
		.when()
			.get("https://demoqa.com/utilities/weather/city/mumbai")
			.asString();
		System.out.println("response is"+response);*/
		//or
		
	String response1=get("https://demoqa.com/utilities/weather/city/mumbai").asString();
	//but get like this is not working 
	}
	@Test(priority=2)
	public void testExtractDetailsUsingPath()
	{
		String href=
		given()
		
			.when()
				.get("http://jsonplaceholder.typicode.com/photos/1")
				.then()
					.contentType(ContentType.JSON)
					//we need to verify that it is json before writing othercode
					.body("albumId", is(1))
					//here we can use is, because each is node/root
					.extract().path("url");
		//here no sub nodes, so direct path is ("url") or write the path till the reqd node
		
		System.out.println("Extracted URL value is:"+href);
	}
	
	@Test(priority=3)
	public void testExtractPathinOneLine()
	{
		
	/*	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");*/
		//Approach1
		Response response=get("https://jsonplaceholder.typicode.com/photos/1");
		
		String href1=response.path("thumbnailUrl");
		//or can write like below
			String href3=get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");
		System.out.println("Fetched Thumbnail URL1 : --->"+href1);
		
		
		//Appraoch2
		
		String href2=get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("thumbnailUrl");
		System.out.println("Fetched Thumbnail URL2 : --->"+href2);
		
		given().when()
			.get(href1)//using the output of one request as inout of other request
		.then()
			.statusCode(200);
	
	}
	
	//before example is to get certain like path from the response.thats the difference
	//below will capture the complete response and get the details that i want
	//Extract details as Response for Further use below

	
	//Extract details as Response for Further use
	
		@Test(priority=4)
		public void testExtractDetailsUsingResponse()
		{
			Response response=given()
			
			.when()
			
				.get("http://jsonplaceholder.typicode.com/photos/1")
			.then()
				.extract().response();
			
			System.out.println("Content Type of Response:"+response.contentType());
			System.out.println("Title from the Response:"+response.path("title"));
			System.out.println("status from the Response:"+response.getStatusCode());
				
		}
		

}
