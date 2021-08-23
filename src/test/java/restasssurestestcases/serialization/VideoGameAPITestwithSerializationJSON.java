package restasssurestestcases.serialization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class VideoGameAPITestwithSerializationJSON {

	@Test(priority=1)
    public void testVideoGameSerializationJSON() {
				
    	VideoGame myVideoGame=new VideoGame();
		myVideoGame.setId(12);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("2019-06-17");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");
			
        given().
                contentType("application/json").
                body(myVideoGame).
        when()
                .post("http://localhost:8080/app/videogames").
        then()
                .log().all()
                .body(equalTo("{\"status\": \"Record Added Successfully\"}"));
       }
	
	@Test(priority=2)
	    public void testVideoGameDeSerializationJSON() {

	        VideoGame myVideoGame = 
	        get("http://localhost:8080/app/videogames/12").as(VideoGame.class);
	             
	        System.out.println(myVideoGame.toString());
	       
	    }
	 
	 
}
