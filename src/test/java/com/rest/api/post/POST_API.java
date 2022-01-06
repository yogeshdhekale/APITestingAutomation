package com.rest.api.post;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class POST_API {
	
	
	@Test
	public void TokenPostAPI() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		given().log().all()
			.contentType(ContentType.JSON)
			.body("{\"username\" : \"admin\", \"password\" : \"password123\"}")
		.when().log().all()
			.post("/auth")
		.then().log().all()
			.assertThat()
			.statusCode(200);
	}
	
	@Test
	public void TokenFilePOSTAPI() {
	
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		String TokenID = given().log().all()
		.contentType(ContentType.JSON)
		.body(new File("/Users/yogeshdhekale/eclipse-workspace/APIAutomationBDD/"
				+ "src/test/java/DataFiles/credentials.json"))
		.when().log().all()
			.post("/auth")
			.then().log().all()
				.extract().path("token");
		
		System.out.println("************************************************");
		System.out.println("Token ID is " + TokenID);
		System.out.println("************************************************");
		
	}
	
	@Test
	public void CreatePOSTUser() {
		RestAssured.baseURI = "https://gorest.co.in/";
		given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
		.body("{\n"
				+ "    \"name\": \"Abcd Wxyz\",\n"
				+ "    \"email\": \"abcd.wxyz5@hotmail.com\",\n"
				+ "    \"gender\": \"male\",\n"
				+ "    \"status\": \"active\"\n"
				+ "}")
		.when().log().all()
		.post("public/v1/users/")
		.then().log().all()
			.assertThat()
				.statusCode(201)
				.body("meta.gender", equalTo("male"));
//				.body("meta.gender", equalTo("male"))
//			.and()
//				.body("meta.status", equalTo("active"));
	}
	

}
