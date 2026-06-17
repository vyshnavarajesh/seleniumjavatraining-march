package automationExamples.FileReadWritePackage.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteCSVExample {

	public static void main(String[] args) throws IOException {

		String filepath = System.getProperty("user.dir") + "\\testData\\samplereadwrite.csv";
		File file = new File(filepath);

		// file.mkdir(); // To create a Directory

		if (file.createNewFile()) { // To create New File
			System.out.println("New file created");
		} else {
			System.out.println("File already exists");
		}

		try (BufferedReader bufferread = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferread.readLine()) != null) {
				System.out.println("Reading the data from the file ");
				System.out.println(line);
			}

		}
		
		try (FileWriter filewrite = new FileWriter(file, true)) {
			System.out.println("Writing the data to file");
		
			filewrite.append("test name three,55,Mumbai\n");
			filewrite.append("test name four,65,Hyderabad\n");

		} catch (Exception e) {
			System.out.println("Unable to write the data to file");
		}

	}
}
