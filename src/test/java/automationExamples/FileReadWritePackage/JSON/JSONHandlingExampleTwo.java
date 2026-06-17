package automationExamples.FileReadWritePackage.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONHandlingExampleTwo {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();

		// Create POJO (Plain Old Java Objects) for reading the data
		@SuppressWarnings("unchecked")
		Employee emp = mapper.readValue(new File(System.getProperty("user.dir") + "\\testData\\sampleTest.json"),
				Employee.class);

		System.out.println("Name : " + emp.getName());
		System.out.println("age : " + emp.getAge());

		for (String skill : emp.getSkills()) {
			System.out.println("getting the data form skills list : " + skill);
		}

		System.out.println("address - city : " + emp.getAddress().getCity());
		System.out.println("address - country : " + emp.getAddress().getCountry());

		/* Write the data to JSON */
		emp.setManager("Test Manager");
		mapper.writeValue(new File(System.getProperty("user.dir") + "\\testData\\sampleTest.json"), emp); // recommended to use new JSON file for updates

	}

}
