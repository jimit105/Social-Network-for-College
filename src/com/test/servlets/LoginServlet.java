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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession ses;
	Student x;
	

	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String query;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println(request.getParameter("email_login")+" "+request.getParameter("password_login"));
		query = "select * from useracc where email = ? and password = ?";
		
try{
			
	
	
			
			
			
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/socialnetworkdb");
			con = ds.getConnection();
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, request.getParameter("email_login"));
			ps.setString(2, request.getParameter("password_login"));
			
			
				
			
									
			
			
			int val = ps.executeUpdate();
			
			System.out.println("Val : "+val);
			
			HttpSession s = request.getSession();

			/* HARDCODED FOR ADMIN */
			if(request.getParameter("email_login").equals("admin@somaiya.edu")&& request.getParameter("password_login").equals("admin"))
			{
				/* GETTING USERS */
				String getUserQuery = "select * from useracc";
				ps= con.prepareStatement(getUserQuery);
				
				ResultSet rs = ps.executeQuery();	
				
				s.setAttribute("resultset", rs);
				
				/* GETTING POSTS */
				String getPosts = "select * from posts";
				ps = con.prepareStatement(getPosts);
				
				rs = ps.executeQuery();
				
				s.setAttribute("allposts", rs);
				
				
				
				request.getRequestDispatcher("admin_users.jsp").forward(request, response);
			}
			
			
			
			
			
			
				if(val==1)
			{
				System.out.println("LOGGED IN");
				response.sendRedirect("timeline.jsp");
				
				
				 ses = request.getSession();
				ses.setAttribute("email", request.getParameter("email_login"));
				
				query = "select firstname,id from useracc where email = ?";
				
				ps = con.prepareStatement(query);
				ps.setString(1, request.getParameter("email_login"));
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					String name = rs.getString(1);
					System.out.println("name "+name);
					
					ses.setAttribute("name", name);
					
					String id = rs.getString(2);
					System.out.println("id "+id);
					ses.setAttribute("id", id);
					
				}
				
			//	System.out.println(ses.getAttribute("name"));
				
				
			}
			else 
			{
				response.sendRedirect("index.jsp");
				System.out.println("Sorry Please Try Again");
			}
			
			
			
			/* code for storing info in student class */
			
			query = "select * from useracc where id=?";
			ps = con.prepareStatement(query);
			
			ps.setString(1, (String) ses.getAttribute("id"));
			ResultSet r = ps.executeQuery();
			
			
			while(r.next())
			 x = new Student(r.getString(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getString(8));
			
			ses.setAttribute("student", x);
			System.out.println(x);
			
			
			

			/* RETRIEVING THE POSTS */
			HttpSession ses = request.getSession();
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


		
	}

}
