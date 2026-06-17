package automationExamples.FileReadWritePackage.CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadCSVFileExample {

	public static void main(String[] args) throws IOException {

		String filepath = System.getProperty("user.dir") + "\\testData\\sampletestcsv.csv";

		try (BufferedReader bufferread = new BufferedReader(new FileReader(filepath))) {
			
			String line;
			bufferread.readLine();
			
			while ((line = bufferread.readLine()) != null) {
				
				String[] data = line.split(",");
				System.out.println("Name : " +data[0]);
				System.out.println("age : " +data[1]);
				System.out.println("city : " +data[2]);
				System.out.println("+++++++++++++++++++");
			}

		}

	}
}
