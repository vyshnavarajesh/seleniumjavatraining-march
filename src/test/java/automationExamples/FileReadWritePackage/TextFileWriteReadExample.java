package automationExamples.FileReadWritePackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriteReadExample {

	public static void main(String[] args) throws IOException {

		String filepath = System.getProperty("user.dir") + "\\testData\\sampleTextFile.txt";
		File file = new File(filepath);
		
		
		// file.mkdir(); // To create a Directory

		if (file.createNewFile()) { // To create New File
			System.out.println(" New file created");
		} else {
			System.out.println("File already exists");
		}

		try (FileWriter filewrite = new FileWriter(file, true);
				BufferedWriter bufferwrite = new BufferedWriter(filewrite)) {
			System.out.println("Writing the data to file");
			bufferwrite.write("This is a test file created for automation practice");
			bufferwrite.newLine();
			bufferwrite.write("This is a second line in the test file created for automation practice");

		} catch (Exception e) {
			System.out.println("Unable to write the data to file");
		}

		try (BufferedReader bufferread = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferread.readLine()) != null) {
				System.out.println("Reading the data from the file ");
				System.out.println(line);
			}

		}

	}
}
