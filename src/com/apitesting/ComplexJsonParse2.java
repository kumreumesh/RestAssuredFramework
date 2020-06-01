package com.apitesting;

import com.files.Bodycode;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse2 {

	public static void main(String[] args) {
		
		JsonPath js2=new JsonPath(Bodycode.coursePrice());
		
		int count=js2.getInt("courses.size()");//print no of course returned by API
		    
		 System.out.println("No of courses available is :-"+count);
		
		//print all courses title and their respective price 
		 
		 for(int i=0;i<count;i++)
		 {
			 String courseTitle=js2.get("courses["+i+"].title");
			 
			 System.out.println(js2.get("courses["+i+"].price").toString());
			 
			 System.out.println(courseTitle);
			 
	     }

		 System.out.println(("==print no of copies sold by RPA course=="));
		 
		
		 for(int i=0;i<count;i++)
		 {
			 
		 String courseTitles=js2.get("courses["+i+"].title");
		 
		 if(courseTitles.equalsIgnoreCase("RPA"))
		 {
			int TotCopy=js2.get("courses["+i+"].copies"); 
		 
			System.out.println(TotCopy);
			
			break;
		 }
		 
		 }
	}

}
