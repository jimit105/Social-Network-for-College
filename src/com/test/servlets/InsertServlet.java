package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String query="insert into useracc(firstname,lastname,email,password, year,branch,division,interest) values(?,?,?,?,?,?,?,?)"; 
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			
			
			
			
			
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/socialnetworkdb");
			con = ds.getConnection();
			ps = con.prepareStatement(query);
			
			
			ps.setString(1, request.getParameter("firstname"));
			ps.setString(2, request.getParameter("lastname"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("password"));
			ps.setString(5, request.getParameter("year"));
			ps.setString(6, request.getParameter("branch"));
			ps.setString(7, request.getParameter("division"));
			ps.setString(8, request.getParameter("interest"));
			
			
			
			
			
			int retval = ps.executeUpdate();
			
			if(retval==1)
			{
				System.out.println("INSERTED INTO THE DATABASE");
			}
			
			
			/* RETRIEVING */
			
			
			
			}
			catch(NamingException e)
			{
			//	System.out.println("NAMING EXCEPTION");
				e.printStackTrace();
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
		
			finally
			{
				if(con!=null)
				{
					try{
					con.close();
					}
					catch(Exception e)
					{
						System.out.println("connection closed...");

					}
				}
			}
		
		response.sendRedirect("index.jsp");
			
		
		
		
	}

}
