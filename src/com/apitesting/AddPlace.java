package com.apitesting;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class AddPlace {

	public static void main(String[] args) {
		
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body("{\r\n" + 
			"  \"location\": {\r\n" + 
			"    \"lat\": -38.383494,\r\n" + 
			"    \"lng\": 33.427362\r\n" + 
			"  },\r\n" + 
			"  \"accuracy\": 50,\r\n" + 
			"  \"name\": \"Umesh Kumre\",\r\n" + 
			"  \"phone_number\": \"(+91) 8806406400\",\r\n" + 
			"  \"address\": \"Near reliance fresh,Kharadi,Pune\",\r\n" + 
			"  \"types\": [\r\n" + 
			"    \"ABC park\",\r\n" + 
			"    \"shop no 123\"\r\n" + 
			"  ],\r\n" + 
			"  \"website\": \"https://rahulshettyacademy.com\",\r\n" + 
			"  \"language\": \"French-IN\"\r\n" + 
			"}\r\n" + 
			"").when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200);

	}

}
