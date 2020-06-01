package com.apitesting;

import org.testng.annotations.Test;

import com.files.Bodycode;

import io.restassured.path.json.JsonPath;

public class SumOfCourse {
	
	@Test
	public void sumCourse()
	{
		int sum=0;
		JsonPath js=new JsonPath(Bodycode.coursePrice());
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
	 for(int i=0;i<count;i++)
	{
		int price=js.getInt("courses["+i+"].price");
		
		int copies=js.getInt("courses["+i+"].copies");

        int purchaseAmt=price*copies;
        
        System.out.println(purchaseAmt);

        sum=sum+purchaseAmt;
        
	}
	 System.out.println(sum);
	 
	
	}
	
}
