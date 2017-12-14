<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.test.servlets.Student"%>
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
    float: left;
      display: block;
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
</style>
</head>
<body>





  <div class="header">
     
     <div class="row">

      
      <div class="col-6" style="height:100%;">
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




  <div class="col-2" left >
    <div class="aside">
       
       <a href="search.jsp" style="text-decoration: none; color: white;"><h2> <img src="search.png"> &nbsp; Search </h2></a>
       <a href="timeline.jsp" style="text-decoration: none; color: white;"><h2> <img src="timeline.png">&nbsp; Timeline</h2></a>
       <a href="profile.jsp" style="color: red; text-decoration: none;"><h2> <img src="edit_profile.png">&nbsp; Edit Profile</h2></a>
       
       
       
       
   </div>
</div>
<%
Student s = (Student) session.getAttribute("student");
%>

<div class="col-4">

<form action="profile_enabled.jsp" method="post">           <!-- Put Servlet File Name Here -->
          <fieldset>
            <legend>Personal information:</legend>
            First name:<br>
            <input id="firstname" type="text" name="firstname" required="required" readonly value="<%=s.getFirstname() %> ">
            <br>

            Last name:<br>
            <input id="lastname" type="text" name="lastname" required="required"  value="<%=s.getLastname() %>"    readonly >
            <br>
            
            Email Address:<br>
            <input id="email" type="email" name="email" required="required" readonly value="<%=s.getEmail() %>"  >
            <br>

            Password:<br>
            <input id="password" type="password" name="password" required="required" readonly value="<%=s.getPassword() %>"  >
            <br>
            
            

                      
						<br>
 Year:<br>
            <select id="year" name="year" disabled   >
              <option value="FE"             <%if(s.getYear().equals("FE")){ out.println("selected");}%>
               >FE</option>
              <option value="SE"             <%if(s.getYear().equals("SE")){ out.println("selected");}%>
              >SE</option>
              <option value="TE"             <%if(s.getYear().equals("TE")){ out.println("selected");}%>
              >TE</option>
              <option value="BE"             <%if(s.getYear().equals("BE")){ out.println("selected");}%>
              >BE</option>
            </select>

            <br>



            Branch:<br>
            <select id="branch" name="branch" disabled  >
              <option value="COMP" <%if(s.getBranch().equals("COMP")){ out.println("selected");}%>
               >Computer</option>
              <option value="EXTC" <%if(s.getBranch().equals("EXTC")){ out.println("selected");}%>
>Electronics & Telecommunication</option>
              <option value="ETRX" <%if(s.getBranch().equals("ETRX")){ out.println("selected");}%>
              >Electronics</option>
              <option value="IT" <%if(s.getBranch().equals("IT")){ out.println("selected");}%>
              >Information Technology</option>
              <option value="MECH" <%if(s.getBranch().equals("MECH")){ out.println("selected");}%>
              >Mechanical</option>              
            </select>



            <br>
            Division:<br>
            <select id="division" name="division" disabled  >
              <option value="A"             <%if(s.getDivision().equals("A")){ out.println("selected");}%>
              >A</option>
              <option value="A"             <%if(s.getDivision().equals("B")){ out.println("selected");}%>
              >B</option>
            </select>
            
            
            

            
            <br>
            Interest:<br>
            <select id="interest" name="interest" disabled   >
            <option value="null"> </option>
              <option value="Arduino"                         <%if(s.getInterest().equals("Arduino")){ out.println("selected");}%>
              >Arduino</option>
              <option value="Android"                         <%if(s.getInterest().equals("Android")){ out.println("selected");}%>
              >Android</option>
             <option value="Competitive Programming"                         <%if(s.getInterest().equals("Competitive Programming")){ out.println("selected");}%>
             >Competitive Programming</option>
             <option value="Web Development"                         <%if(s.getInterest().equals("Web Development")){ out.println("selected");}%>
             >Web Development</option>
              
            </select>

                       


            <br><br>
            <input id="Submit" type="submit" value="Edit">
            

          </fieldset>
        </form>

</div>


<div class="col-3">
</div>




</div>



</body>
</html>
