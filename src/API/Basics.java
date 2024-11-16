package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;//equalto

import org.testng.Assert;

import Files.Payload;
import Files.Reusable;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Given-All the input Details
		//When-Submit the API
		//Then-Validate the response
		
		//RestAssured.basePath="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace())
		.when().post("https://rahulshettyacademy.com/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		JsonPath js = Reusable.rowToJson(response);
		
		String place_id = js.getString("place_id");
		System.out.println(place_id);
		
		//Update request
		
		String actual="Gangakhed1";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+actual+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("https://rahulshettyacademy.com/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200);
		
		//Get data
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id",place_id)
		.when().get("https://rahulshettyacademy.com/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200);
		
		Assert.assertEquals(actual,"Gangakhed1" );
		

	}

}
