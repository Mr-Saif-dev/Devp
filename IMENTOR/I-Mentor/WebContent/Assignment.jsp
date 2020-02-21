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
  <form action="./Assignment">
   <table width="450" align ="center">
     <caption><b><b>ASSIGNMENT FORM</b></b><br><br></caption>
    </table>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
        <fieldset>
   <legend>ASSIGNMENT NO. ---------------------- SUBMITTED --------------- MARKS GIVEN ---------------------------------------------------------------</legend><br>
   ASSIGNMENT
   <select name="o1">
   <option> /</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="p1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="q1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    &nbsp &nbsp &nbsp &nbsp &nbsp
   <input type="text" name="r1" placeholder="Total" value = <% int res = ( request.getAttribute("atotal") == null) ? 0 : (Integer)request.getAttribute("atotal") ; out.print(res);%>>
   <br><br>
   <% String s_id=request.getParameter("sid");
   		System.out.println(s_id);
   		%>
   		<input type="hidden" name="sid" value="<%=s_id%>">
   </fieldset>
   <br>
 <label>OVERALL %AGE OF ASSIGNMENT</label> &nbsp &nbsp<input type="number" name="s1" placeholder="over all % of assignment" value = <% double res2 = ( request.getAttribute("aperc") == null) ? 0 : (Double)request.getAttribute("aperc") ; out.print(res2); %>>%<br><br>
 <input type="submit" value="submit">
 </form>
 </div>

</body>
</html>