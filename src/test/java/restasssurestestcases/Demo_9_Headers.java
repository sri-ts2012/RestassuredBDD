package restasssurestestcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Demo_9_Headers {
	
	
	//Validating headers
		//@Test(priority=1)
		public void getWeatherDetails()
		{
			given()
				.param("type","supermarket")
				.param("key","AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s")
			.when()
				.get("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500")
			//we are not validating response but direct headers
			.then()
				.header("Content-Type","application/xml; charset=UTF-8")
				.and()
				.header("Content-Encoding", "gzip")
				.and()
				.header("Server", "scaffolding on HTTPServer2");
				
		}
		
		//Get Response Headers- Single and All
			@Test(priority=2)
			public void testGetResponseHeaders()
			{
				Response response=
				given()
					.param("type","supermarket")
					.param("key","AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s")
				.when()
					.get("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500");
				
			//get single header
				
				String headerContentType=response.getHeader("Content-Type");
				System.out.println("Content Type Heade value is:"+headerContentType);
				
			//get all the headers from response
				
				Headers headers=response.getHeaders();
				
				for(Header h:headers)
				{
					System.out.println(h.getName()+":"+h.getValue());
				}
				
			}
		

}
