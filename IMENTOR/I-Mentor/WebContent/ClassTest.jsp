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
  <form action="./ClassTest" >
   <table width="450" align ="center">
     <caption><b><b>CLASS TEST FORM</b></b><br><br></caption>
     <br>
     <br>
     <br>
     <br>
     <br>
     <br> 
</table>
<br>
     <br>
     <br>
        <fieldset>
   <legend> CLASS TEST NO. ---------------------- GROUP A --------------- GROUP B -------------------- GROUP C-------------------------------------------</legend><br>
   CLASS TEST
   <select name="m1">
   <option> /</option>
   <option value="1">01</option>
   <option value="2">02</option>
   <option value="3">03</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="x1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
   <select name="y1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="z1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    &nbsp &nbsp &nbsp &nbsp &nbsp
   <input type="text" name="u1" placeholder="Total" value = <% int res = ( request.getAttribute("ctotal") == null) ? 0 : (Integer)request.getAttribute("ctotal") ; out.print(res);%>>
   <br><br>
   <% String s_id=request.getParameter("sid");
   		System.out.println(s_id);
   		%>
   		<input type="hidden" name="sid" value="<%=s_id%>">
   </fieldset>
   <br>
 <label>OVERALL %AGE OF CLASS TEST</label> &nbsp &nbsp<input type="number" name="v1" placeholder="over all % of classtest" value = <% double res2 = ( request.getAttribute("cperc") == null) ? 0 : (Double)request.getAttribute("cperc") ; out.print(res2); %>>%<br><br>
 <input type="submit" value="submit">
 </form>
 </div>

</body>
</html>