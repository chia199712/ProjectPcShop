package shopTestPackage;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class shopServletTest
 */
@WebServlet("/shopServletTest")
public class shopServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DataSource ds;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try {
		      // Create a JNDI Initial context to be able to lookup the DataSource
		      InitialContext ctx = new InitialContext();
		      // Lookup the DataSource, which will be backed by a pool
		      //   that the application server provides.
		      ds = (DataSource)ctx.lookup("java:comp/env/jdbc/EmployeeDB");
		      System.out.println("connect DB success!");
		      if (ds == null)
		         throw new ServletException("Unknown DataSource 'jdbc/EmployeeDB'");
		  } catch (NamingException ex) {
		      ex.printStackTrace();
		  }
		
		  Connection conn = null;
	      Statement  stmt = null;
	      
	      List <Integer> itNoList = new  ArrayList <Integer> ();
	      List <String> itNameList =  new  ArrayList <String> () ;
	      List <String> itDetailList = new  ArrayList <String> ();
	      List <Integer> itPriceList = new  ArrayList <Integer> ();
	      
	      try {
	         	 
	         // Get a connection from the pool
	         conn = ds.getConnection();
	 
	         // Normal JBDC programming hereafter. Close the Connection to return it to the pool
	         stmt = conn.createStatement();
	         ResultSet rset = stmt.executeQuery("SELECT itNo, itName, itDetail, itPrice FROM shoptest");
	        
	         while(rset.next()) {       
	        	itNoList.add(rset.getInt("itNo"));
	        	itNameList.add(rset.getString("itName"));
	        	itDetailList.add(rset.getString("itDetail"));
	        	itPriceList.add(rset.getInt("itPrice"));
	         }
	         shopDB.setItNo((Integer[]) itNoList.toArray(new Integer[0]));
	         shopDB.setItName((String[]) itNameList.toArray(new String[0]));
	         shopDB.setItDetail((String[]) itDetailList.toArray(new String[0]));
	         shopDB.setItPrice((Integer[]) itPriceList.toArray(new Integer[0]));

	      } catch (SQLException ex) {
	         ex.printStackTrace();
	      } finally {
	   
	         try {
	            if (stmt != null) stmt.close();
	            if (conn != null) conn.close();  // return to pool
	         } catch (SQLException ex) {
	             ex.printStackTrace();
	         }
	      }
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  // Same as doGet()
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Retrieve the current session, or create a new session if no session exists.
	      HttpSession session = request.getSession(true);
	 
	      System.out.println(shopDB.size());
	      // For dispatching the next Page
	      String nextPage = "/shopTest.jsp";
	      ServletContext servletContext = getServletContext();
	      RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);
	      requestDispatcher.forward(request, response);
	}

}
