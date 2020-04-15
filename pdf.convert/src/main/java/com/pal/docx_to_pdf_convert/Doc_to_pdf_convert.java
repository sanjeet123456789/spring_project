package com.pal.docx_to_pdf_convert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.docx4j.Docx4J;
import org.docx4j.convert.in.Doc;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class Doc_to_pdf_convert {
	public static void main(String[] args) throws Exception {
		System.out.println("hello");
		InputStream instream;
		OutputStream outsteam;
		String inputpath="/home/sanjeet/Downloads/sanjeet.doc";
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
		
		WordprocessingMLPackage mlpackage = Doc.convert(inputStream);
//		PrintStream originalStdout = System.out;
//		System.setOut(originalStdout);
		Docx4J.toPDF(mlpackage, outputStream);
		
		
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
