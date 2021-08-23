package restasssurestestcases;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo_7_RootValidations {
	//screenshots in webservices file in gdrive
	@Test(priority=1)
	public void testWithoutRoot()
	{
		when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.body("RestResponse.result.name",equalTo("India"))
			.body("RestResponse.result.alpha2_code",equalTo("IN"))
			.body("RestResponse.result.alpha3_code",equalTo("IND"));
		
	}
	
	@Test(priority=2)
	public void testWithRootPathJSON()
	{
		when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.rootPath("RestResponse.result")
			.body("name",is("India"))
			.body("alpha2_code",is("IN"))
			.body("alpha3_code",is("IND"));
		
	}
	
	@Test(priority=3)
	public void testWithDetachRootPathJSON()
	{
		when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.rootPath("RestResponse.result")
			.body("name",is("India"))
			.body("alpha2_code",is("IN"))
			
			.detachRootPath("result")
			
			.body("result.alpha3_code",is("IND"));
		
	}
	
	@Test(priority=4)
	public void testWithDetachRootPathXML()
	{
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.rootPath("CUSTOMER")
			.body("FIRSTNAME",is("Bill"))
			.body("LASTNAME",is("Clancy"))
					
			.detachRootPath("CUSTOMER")
			
			.body("CUSTOMER.STREET",is("319 Upland Pl."))
			.body("CUSTOMER.CITY",is("Seattle"));
		
	}
	
	
	
	

}
