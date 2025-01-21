package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String em = request.getParameter("email"); 
		  String ps = request.getParameter("pass");
	        PrintWriter out = response.getWriter();
			try {	
	            	 Class.forName("com.mysql.cj.jdbc.Driver");
            	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	               	
		    Statement stmt= con.createStatement();
	           	ResultSet rs= stmt.executeQuery("select email,pass from register where email='"+em+"' AND pass='"+ps+"'");
	            	if(rs.next()) {
	            		String s = rs.getString(1);
	            		String p = rs.getString(2);
	            		if(s.equals(em) && p.equals(ps)) {
	            			out.print("Success");
	            		}
	            	}else {
	            		out.print("Invalid Credentials");
	            	}
	            	 
	             }catch(Exception e) {
	            	 e.printStackTrace();
	             }
	}

}
