package com.rest.api.auth;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;


public class AuthAPI_GenerateToken{
	
	@Test
	public void generateToken() {
		
	RequestSpecification request =
	RestAssured.given()
		.formParam("client_id", "siliconyoga API Test")
		.formParam("client_secret", "940600f573b21eb14319d96a3efce9a7")
		.formParam("grant_type", "client_credentials");
	
	Response response = request.post("http://coop.apps.symfonycasts.com/token");
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
	
	String accessToken = response.jsonPath().getString("access_token");
	
	System.out.println(accessToken);
	
	RequestSpecification postRequest = 
			RestAssured.given()
			.auth()
			.oauth2(accessToken);
	
	Response responseCoop = postRequest.post("http://coop.apps.symfonycasts.com/api/2642/chickens-feed");
	System.out.println(responseCoop.getStatusCode());
			
	}
}
