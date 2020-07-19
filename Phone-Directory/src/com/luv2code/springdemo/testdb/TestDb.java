package com.luv2code.springdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="springstudent";
		String password="springstudent";
		
		String jdbcurl="jdbc:mysql://localhost:3306/phone_directory?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out=response.getWriter();
			
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(jdbcurl, user, password);
			
			out.print("Connected");
			
			conn.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ServletException(e); 
		}
	}


}
