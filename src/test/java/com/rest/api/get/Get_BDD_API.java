package com.rest.api.get;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Get_BDD_API {
	
	@Test
	public void getAPITest() {
		
		given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2016/circuits")
		.then().log().all()
		.assertThat().log().all()
		.body("MRData.CircuitTable.Circuit.circuitId", hasSize(20));
		
	}
	
	@Test
	public void getAPIStatus() {
		
		Response response =
		
		given().log().all()
		.when().log().all()
		.get("http://ergast.com/api/f1/2011/5/laps/1");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void getAPITest2() {
		
		RestAssured.baseURI = "http://ergast.com/";
		given().log().all()
		.when().log().all()
			.get("api/f1/2016/circuits")
		.then().log().all()
		.assertThat()
			.statusCode(200)
		.and().log().all()
			.contentType(ContentType.XML)
		.and().log().all()
			.header("Content-Length", "6192");
	}
	

}
