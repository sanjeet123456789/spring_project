package com.pal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("connecting our database"+jdbcUrl);
			Connection myConn=
					DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.print("connection sucessful");
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}
	}
}
