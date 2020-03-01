package com.pal.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//setup connection variables
		String user="springstudent";
		String pass="springstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/spring_dropdown?useSSL=false";
		String driver="com.mysql.jdbc.Driver";
		//get connection to database
		try {
			PrintWriter out=response.getWriter();
			
			out.print("connectin to jdbc::"+jdbcUrl);
			Class.forName(driver);
			Connection myconn=DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("\n\n\n\n SUCCESS!!");
			myconn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
