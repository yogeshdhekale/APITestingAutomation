package com.rest.api.put;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.User;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUT_API {
	
	@Test
	public void updateUserPUT() {
		
	//First create a user with POST request
		
	User user1 = new User("Johny", "Root", "male", "1986-06-04",
			"johny.commins@yahoo.com", "+49123456", "active", "Munich, Germany");
	
	//Convert this POJO to JSON using JACKSON API -- ObjectMapper

	ObjectMapper mapper1 = new ObjectMapper();
	String user1json = null;
	
	try {
		user1json = mapper1.writeValueAsString(user1);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	System.out.println("POST Call JSON format is " + user1json);
	
	//Write a Post Call
	
	RestAssured.baseURI = "https://gorest.co.in/";
	
	int userID = given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
		.body(user1json)
	.when().log().all()
		.post("public/v1/users/")
	.then().log().all()
		.assertThat().log().all()
			.statusCode(201)
	.and()
			.extract().path("data.id");
	System.out.println(userID);
	
	//Write a PUT call
	
	user1.setStatus("inactive");
	String updateUserJSON = null;
	
	try {
		updateUserJSON = mapper1.writeValueAsString(user1);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
		.body(updateUserJSON)
	.when().log().all()
		.put("public-api/users/" + userID)
	.then().log().all()
		.assertThat().log().all()
			.statusCode(200);
	
	RestAssured.baseURI = "https://gorest.co.in/";
	
	given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
	.when().log().all()
		.get("public-api/users/" + userID)
	.then().log().all()
		.assertThat().log().all()
			.statusCode(200)
			.body("data.id", equalTo(userID))
			.body("data.status", equalTo(user1.getStatus()));

	}
	
}