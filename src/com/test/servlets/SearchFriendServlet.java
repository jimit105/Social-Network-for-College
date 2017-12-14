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
 * Servlet implementation class SearchFriendServlet
 */
@WebServlet("/SearchFriendServlet")
public class SearchFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int flag;
	
	Context ctx;
	DataSource ds;
	Connection con;
	PreparedStatement ps;
	String query="select * from useracc where year=? INTERSECT select * from useracc  where interest=?";
    String query1 = "select * from useracc where year=?";
    String query2 = "select * from useracc where interest=?";
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFriendServlet() {
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
			
		flag = 0	;
		if(request.getParameter("year").equals("blank"))
		{
			flag = 1;
			query = "";
			query = query2;
		}
		if(request.getParameter("interest").equals("blank"))
		{
			flag = 2;
			query= "";
			query = query1;
		}
		
		
		
		
try{
			
			
			
			
			
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("jdbc/socialnetworkdb");
			con = ds.getConnection();
			ps = con.prepareStatement(query);
			
			System.out.println("flag "+flag);
			
			
			if(flag == 0) {
			ps.setString(1, request.getParameter("year"));
			ps.setString(2, request.getParameter("interest"));
			}
			if(flag == 1)
			{
				ps.setString(1, request.getParameter("interest"));
			}
			
			if(flag == 2)
			{
				ps.setString(1, request.getParameter("year"));
			}
			
		
			
			
			ResultSet rs = ps.executeQuery();
			ArrayList<Friends> friends = new ArrayList();
			
			
			while(rs.next())
			{
				friends.add(new Friends(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
				
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
			}
			
			System.out.println("LIST OF FRIENDS :"+ friends);
			
			HttpSession ses = request.getSession();
			ses.setAttribute("allfriends", friends);
			
			
            response.sendRedirect("search.jsp");			
			
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
				
				
				query="select * from useracc where year=? INTERSECT select * from useracc  where interest=?";
			    query1 = "select * from useracc where year=?";
			    query2 = "select * from useracc where interest=?";
			}

		
		
		
	}

}
