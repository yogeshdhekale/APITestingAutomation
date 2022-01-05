package com.rest.api.auth;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AuthAPIs {
	
	@Test
	public void basicAuth_test_api() {
		
		given().log().all()
		.auth()
		.preemptive()
		.basic("admin", "admin")
		.when().log().all()
			.get("http://the-internet.herokuapp.com/basic_auth/")
		.then().log().all()
			.assertThat()
				.statusCode(200);
		
	}
	
	@Test
	public void oAuth2_API() {
		
		given().log().all()
		.auth()
			.oauth2("Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
		.when().log().all()
			.get("https://gorest.co.in/public-api/users/?name=Wxyz")
		.then().log().all()
			.assertThat()
				.statusCode(200);
	}
	
	@Test
	public void oAuth2_Header_API() {
		RestAssured.baseURI = "https://gorest.co.in/";
		
		given().log().all()
			.contentType("application/json")
			.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
		.when().log().all()
			.get("public-api/users/?name=Wxyz")
		.then().log().all()
			.assertThat()
				.statusCode(200);
			
	}

}
