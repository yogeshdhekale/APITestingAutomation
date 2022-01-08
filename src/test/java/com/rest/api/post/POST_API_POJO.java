package com.rest.api.post;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_API_POJO {
	
	@Test
	public void Create_User_POJO() {
		User user = new User("Jimy", "Smith", "male", "01-10-1987", "smith.Jimy8@hotmail.com", 
				"+9193456789", "active", "Berlin, Germany");
		
		ObjectMapper mapper = new ObjectMapper();
		String userJSON = null;
		try {
			userJSON = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(userJSON);
		
		RestAssured.baseURI = "https://gorest.co.in/";
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer cb5d7e66b3c6c8d780f3056c01fe509d97f2b67d37b04cc465e62e339577b7f2")
			.body(userJSON)
		.when().log().all()
			.post("public/v1/users/")
		.then().log().all()
			.assertThat().log().all()
				.contentType(ContentType.JSON)
			.and()
				.statusCode(201);
	}

}
