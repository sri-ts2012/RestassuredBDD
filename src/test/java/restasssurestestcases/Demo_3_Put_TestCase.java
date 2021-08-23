package restasssurestestcases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
public class Demo_3_Put_TestCase {
	
	
public static HashMap map=new HashMap();
	
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	int emp_id=11501;
	
	@BeforeClass
	public void putData()
	{
		map.put("name",empName);
		map.put("salary",empSalary);
		map.put("age",empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
		
	}
	
	@Test
	public void testPUT()
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();// this will log all the changes 
			
	}
		

}
