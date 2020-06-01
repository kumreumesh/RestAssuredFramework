package com.apitesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.files.Bodycode;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UpdatePlace {

	public static void main(String[] args) {
		
		
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	// Add Place
	String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body(Bodycode.addPlace()).when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
	.header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	
	JsonPath js=new JsonPath(response);
	
	String placeid=js.get("place_id");

	System.out.println(placeid);
	
	

	// Update place	
	
	given().log().all().queryParam("key","qaclick123").header("Content_Type","application/json")
	.body("{\r\n" + 
			"\"place_id\":\""+placeid+"\",\r\n" + 
			"\"address\":\"70 Summer walk, USA\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}\r\n" + 
			"").when().put("/maps/api/place/update/json").then()
	.log().all().assertThat().statusCode(200)
	.body("msg",equalTo("Address successfully updated"));



	}
	

}
