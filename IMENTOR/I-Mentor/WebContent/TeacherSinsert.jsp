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
    </div>
  </div>
</nav> 
<h3 align="center">ENTER THE ENTRIES</h3>
  <table align="center" style="position:relative; top:-150px;">
         <form method="post" action="./Teachersinsert" align="center">
        <tr>
 <td><b>STUDENT ID</b></td>
<td><input type="text" name="sid" onblur="validateStudentId(this)" ></td>

</tr><br>
<tr>
<td><b>NAME</b></td>
<td><input type="text" name="sname" onblur="validateFirstName(this)" ></td>

</tr><br>
<tr>
<td><b>DEPARTMENT</b></td>
<td> <select name="sdept">
                         <option value="cse">CSE</option>
                         <option value="it">IT</option>
                         <option value="me">ME</option>
                         <option value="ee">EE</option>  
                         <option value="ece">ECE</option>  
                         </select></td>
</tr><br>
<tr>
<td><b>CONTACT</b></td>
<td><input type="text" name="scontact" onblur="validateContact(this)"></td>

</tr><br>
<tr>
<td><b>YEAR OF PASSING</b></td>
<td><input type="text" name="syop"></td>
</tr><br>
<tr>
<td><b>EMAIL</b></td>
<td><input type="text" name="semail" onblur="validateEmail(this)"></td>
</tr><br><br>
<tr><td style="position:relative; left:101px; "><br>
<input type="submit" value= "Register">
</td></tr> <br>
</form>
  </table>
</body>

</body>
</html>