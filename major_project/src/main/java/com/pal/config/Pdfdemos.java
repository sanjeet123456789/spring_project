package com.pal.config;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.simpleparser.CellWrapper;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pal.entity.Class_t;



public class Pdfdemos {
		
//	private static String USER_PASSWORD = "password";
//	private static String OWNER_PASSWORD = "pal";
	//				writer.setEncryption(USER_PASSWORD.getBytes(),
//			                OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING |PdfWriter.ALLOW_ASSEMBLY|
//			                PdfWriter.ALLOW_COPY|
//			                PdfWriter.ALLOW_DEGRADED_PRINTING|
//			                PdfWriter.ALLOW_FILL_IN|
//			                PdfWriter.ALLOW_MODIFY_ANNOTATIONS|
//			                PdfWriter.ALLOW_MODIFY_CONTENTS|
//			                PdfWriter.ALLOW_SCREENREADERS,
//			                PdfWriter.ENCRYPTION_AES_128);
//	private SessionFactory sessionFactory;
	
		public PdfWriter generate_pdf() {
			try {
				String file_name="/home/sanjeet/Downloads/sanjeet8.pdf";
				Document document= new Document();
				PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file_name));
				document.open();
				document.add(new Paragraph(" "));document.add(new Paragraph(" "));
				String days_in_week[]= {"monday","tuesday","webnesday","thursday","friday","saturday"};
				int period=8;
				
				PreparedStatement ps=null;
				ResultSet rs=null;
				String query="select * from class_t";
				String user="pal";
				String pass="viwekkumarpal";
				String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
				String driver="com.mysql.jdbc.Driver";
				Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);
				System.out.println("first comment");
				ps=myconn.prepareStatement(query);
				System.out.println("second comment");
				rs=ps.executeQuery();
				
				
				
				while(rs.next()) {
					Paragraph para=new Paragraph("Time table for class"+rs.getString("class")+rs.getString("section"));
					para.setAlignment(Element.ALIGN_CENTER);
					
					document.add(para);
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					PdfPTable table=new PdfPTable(period+2);
					
					for(int i=0;i<(days_in_week.length);i++) {
						table.addCell(days_in_week[i]);
						for(int j=0;j<period+1;j++) {
							if(j==4) {
							
//								ResultSet subject_name=getSubject(rs);
								table.addCell("recess");
//								table.addCell("this is"+j);
								
								
							}else {	
								
								boolean flag = false;
								
								while(flag==false) {
									System.out.println("third comment");
								String query_subject="select * from subject_t where s_class= "+rs.getString("class")+ " ORDER BY RAND() LIMIT 1" ;
								PreparedStatement	p_subject_t=myconn.prepareStatement(query_subject);
								System.out.println("fourth comment");
								ResultSet r_subject_t=p_subject_t.executeQuery();
								r_subject_t.first();
								
								
//								 creating noof class left in a week
								if(r_subject_t.getInt(3)>=1) {
								
								
								String argument1=" \""+rs.getString(2)+rs.getString(3)+"\" ";
								String argument2= " \""+r_subject_t.getString(2)+"\" ";
//								System.out.println(argument2);
								String query_teacher="select * from Check_subject where  class_section = "+argument1+"and subject_name= "+argument2+" ORDER BY RAND() LIMIT 1" ;
								PreparedStatement	p_teachers_t=myconn.prepareStatement(query_teacher);
								System.out.println("fifth comment");
								ResultSet r_teacher_t=p_teachers_t.executeQuery(); 
								r_teacher_t.first();
								
								
									
									
									if(r_teacher_t.first()==true) {
										System.out.println(" teacher found");
										
										String check_busy_teacher_t="select * from Check_busy where teachers_id="+"\""+r_teacher_t.getInt(1)+"\" "+"and day="+"\""+days_in_week[i]+"\" ";
										PreparedStatement check_busy_teacher_prepared_statement=myconn.prepareStatement(check_busy_teacher_t);
										System.out.println("sixth comment");
										ResultSet check_teacher_busy_t=check_busy_teacher_prepared_statement.executeQuery();
										check_teacher_busy_t.first();
										System.out.println(check_teacher_busy_t.first());
										if(check_teacher_busy_t.first()==false) {
											System.out.println("not  busy");
											//set  teacher in check subject
//											insert into check_subject (class_section,subject_name,teachers_id) values("48B","Mathe",1);
											
											
											
											String set_check_busy="insert into Check_busy (day,period,teachers_id) values ("+"\""+days_in_week[i]+"\" "+","+j+","+"\""+r_teacher_t.getInt(4)+"\" "+")";
											PreparedStatement prepared_set_chek_busy=myconn.prepareStatement(set_check_busy);
											prepared_set_chek_busy.execute();
											
											
											//add cell in table
											table.addCell("this is "+r_subject_t.getString(2));
											
											
										}else {
											System.out.println(" busy");
											break;
											
											
										}
										
										
										
										
										
										
										
									}else {
										System.out.println("teacher not fount");
										
										//goring to subejct_t
										String select_subject_t="select * from subject_t where subject_name= "+"\""+r_subject_t.getString(2)+"\" "+"and s_class="+" \""+rs.getString(2)+"\" ";
										PreparedStatement select_subject_prepared_statement=myconn.prepareStatement(select_subject_t);
										ResultSet r_select_subject_t=select_subject_prepared_statement.executeQuery();
										r_select_subject_t.first();
//										System.out.println(r_select_subject_t.getInt(1));
										
										
										//goring to subject_and teacher_t
										
										String select_subject_teacher_t="select * from teacher_subject_t where subject_id= "+"\""+r_select_subject_t.getInt(1)+"\" ";
										PreparedStatement select_subject_teacher_prepared_statement=myconn.prepareStatement(select_subject_teacher_t);
										ResultSet r_select_subject_teacher_t=select_subject_teacher_prepared_statement.executeQuery();
										
										r_select_subject_teacher_t.first();
//										System.out.println(r_select_subject_teacher_t.getInt(1));
										
										
										//going to teachers_t
										String select_teacher_t="select * from teachers_t where id= "+"\""+r_select_subject_teacher_t.getInt(1)+"\" ";
										PreparedStatement select_teacher_prepared_statement=myconn.prepareStatement(select_teacher_t);
										ResultSet r_select_teacher_t=select_teacher_prepared_statement.executeQuery();
										
										r_select_teacher_t.first();
										System.out.println(r_select_teacher_t.getInt(1));
										
										
										//check she is busy or not 
										
										String check_busy_teacher_t="select * from Check_busy where teachers_id="+"\""+r_select_teacher_t.getInt(1)+"\" "+"and day="+"\""+days_in_week[i]+"\" ";
										PreparedStatement check_busy_teacher_prepared_statement=myconn.prepareStatement(check_busy_teacher_t);
										
										ResultSet check_teacher_busy_t=check_busy_teacher_prepared_statement.executeQuery();
										check_teacher_busy_t.first();
										
										if(check_teacher_busy_t.first()==false) {
											System.out.println("not busy");
											//set  teacher in check subject
//											insert into check_subject (class_section,subject_name,teachers_id) values("48B","Mathe",1);
											String set_check_subject="insert into Check_subject (class_section,subject_name,teachers_id) values( "+"\""+rs.getString(2)+rs.getString(3)+"\" "+","+"\""+r_select_subject_t.getInt(1)+"\" "+","+"\""+r_select_teacher_t.getInt(1)+"\" "+")";
											PreparedStatement prepared_set_check_subject=myconn.prepareStatement(set_check_subject);
											prepared_set_check_subject.execute();
											
											
											String set_check_busy="insert into Check_busy (day,period,teachers_id) values ("+"\""+days_in_week[i]+"\" "+","+j+","+"\""+r_select_teacher_t.getInt(1)+"\" "+")";
											PreparedStatement prepared_set_chek_busy=myconn.prepareStatement(set_check_busy);
											prepared_set_chek_busy.execute();
											
											
											//getting subject from table
											table.addCell("this is "+r_subject_t.getString(2));
											
											
										}else {
											System.out.println(" busy");
											break;
											
											
										}
//										System.out.println(check_teacher_busy_t.getString(2));
										
										
										
										
										
									}
									
									
//									System.out.println(r_teacher_t.getInt(4));
									
									
									
									
									
									

									
									
									System.out.println();
									
									
									

									
									

									
									
									
//									table.addCell("this is "+j);
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
									
								}else {
									break;
								}
								
								
								
								
								
								
								break;
								}//end og flag while
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
			}finally {
			
			}
			return null;
			
			
		}
		
}
