package com.apitesting;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.files.Bodycode;

public class AddPlace2 {

	public static void main(String[] args) {
		
		
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
	String response=given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body(Bodycode.addPlace()).when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
	.header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	
	JsonPath js=new JsonPath(response);
	
	String placeid=js.get("place_id");

	System.out.println(placeid);
	}

}
