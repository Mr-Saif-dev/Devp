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
<style>	
	body{       background-image: url(), url(image2.jpg);
    		background-position: right bottom, left top;
                background-repeat: no-repeat, repeat;
                padding: 20px;
            }
</style>
</head>
<body>
	<div>
  <form action="./Workshop">
   <table width="450" align ="center">
     <caption><b><b>WORKSHOP FORM</b></b><br><br></caption>
      
</table><br>
<br>
     <br>
     <br><br>
     
        <fieldset>
		<legend>WORKSHOP ---------------------- ATTENDED --------------- MAKING NOTES -------------------- REPORT ------------------------ MODEL </legend><br>
    WORKSHOP
   <select name="l1">
   <option> /</option>
   <option value="1">01</option>
   <option value="2">02</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
   <select name="a1">
   <option value="0">A</option>
   <option value="5">P</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="b1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="c1">
   <option value="5">Submitted</option>
   <option value="0">Not Submitted</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="d1">
   <option value="5">Submitted</option>
   <option value="0">Not Submitted</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
  

   <input type="text" name="e1" placeholder="Total"  value = <% int res = ( request.getAttribute("wtotal") == null) ? 0 : (Integer)request.getAttribute("wtotal") ; out.print(res);%>>
   <br><br>
   <% String s_id=request.getParameter("sid");
   		System.out.println(s_id);
   		%>
   		<input type="hidden" name="sid" value="<%=s_id%>">
 </fieldset>
 <br><br>
   <label>OVERALL %AGE ON WORKSHOP </label> &nbsp &nbsp <input type="number" name="f1" placeholder="over all % on workshop" value = <% double res2 = ( request.getAttribute("wperc") == null) ? 0 : (Double)request.getAttribute("wperc") ; out.print(res2); %>>%<br><br>
      <input type="submit" value="submit">  &nbsp &nbsp &nbsp
   
    </form>
 </div></body>
</html>