package com.rest.api.schema;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CheckSchemaTest {
	
	@Test
	public void Booking_Schema_Test() {
	
		given().log().all()
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "    \"firstname\" : \"Jimy\",\n"
					+ "    \"lastname\" : \"Browny\",\n"
					+ "    \"totalprice\" : 111,\n"
					+ "    \"depositpaid\" : true,\n"
					+ "    \"bookingdates\" : {\n"
					+ "        \"checkin\" : \"2022-01-06\",\n"
					+ "        \"checkout\" : \"2022-01-10\"\n"
					+ "    },\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\n"
					+ "}")
		.when().log().all()
		.post("https://restful-booker.herokuapp.com/booking")
		.then().log().all()
			.assertThat()
				.statusCode(200)
		.and()
				.body(matchesJsonSchemaInClasspath("BookingSchema.json"));
		
	}

}
