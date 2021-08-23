package restasssurestestcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * 
1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go
4) Find values using XML Path in XML response 
5) XPath with text() function
 * 
 */

public class Demo_6_BasicValidationsXML {
	//1) Verifying Single content in XML Response
	
		@Test(priority=1)
		void testSingleContent()
		{
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
				
			.then()
				.body("CUSTOMER.ID",equalTo("15"))
				//above is xml path
				//root tag is customer then id
				.log().all();
			
		}
		
		//2) Verifying Multiple contents in XML Response
		@Test(priority=2)
		void testMultipleContents()
		{
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
				
			.then()
				.body("CUSTOMER.ID",equalTo("15"))
				.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
				.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
				.body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
				.body("CUSTOMER.CITY",equalTo("Seattle"));
					
		}
		
		
		//3) Verifying all the content in XML response in one go
		@Test(priority=3)
		void testMultipleContentsInOneGo()
		{
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
				
			.then()
				.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
						
		}
		
		
		// Find values using XML Path in XML response
		
		@Test(priority=4)
		void testUsingXPath1()
		{
			 given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
				
			.then()
				.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
		}
		
		
		@Test(priority=5)
		void testUsingXPath2()
		{
			 given()
				
				.when()
					.get("http://thomas-bayer.com/sqlrest/INVOICE/")
					
				.then()
					.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			 		.log().all();
		}
		
		
	

}
