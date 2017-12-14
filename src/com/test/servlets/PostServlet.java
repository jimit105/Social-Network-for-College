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
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession ses;
	
	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String query="insert into posts(content,sid) values(?,?)";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try{
			
			ses = request.getSession();
			
			
			
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/socialnetworkdb");
			con = ds.getConnection();
			ps = con.prepareStatement(query);
			
			
			System.out.println("TESTING : "+request.getParameter("timeline_post"));
			System.out.println("TESTING : "+ses.getAttribute("id"));
			
			
			ps.setString(1, request.getParameter("timeline_post") );
		    ps.setString(2, (String) ses.getAttribute("id"));
			
			
			int retval = ps.executeUpdate();
			
			

			/* RETRIEVING THE POSTS  */
			ArrayList<Posts> al = new ArrayList();

			
			 query="select content,pid from posts";
				ps = con.prepareStatement(query);

				ResultSet rs = ps.executeQuery();

				
				while(rs.next())
				{
					al.add(new Posts(rs.getString(1),rs.getInt(2)));
				}
				
				System.out.println("All the Posts : "+al);
				ses.setAttribute("arraylist", al);				
				System.out.println("All the Posts : "+al);


			
						
		
			if(retval==1)
			{	
				System.out.println("POST INSERTED INTO THE DATABASE");
				response.sendRedirect("timeline.jsp");
			}else
			{
			
				response.sendRedirect("timeline.jsp");
			}
			
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
			query="insert into posts(content,sid) values(?,?)";


		}
	
		
		
	}

}
