package com.pal.docx_to_pdf_convert;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PPtx_to_pdf_convert {
	public static void main(String[] args) throws IOException, DocumentException {
		System.out.println("hello");
		InputStream instream;
		OutputStream outsteam;
		String inputpath="/home/sanjeet/Downloads/17bca1237-17bca1233.docx";
		String outputpath="/home/sanjeet/Downloads/17bca1237-17bca1232.pdf";
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
		
		double zoom = 2; // magnify it by 2 as typical slides are low res
	    AffineTransform at = new AffineTransform();
	    at.setToScale(zoom, zoom);
	    
		XSLFSlide[] slides;
		XMLSlideShow ppt = new XMLSlideShow(inputStream);
		Dimension dimension = ppt.getPageSize();
		slides = ppt.getSlides();
		int slides_length=slides.length;
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, outputStream);
		document.open();
		for (int i = 0; i < slides_length; i++) {

			BufferedImage bufferedImg = new BufferedImage((int)Math.ceil(dimension.width*zoom), (int)Math.ceil(dimension.height*zoom), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = bufferedImg.createGraphics();
			graphics.setTransform(at);
			//clear the drawing area
			graphics.setPaint(slides[i].getBackground().getFillColor());
			graphics.fill(new Rectangle2D.Float(0, 0, dimension.width, dimension.height));
			try{
				slides[i].draw(graphics);
			} catch(Exception e){
				
			}
			
			Image image = Image.getInstance(bufferedImg, null);
			document.setPageSize(new Rectangle(image.getScaledWidth(), image.getScaledHeight()));
			document.newPage();
			image.setAbsolutePosition(0, 0);
			document.add(image);
		}
		
		System.out.println("done converting");
		
			inputStream.close();
			outputStream.close();
			document.close();
			writer.close();
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
