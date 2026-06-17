package automationExamples.FileReadWritePackage.JSON;

import java.util.Map;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHandlingExample {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();
		
		@SuppressWarnings("unchecked")
		Map<String, String> data = mapper.readValue(new File(System.getProperty("user.dir")+"\\testData\\testdata.json"), Map.class);
		
		String uname = data.get("username");
		String pwd = data.get("password");
		
		System.out.println(uname + " | " + pwd);
	}

}


//JSON - Java script object notation
/* 
{
"name": "Alex",
"age": 28,
"isDeveloper": true,
"skills": ["JavaScript", "Python"],
"address": {
  "city": "Bengaluru",
  "country": "India"
},
"manager": null
}

*/