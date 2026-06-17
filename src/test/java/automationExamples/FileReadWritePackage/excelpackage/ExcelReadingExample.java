package automationExamples.FileReadWritePackage.excelpackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\testDataExcel.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<=rowCount ; i++) {
			
				XSSFRow rowValue = sheet.getRow(i); // this will get entire row info
				
				if(rowValue == null)
					continue;
				
			for(int j=0; j<columnCount ; j++) {
				
					XSSFCell cellValue = rowValue.getCell(j);
					
					System.out.print(cellValue.toString() + " | ");
			}
			System.out.println("");
		}

	}

}
