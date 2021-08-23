package restasssurestestcases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_2_Post_TestCase {
	//before testing this needs to be available
	//instead of hardcoding the data, we will use utils class to generate random data 
	//we will create hashmap object so that multiple objects can be stored
	public static HashMap map=new HashMap();
	@BeforeClass
	public void postData()
	{
		
		//map.put("id", RestUtils.getId());
		map.put("firstName", RestUtils.getFirstName());
		map.put("lastName", RestUtils.getLastName());
		map.put("email", RestUtils.getEmail());
		map.put("programme", RestUtils.getProgramme());
		map.put("courses", "Java,Selenium");
		
		RestAssured.baseURI="http://localhost:8085/student/list";
		RestAssured.basePath="/102";
		
	}


	@Test
	public void testPost()
	{
		given()
		.contentType("application/json;charset=UTF-8")
		//.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post()
		
		
		.then()
		.statusCode(201)
		.body("msg", equalTo("Student added"));
		;
	}
}
