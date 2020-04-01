package analizator_finansowy;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class OdczytPDF {
   
	public static ArrayList<String> readPDF(File pdf) throws InvalidPasswordException, IOException {
	    try (PDDocument document = PDDocument.load(pdf)) {

	        document.getClass();

	        if (!document.isEncrypted()) {

	            PDFTextStripper tStripper = new PDFTextStripper();

	            String pdfFileInText = tStripper.getText(document);
	            

	            
	            String lines[] = pdfFileInText.split("\\r?\\n");
	            ArrayList<String> pdfLines = new ArrayList<>();
	           
	            for (String line : lines) {
	               //System.out.println(line);
	                pdfLines.add(line);
	               
	            }
	            return pdfLines;
	        }

	    }
	    return null;
	}
}