package restasssurestestcases;

import java.util.List;

public class Student1 {
	
	//int  id;
	public Integer id;
	public String fname;
	public String lname;
	public String email;
	List<String> courses;
	
	public int getSID()
	{
		return id;
	}
	
	public void setSID(Integer id)
	{
		this.id=id;
	}
	
	public List<String> getCourses()
	{
		return courses;
	}
	
	public void setCourses(List<String> courses){
		this.courses=courses;
		
	}
	

}
