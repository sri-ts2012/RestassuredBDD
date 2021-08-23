package restasssurestestcases;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

public class Demo_StudentAPITestNoSerialization {
	
	public HashMap map=new HashMap();
	
	//Post requests creates a new student record
	@Test(priority=1)
	public void createNewStudent()
	{
		map.put("id",101);
		map.put("firstName","Pavan");
		map.put("lastName","Kumar");
		map.put("email","abcxyz@gmai.com");
		map.put("programme","Manger");
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		map.put("courses", coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg",equalTo("Student added"));
	}
	
	//Get Request to retrieve studetn details
	
	@Test(priority=2)
	void getStudentRecord()
	{
		given()
			.when()
				.get("http://localhost:8085/student/101")
			.then()
				.statusCode(200)
				.assertThat()
				.body("id",equalTo(101))
				.log().all();
	}
	
}




