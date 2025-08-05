package DDT;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		FileReader fr=new FileReader(".\\src\\test\\resources\\commonData.json");
		JSONParser jp=new JSONParser();
		//convert physical file to java object
		Object javaobj = jp.parse(fr);
		//typecasting
		JSONObject obj=(JSONObject)javaobj;
		//reading data
		String ref = obj.get("Browser").toString();
		System.out.println(ref);
		
		
		

	}

}
