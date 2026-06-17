package automationExamples.FileReadWritePackage.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFileExample {

	public static void main(String[] args) throws IOException {

		String filepath = System.getProperty("user.dir") + "\\testData\\testcsv.csv";

		try (FileWriter filewrite = new FileWriter(filepath)) {
			System.out.println("Writing the data to csv file");

			filewrite.append("name,age,city\n");
			filewrite.append("test name four,55,Mumbai\n");
			filewrite.append("test name five,65,Hyderabad\n");

			System.out.println("Writing data to CSV");
			System.out.println("++++++++++++++++++++++++++++++ ");

		} catch (Exception e) {
			System.out.println("Unable to write the data to file");
		}

		try (BufferedReader bufferread = new BufferedReader(new FileReader(filepath))) {

			String line;
			bufferread.readLine();

			while ((line = bufferread.readLine()) != null) {

				String[] data = line.split(",");
				System.out.println("Name : " + data[0]);
				System.out.println("age : " + data[1]);
				System.out.println("city : " + data[2]);
				System.out.println("+++++++++++++++++++");
			}

		}

	}
}
