package automationExamples.FileReadWritePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileWriteExample {

	public static void main(String[] args) throws IOException {
		
		String filepath = System.getProperty("user.dir")+"\\testData\\local.properties"; // "C://Users//UserName//TestAutomation//Eclipse-wprkspace//automationProject//local.properties"
		
		Properties prop = new Properties();
		
		/* We need to load the data before adding info to property file, else it will override the existing info*/
		try(FileInputStream fileInput = new FileInputStream(filepath)){
			prop.load(fileInput);
		}catch(IOException e) {
			System.out.println("File Not found");
		}
		
		// Appending the data
		prop.setProperty("username", "testuser");
		prop.setProperty("password", "testpwd");
		
		try(FileOutputStream fileout = new FileOutputStream(filepath)){ // saving the data
			prop.store(fileout, "Adding test data to property file");
		}
		
	}

}
