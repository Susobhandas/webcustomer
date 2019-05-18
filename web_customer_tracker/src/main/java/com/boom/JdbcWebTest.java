package com.boom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/abc")
public class JdbcWebTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String jdbcurl="jdbc:oracle:thin:@localhost:1521:orcledb";

PrintWriter out= response.getWriter();
		
		String user="system";
		String password="sdas";
		 String driver="oracle.jdbc.driver.OracleDriver";
		try {
			System.out.println("Connecting to Sql....");
			out.println("Connecting to Sql....");
			Class.forName(driver);
			System.out.println("forname pass....");
			out.println("forname pass....");
			Connection	con=DriverManager.getConnection(jdbcurl, user, password);
			System.out.println("connection is successful..in oracel..");
			out.println("Connecting to Sql....");
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
		}
		finally {
			
		}

	}
		

}
