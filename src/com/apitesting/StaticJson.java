package com.apitesting;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.files.Bodycode;
import com.files.ReUsableMethod;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

@Test
public class StaticJson {

	public void addBook() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(generateStringFromResource("E:\\MYTECHSTUDY\\REST_Udemy\\addbookInfo.json")).when().post("/Library/Addbook.php").then()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableMethod.rawToJson(response);
		
		String id=js.get("ID");
		
		System.out.println(id);
	}
	
	public static String generateStringFromResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
		

	} 
}
