package com.pdfdemo;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdfdemos {
	public static void main(String[] args) {
		
		try {
			String file_name="d:\\sanjeet2.pdf";
			Document document= new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			Paragraph para=new Paragraph("Hello sanjeet from goose file");
			
			
			
			document.add(para);
			
			document.add(new Paragraph(" "));document.add(new Paragraph(" "));
			PdfPTable table=new PdfPTable(4);
			PdfPCell c1=new PdfPCell(new Phrase("Heading 1"));
			table.addCell(c1);
			
			c1=new PdfPCell(new Phrase("Heading 2"));
			table.addCell(c1);
			
			
			c1=new PdfPCell(new Phrase("Heading 3"));
			table.addCell(c1);
			table.setHeaderRows(1);
			
			table.addCell("1.0");
			table.addCell("1.1");
			table.addCell("1.2");
			table.addCell("2.1");
			table.addCell("2.2");
			table.addCell("2.3");
			
			document.add(table);
			
			//add image in 
			
			document.add(Image.getInstance("d:\\download.jpg"));
			String user="springstudent";
			String pass="springstudent";
			String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
			String driver="com.mysql.jdbc.Driver";
			Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);
			PreparedStatement ps=null;
			ResultSet rs=null;
			String query="select * from customer";
			ps=myconn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Paragraph para2=new Paragraph(rs.getString("first_name")+"    "+rs.getString("last_name"));
				document.add(para2);
				document.add(new Paragraph(" "));
			}
			
			document.newPage();
			document.add(new Paragraph(" hello this is page number 2"));
			document.close();
			System.out.println("finish");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
