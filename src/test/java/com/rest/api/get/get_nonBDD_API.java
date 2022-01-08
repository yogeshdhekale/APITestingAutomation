package com.rest.api.get;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_nonBDD_API {
		
	@Test
	public void get_user_nonBDD() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2");
		Response resp = request.get("public-api/users");
		System.out.println(resp.getStatusCode());
		
	}
	
	@Test
	public void get_user_nonBDD_with_Param() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2");
		request.param("id", 54);
		request.param("gender", "female");
		
		Response resp = request.get("public-api/users");
		System.out.println(resp.body());
		System.out.println(resp.getStatusCode());
		System.out.println("************************");
		System.out.println(resp.prettyPrint());
		JsonPath pathJSON = resp.jsonPath();
		String email = pathJSON.getString("data.email");
		System.out.println(email);
	}
	
	@Test
	public void get_user_nonBDD_with_HashParam() {
		
		RestAssured.baseURI = "https://gorest.co.in/";
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2");
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", "53");
		param.put("gender", "female");
		request.queryParams(param);
		
		Response resp = request.get("public-api/users");
		System.out.println("************************");
		System.out.println(resp.body());
		System.out.println("************************");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		System.out.println("************************");
		System.out.println(resp.prettyPrint());
	}
}