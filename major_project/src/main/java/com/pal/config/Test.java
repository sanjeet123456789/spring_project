package com.pal.config;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Test {
	public static void main(String [] args) {
		
			try {
				String file_name="/home/sanjeet/Downloads/sanjeet8.pdf";
				Document document= new Document();
				PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file_name));
				document.open();
				document.add(new Paragraph(" "));document.add(new Paragraph(" "));
				String days_in_week[]= {"monday","tuesday","webnesday","thursday","friday","saturday"};
				int period=8;
				String subject[]= {"Hindi","English","math","science"};
				String teacher[][]= {{"sanjeet","aman"},{"pankaj","saurab","rohit"},{"pradeep","rahul"},{"mohan","sohan"}};
				
				PreparedStatement ps=null;
				ResultSet rs=null;
				String query="select * from class_t";
				String user="pal";
				String pass="viwekkumarpal";
				String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
				String driver="com.mysql.jdbc.Driver";
				Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);
//				System.out.println("first comment");
				ps=myconn.prepareStatement(query);
//				System.out.println("second comment");
				rs=ps.executeQuery();
				
				
				
				while(rs.next()) {
					Paragraph para=new Paragraph("Time table for class"+rs.getString("class")+rs.getString("section"));
					para.setAlignment(Element.ALIGN_CENTER);
					
					document.add(para);
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					PdfPTable table=new PdfPTable(period+2);
					PdfPCell cell=new PdfPCell();
					cell.setFixedHeight(96f);
//					table.add(cell);
					
					for(int i=0;i<(days_in_week.length);i++) {
						table.addCell(days_in_week[i]);
						for(int j=0;j<period+1;j++) {
							if(j==4) {
							
//								ResultSet subject_name=getSubject(rs);
								table.addCell("recess");
//								table.addCell("this is"+i);
								
								
							}else {	
								int rand=new Random().nextInt(subject.length);
								int teach=new Random().nextInt(teacher[rand].length);
								
								table.addCell(subject[rand]+"("+teacher[rand][teach]+")");
								System.out.println(subject[rand]);
								System.out.println(teacher[rand][teach]);
								
							
							}
						}
					}
					
//					Statement statement=con
					
					table.setWidthPercentage(100);
					Statement statement=myconn.createStatement();
//					statement.executeUpdate("truncate check_subject");
//					statement.executeUpdate("truncate check_busy");
					document.add(table);
					document.newPage();
				}
				document.close();
				System.out.println("finish");
				
			myconn.close();	
			rs.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			
	}	
}
	
