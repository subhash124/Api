package API;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Dnyanamicjson {

	@Test(dataProvider = "data")
	public void dnyanamic(String str1, String str2) {
		
		//RestAssured.basePath=("http://216.10.245.166");
		
		//given().header("Content-Type","application/json").body(Payload.Adddnyanamic("gsfd", "123")).
		
		//dataProviser
		given().header("Content-Type","application/json").body(Payload.Adddnyanamic(str1, str2)).
		when().post("http://216.10.245.166/Library/Addbook.php")
		.then().log().all();
		
	}
	
	@DataProvider(name="data")
	
	public Object[][] adddata() {
		
		return new Object[][] {{"asd","123"},{"zxc","456"},{"bcv","236"}};
	}
}
