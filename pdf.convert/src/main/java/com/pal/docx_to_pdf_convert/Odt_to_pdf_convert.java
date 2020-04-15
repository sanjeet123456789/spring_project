package com.pal.docx_to_pdf_convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

public class Odt_to_pdf_convert {
	public static void main(String[] args) throws Exception {
		System.out.println("hello");
		InputStream instream;
		OutputStream outsteam;
		String inputpath="/home/sanjeet/Downloads/sanjeet.odt";
		String outputpath="/home/sanjeet/Downloads/sanjeet.pdf";
		if(outputpath==null| outputpath=="") {
			outputpath=changeToPdf(inputpath);
		}
		//getting input file
		File inputFile=new File(inputpath);
		FileInputStream inputStream=new FileInputStream(inputFile);
		
		
		
		
		
		//getting output file
		File outputFile=new File(outputpath);//making directories and creating file
		outputFile.getParentFile().mkdirs();
		outputFile.createNewFile();
		FileOutputStream outputStream=new FileOutputStream(outputFile);
		System.out.println("converting");
		
		
		System.out.println("executing");
		
		OdfTextDocument document = OdfTextDocument.loadDocument(inputStream);

		PdfOptions pdf_options= PdfOptions.create();
		PdfConverter.getInstance().convert(document, outputStream, pdf_options);
		
		
		System.out.println("done converting");
		
			inputStream.close();
			outputStream.close();
			System.out.println("clossing stream");
		
		
		
	}
	private static String changeToPdf(String inputpath) {
		String finalname=inputpath;
		
		int dotIndexvalue=finalname.lastIndexOf(".");
		if(dotIndexvalue==-1) {
			finalname=finalname;
		}else {
			finalname=finalname.substring(0,dotIndexvalue);
			
		}
		String fullfinalname=finalname+".pdf";
		
		return fullfinalname;
	}
}
