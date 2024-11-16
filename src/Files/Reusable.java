package Files;

import io.restassured.path.json.JsonPath;

public class Reusable {
	
	public static JsonPath rowToJson(String str) {
		
		JsonPath js=new JsonPath(str);
		
		return js;
	}

}
