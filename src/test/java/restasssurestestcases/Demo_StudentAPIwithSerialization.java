package restasssurestestcases;


	
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

	public class Demo_StudentAPIwithSerialization {
		
		//post as serialize and get as deserialize
		//sending post as part of file,create stu object, will pass this object as serialization
		//get the object data as part of deserialization
		//to create post request, we need a student class , inside it we are going to create certian variables and methods ie
		//getters and setters
		//create object of this class and pass it as object of post request
		//we need to pass object as part of request and later can convert to file format
		
		
		
		

		@Test(priority=1)
		public void createNewStudentSerialization()
		{
			
			
			
			
			ArrayList<String> coursesList=new ArrayList<String>();
			coursesList.add("Java");
			coursesList.add("selenium");
			
			Student stu=new Student();
			stu.setSID(101);
			stu.setFirstName("John");
			stu.setLastName("Deo");
			stu.setEmail("abc@gmail.com");
			stu.setProgramme("Computer science");
			
			stu.setCourses(coursesList);
			
			given()
				.contentType(ContentType.JSON)
				.body(stu)//it will be converted to file
			.when()
				.post("http://localhost:8085/student")
			.then()
				.statusCode(201)
				.assertThat().body("msg",equalTo("Student added"));
		}
		
		@Test(priority=2)
		void getStudentRecordDeSerilization() throws IOException, ClassNotFoundException
		{
			//here we are going to convert the response in file (not file in below example just the response we are converting to object --into student class object
			Student stu= get("http://localhost:8085/student/101").as(Student.class);
						
			System.out.println(stu.getStudentRecord());
			Assert.assertEquals(stu.getSID(), 101);
			
			//below to download a file , how to i wrote sample code
			//Test t2=(Test) ois.readObject();
			//System.out.println(t2.i+"  "+t2.j);
			FileInputStream fis=new FileInputStream("test1.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Student stu1=(Student)ois.readObject();
			//System.out.println(stu1.email,stu1.courses);showing error as 
			//we need to iterate to print the list items
			System.out.println(stu1.email);
		}
		
		
	}



