package com.apitesting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.files.Bodycode;
import com.files.ReUsableMethod;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class DataProvider {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json")
		.body(Bodycode.addBook(isbn,aisle)).when().post("/Library/Addbook.php").then()
		.assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReUsableMethod.rawToJson(response);
		
		String id=js.get("ID");
		
		System.out.println(id);
	}
	
@org.testng.annotations.DataProvider(name="BooksData")
public Object[][] getData()
{
	return new Object[][] {{"hasj","27347"},{"fvlvj","2969"},{"jflj","86937"}};
}
	
	
	
}


