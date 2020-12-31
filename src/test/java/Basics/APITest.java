package Basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.DataBuilder;
import io.restassured.RestAssured;

public class APITest {

	@Test
	public void basicApiTest() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(DataBuilder.getData()).when().post("/maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();

		System.out.println(response);
	}
}
