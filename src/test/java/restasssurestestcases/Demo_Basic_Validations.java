package restasssurestestcases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*1) Test Status Code
2) Log Response
3) Verifying Single content in response body
4) Verifying Multiple contents in response body
5) Setting parameters & headers*/
public class Demo_Basic_Validations {
	
	@Test(priority=1)
	public void testStatusCode()
	{
		//given()//if no given
		when()
		.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
		.statusCode(200);
	//	.log().all();
		//or
		
		//given().when().get("https://jsonplaceholder.typicode.com/posts/5").then().statusCode(200);
		
	}
	
	@Test(priority=2)
	public void testlogResponse()
	{
		//given()//if no given
		when()
		.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
		.statusCode(200)
		.log().all();
		//or
		
		//given().when().get("https://jsonplaceholder.typicode.com/posts/5").then().statusCode(200);
	}
		/*@Test(priority=3)
		public void testSingleContent()
		{
			//given()//if no given
			when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
			.then()
			.statusCode(200)
			.body(".title", equalTo("nesciunt quas odio"));
		}*/
			
			//testing multiply content
			/*@Test(priority=4)
			public void testMultipleContent()
			{
				//given()//if no given
				when()
				.get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.then()
				.statusCode(200)
				.body(".title", hasItems("nesciunt quas odio","xyz","abc"));
			
			}*/
			
			@Test(priority=4)
			public void testParametersandHeaders()
			{
				given()
				.param("Myname", "hima")
				.header("MyHeader","indian")
				.when()
				.get("https://restcountries.eu/rest/v2/alpha?codes=col;no;ee")
				.then()
				.statusCode(200)
				//.body(".titile", hasItems("nesciunt quas odio","xyz","abc"))
				.log().all();
	
			}

}
