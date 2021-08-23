package restasssurestestcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
public class Demo_10_cookies {
	
	@Test(priority=1)
	public void testCookies()
	{
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/photos")
		.then()
		//ccokies , key and value of the cookie
		.cookie("__cfduid","d872e803b14cfbcd8c38ab769e95e7cbb1620130904");
	}
	
		
		//get the cookie dynamically,capture response and get cookie frm it
		@Test(priority=2)
		public void testGetCookie()
		{
			Response response=given()
			.when()
			.get("https://jsonplaceholder.typicode.com/photos");
			//get single cookie frm the response
			String cookie_value=response.getCookie("__cfduid");
			System.out.println(cookie_value);
			//get all the cookies from the response
		Map<String,String>cookies_value=response.getCookies();
		
		for(Map.Entry Entry:cookies_value.entrySet())
		{
			System.out.println(Entry.getKey()+"---->"+Entry.getValue());
		}
			
		}
		
		@Test(priority=3)
		public void testGetCookieDetail()
		{
			Response response=get("https://jsonplaceholder.typicode.com/photos");
			//get single cookie frm the response
			Cookie cookie_info=response.getDetailedCookie("__cfduid");
			System.out.println(cookie_info.hasExpiryDate());
		System.out.println(cookie_info.getExpiryDate());
		System.out.println(cookie_info.hasValue());
		System.out.println(cookie_info.getValue());
		
	}
		
}


