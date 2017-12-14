<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.RequestDispatcher,java.sql.ResultSet,com.test.servlets.Posts,java.util.ArrayList;
"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <style>
        body{

        }


        * {
            box-sizing: border-box;
        }
        .row::after {
            content: "";
            clear: both;
            display: block;
            float: left;
        }
        [class*="col-"] {
            float: left;
            padding: 0.1px;
        }
        html {
            font-family: "Lucida Sans", sans-serif;
        }
        .header {
            background-color: #9933cc;
            color: #ffffff;
            padding: 4%;
            height:20%;            <!-- 20% will be header-->

        }
        .menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .menu li {
            padding: 8px;
            margin-bottom: 7px;
            background-color: #33b5e5;
            color: #ffffff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
        }
        .menu li:hover {
            background-color: #0099cc;
        }
        .aside {
            background-color: #33b5e5;
            padding: 15px;
            color: #ffffff;
            text-align: center;
            font-size: 14px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
            height: 80%;        <!-- 80% will be Sign up -->

        }

        /* For desktop: */
        .col-1 {width: 8.33%;}
        .col-2 {width: 16.66%;}
        .col-3 {width: 25%;}
        .col-4 {width: 33.33%;}
        .col-5 {width: 41.66%;}
        .col-6 {width: 50%;}
        .col-7 {width: 58.33%;}
        .col-8 {width: 66.66%;}
        .col-9 {width: 75%;}
        .col-10 {width: 83.33%;}
        .col-11 {width: 91.66%;}
        .col-12 {width: 100%;}

        @media only screen and (max-width: 768px) {
            /* For mobile phones: */
            [class*="col-"] {
                width: 100%;
            }
        }
		
		
		
		#post{
    background-color: #33b5e5;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
   
    cursor: pointer;
}
    </style>
</head>
<body>

    <div class="header">
     
     <div class="row">

      
      <div class="col-6">
        <h2 style="font-family: 'Josefin Sans', sans-serif;"> <img src="connect.png"> Somaiya Connect </h2>
    </div>

    <div class="col-5">

    </div>
    <div class="col-1">
        <p> Logout </p>
    </div>


</div>


</div>

<div class="row">




    <div class="col-2" >
      <div class="aside">
       <h1> Hello, <%=session.getAttribute("name") %></h1>
       <a href="search.jsp" style="text-decoration: none; color: white;"><h2> <img src="search.png"> &nbsp; Search </h2></a>
       <a href="timeline.jsp" style="text-decoration: none; color: red;"><h2> <img src="timeline.png">&nbsp; Timeline</h2></a>
       <a href="profile.jsp" style="text-decoration: none; color: white;"><h2> <img src="edit_profile.png">&nbsp; Edit Profile</h2></a>
       
       
       
       
   </div>
</div>


<div class="col-10">


<form action="PostServlet" >               <!--   PUt a servlet here -->
<textarea rows="5" cols="140" name="timeline_post" placeholder="whats in your mind...">
</textarea>
<input id="post" type="submit" value="post" >
</form>


<div>
<%
ArrayList<Posts> x = (ArrayList) session.getAttribute("arraylist");

for(int i = 0; i<x.size(); i++)
{
	out.println(x.get(i));
}

%>


</div>


</body>
</html>
