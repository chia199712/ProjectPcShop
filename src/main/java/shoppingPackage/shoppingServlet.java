package shoppingPackage;

import java.io.*;
import java.sql.Blob;
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
@WebServlet("/shoppingServlet")
public class shoppingServlet extends HttpServlet {
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
	      
	      List <Integer> pro_noList = new  ArrayList <Integer> ();
	      List <String> pro_nameList =  new  ArrayList <String> () ;
	      List <Integer> pro_priceList = new  ArrayList <Integer> ();
	      List <Integer> pro_amountList = new  ArrayList <Integer> ();
	      List <String> pro_infoList = new  ArrayList <String> ();
	      List <String> pro_imageList = new  ArrayList <String> ();
	      
	      try {
	         	 
	         // Get a connection from the pool
	         conn = ds.getConnection();
	 
	         // Normal JBDC programming hereafter. Close the Connection to return it to the pool
	         stmt = conn.createStatement();
	         ResultSet rset = stmt.executeQuery("SELECT pro_no, pro_name, pro_price, pro_amount, pro_info, pro_image FROM pro_item");
	        
	         while(rset.next()) {       
	        	 pro_noList.add(rset.getInt("pro_no"));
	        	 pro_nameList.add(rset.getString("pro_name"));
	        	 pro_priceList.add(rset.getInt("pro_price"));
	        	 pro_amountList.add(rset.getInt("pro_amount"));
	        	 pro_infoList.add(rset.getString("pro_info"));
	        	 pro_imageList.add(rset.getString("pro_image"));
	         }
	         shoppingDB.setPro_no((Integer[]) pro_noList.toArray(new Integer[0]));
	         shoppingDB.setPro_name((String[]) pro_nameList.toArray(new String[0]));
	         shoppingDB.setPro_price((Integer[]) pro_priceList.toArray(new Integer[0]));
	         shoppingDB.setPro_amount((Integer[])  pro_amountList.toArray(new Integer[0]));
	         shoppingDB.setPro_info((String[]) pro_infoList.toArray(new String[0]));
	         shoppingDB.setPro_image((String[]) pro_imageList.toArray(new String[0]));
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);  // Same as doGet()
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Retrieve the current session, or create a new session if no session exists.
	      HttpSession session = request.getSession(true);
	 
	      System.out.println(shoppingDB.size());
	      // For dispatching the next Page
	      String nextPage = "/jsp/index.jsp";
	      ServletContext servletContext = getServletContext();
	      RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(nextPage);
	      requestDispatcher.forward(request, response);
	      
	      int itemPageIndex = Integer.parseInt(request.getParameter("index"));
	      System.out.println(itemPageIndex);
	      shoppingDB.setItemPageIndex(itemPageIndex);
	}

}
