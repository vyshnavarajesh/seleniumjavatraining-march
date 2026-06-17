package automationExamples.FileReadWritePackage;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReadExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String filepath = System.getProperty("user.dir") + "\\testData\\samplepdf.pdf";
		File file = new File(filepath);

		PDDocument pdfdoc = PDDocument.load(file);
		
		PDFTextStripper pdfread = new PDFTextStripper();
		
		/* use this if you have to read between specific pages : example to read data from 4 to 5 pages */
//		pdfread.setStartPage(4); 
//		pdfread.setEndPage(5);
		
		String text = pdfread.getText(pdfdoc);
		
	
		
		System.out.println(text);
	}

}
