package automationExamples.FileReadWritePackage.excelpackage;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingToExcelExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream fileout = new FileOutputStream(System.getProperty("user.dir")+"\\testData\\writingtoexcel.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook();
				
		XSSFSheet sheet = book.createSheet("testsheet");
		
		XSSFRow headerrow = sheet.createRow(0);
		headerrow.createCell(0).setCellValue("EmpNo");
		headerrow.createCell(1).setCellValue("EmpName");
		headerrow.createCell(2).setCellValue("EmpDept");
		headerrow.createCell(3).setCellValue("EmpDesignation");
		headerrow.createCell(4).setCellValue("EmpJoiningDate");
		
		XSSFRow rowOne = sheet.createRow(1);
		rowOne.createCell(0).setCellValue(001);
		rowOne.createCell(1).setCellValue("Test One");
		rowOne.createCell(2).setCellValue("IT");
		rowOne.createCell(3).setCellValue("QA Engg");
		rowOne.createCell(4).setCellValue("01-03-2015");
		
		XSSFRow rowTwo = sheet.createRow(2);
		rowTwo.createCell(0).setCellValue(002);
		rowTwo.createCell(1).setCellValue("Test Two");
		rowTwo.createCell(2).setCellValue("Admin");
		rowTwo.createCell(3).setCellValue("Admin Lead");
		rowTwo.createCell(4).setCellValue("09-09-2019");
		
		
		XSSFRow rowThree = sheet.createRow(3);
		rowThree.createCell(0).setCellValue(003);
		rowThree.createCell(1).setCellValue("Test Three");
		rowThree.createCell(2).setCellValue("Infra");
		rowThree.createCell(3).setCellValue("Architect");
		rowThree.createCell(4).setCellValue("01-02-2025");
	
		book.write(fileout);
		
		book.close();
		fileout.close();

	}

}
