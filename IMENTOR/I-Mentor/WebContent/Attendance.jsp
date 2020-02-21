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
  <form action="./Attendance">
   <table width="450" align ="center">
     
<caption><b><b>ATTENDANCE FORM</b></b><br><br></caption>
<br>
<br>
<br>
<br>
<br>
<br>
      
</table><br><br>
        <fieldset>
   <legend>COURSE 1 ---------------------- ATTENDANCE ---------------Q/A --------------------FOLLOW INST-------------MAKING NOTES</legend>
   LECTURE 
   <select name="ll1">
   <option> /</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
   <option value="4">4</option>
   <option value="5">5</option>
   <option value="6">6</option>
   <option value="7">7</option>
   <option value="8">8</option>
   <option value="9">9</option>
   <option value="10">10</option>
   <option value="11">11</option>
   <option value="12">12</option>
   <option value="13">13</option>
   <option value="14">14</option>
   <option value="15">15</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="aa1">
   <option value="0">A</option>
   <option value="5">P</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="bb1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="cc1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <select name="dd1">
   <option value="5">Y</option>
   <option value="0">N</option>
   </select> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <input type="text" name="ee1" placeholder="Total"  value = <% int res = ( request.getAttribute("acototal") == null) ? 0 : (Integer)request.getAttribute("acototal") ; out.print(res);%>>
   <br><br>
   <label>OVERALL %AGE ON COURSE 1</label>&nbsp<input type="number" name="ff1" placeholder="" value = <% double res2 = ( request.getAttribute("acoperc") == null) ? 0.0 : (Double)request.getAttribute("acoperc") ; out.print(res2); %>>%
 
<br><br>

  
    <legend>COURSE 2 --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</legend>
    &nbsp &nbsp; &nbsp;  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <input type="text" name="gg1" placeholder="Total"   value = <% int res3 = ( request.getAttribute("acttotal") == null) ? 0 : (Integer)request.getAttribute("acttotal") ; out.print(res3);%>>
   <br><br>
   <label>OVERALL %AGE ON COURSE 2</label>&nbsp<input type="number" name="hh1" placeholder=""  value = <% double res4 = ( request.getAttribute("actperc") == null) ? 0.0 : (Double)request.getAttribute("actperc") ; out.print(res4); %>>%
 
<br><br>

   
   <legend>COURSE 3 --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</legend>
   &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp 
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
   <input type="text" name="ii1" placeholder="Total"  value = <% int res5 = ( request.getAttribute("acthtotal") == null) ? 0 : (Integer)request.getAttribute("acthtotal") ; out.print(res5);%>>
   <br><br>
   <% String s_id=request.getParameter("sid");
   		System.out.println(s_id);
   		%>
   		<input type="hidden" name="sid" value="<%=s_id%>">
   <label>OVERALL %AGE ON COURSE 3</label>&nbsp<input type="number" name="jj1" placeholder=""  value = <% double res6 = ( request.getAttribute("acthperc") == null) ? 0.0 : (Double)request.getAttribute("acthperc") ; out.print(res6); %>>%
 </fieldset>
 <br>
 <input type="submit" value="submit">
 <br>
 <br>
 <label>OVERALL %AGE ON ATTEDANCE </label>&nbsp<input type="number"name="kk1" placeholder="" value = <% double res7 = ( request.getAttribute("aperc") == null) ? 0.0 : (Double)request.getAttribute("aperc") ; out.print(res7); %>>%
</form>
 </div>

</body>
</html>