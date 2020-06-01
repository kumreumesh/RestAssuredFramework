package com.apitesting;

import com.files.Bodycode;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {


		JsonPath js2=new JsonPath(Bodycode.coursePrice());
		
	    int count=js2.getInt("courses.size()");//print no of course returned by API
	    
	    System.out.println("No of courese available is :-"+count);
	
	    
	    // Print purchase amount
	    
	    int totalAmt=js2.getInt("dashboard.purchaseAmount");
	    
	    System.out.println("Total amount of all course :-"+totalAmt);
	    
	    
	    // Print title of first course
	    
	    String title=js2.get("courses[0].title");
	    
	    System.out.println("Title of the first course :-"+title);
	    
	    
	    
	    // Print title of first course
	    
        String title2=js2.get("courses[2].title");
	    
	    System.out.println("Title of the second course :-"+title2);
	    
	    
	    //price of first course
	    
        int price=js2.getInt("courses[0].price");
	    
	    System.out.println("Price of the first course :-"+price);
	    
	    //print the copies of second courses
	    
	    int copies=js2.getInt("courses[1].copies");
	    
	    System.out.println("Copies of the second course :-"+copies);
	    

	}

}
