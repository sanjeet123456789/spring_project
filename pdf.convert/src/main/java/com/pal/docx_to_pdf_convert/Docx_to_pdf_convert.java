package com.pal.docx_to_pdf_convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Docx_to_pdf_convert {
	

	public static void main(String[] args) throws IOException {
		System.out.println("hello");
		InputStream instream;
		OutputStream outsteam;
		String inputpath="/home/sanjeet/Downloads/sanjeet.docx";
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
		XWPFDocument document=new XWPFDocument(inputStream);
		PdfOptions option=PdfOptions.create();
		PdfConverter.getInstance().convert(document, outputStream, option);
		
		
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
