package API;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class courses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(Payload.courses());
		
		//Print No of courses returned by API
		int count = js.getInt("courses.size()");
		
		System.out.println(count);
		
		
		//Print Purchase Amount
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		
		//Print Title of the first course
		System.out.println(js.getString("courses[0].title"));
		
		
		//Print All course titles and their respective Prices
		for(int i=0; i<count; i++) {
			String title = js.getString("courses["+i+"].title");
			String price = js.getString("courses["+i+"].price");
			
			System.out.println(title+"="+price);
		}
		
		
		//Print no of copies sold by RPA Course
		
		for(int i=0; i<count; i++) {
			String RPA = js.getString("courses["+i+"].title");
			
			if(RPA.equalsIgnoreCase("RPA")) {
				String price = js.getString("courses["+i+"].copies");
				
				System.out.println(price);
			}
		}
		//Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		for(int i=0; i<count; i++) {
			int copies = js.getInt("courses["+i+"].copies");
			int price = js.getInt("courses["+i+"].price");
			
			  int mul = copies*price;
		//	  System.out.println(mul);
			 sum= sum+mul;
			
		}
		System.out.println(sum);

	}

}
