<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import= "com.connection.DatabaseConnect"%>

<%@page import="com.bean.MyBean"%>
<%@page import="com.dao.MyDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>	
	body{       background-image: url(), url(image2.jpg);
    		background-position: right bottom, left top;
                background-repeat: no-repeat, repeat;
                padding: 20px;
            }
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">I MENTOR</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
      </ul>
  <div class="container">                                      
  <div class="dropdown" align ="right" >
    <button class="btn btn-primary dropdown-toggle" type="button"  data-toggle="dropdown">LOG OUT
    

</button>
<ul class="dropdown-menu dropdown-menu-right"  >
      <li style="background-color:SlateBlue;"><a href="home.html"><h4>LOGOUT</h4></a></li>
    </ul>
    
  </div>
</div>
    </div>
  </div>
</nav>
<% 
  String studid=request.getParameter("sid");


%>
<form action="./Functionality">
<div align="center" class="container-fluid" width="100%" height="100%">
      <br><br><br><br>
<a href="Attendance.jsp?sid=<%=studid %>"><img src="images\attendance.jpg" height="80px" width="420px"></a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<a href="Assignment.jsp?sid=<%=studid %>"><img src="images\assignment.gif" height="80px" width="420px"></a><br><br><br>
<a href="ClassTest.jsp?sid=<%=studid %>"><img src="images\classtest.jpg" height="80px" width="420px"></a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
<a href="Workshop.jsp?sid=<%=studid %>"><img src="images\Workshop.jpg" height="80px" width="420px"></a><br><br>

<br><br>
<a href="final1.jsp?sid=<%=studid %>"><b><b><b><b><u>OVERALL PERFORMANCE</u></b></b></b></b></a>
</div>
</form>
</body>
</html>