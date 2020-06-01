package com.apitesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.files.Bodycode;
import com.files.ReUsableMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BanksData")
	public void addBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(Bodycode.addBook("jdejd","4453")).when().post("/Library/Addbook.php").then()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableMethod.rawToJson(response);
		
		String id=js.get("ID");
		
		System.out.println(id);
	}
	
	
}
