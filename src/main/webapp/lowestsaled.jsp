<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="java.sql.Date"%>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LowestSaled</title>
<style>
		 label{
            width:130px;
            display: inline-block;
        	}	
		 form {
			top : 20px;
		}
		
			  ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}
.total{
	background-color:  pink;
}
.date{
    font-family: 'Ubuntu', 'Lato', sans-serif;
    /* Size and position */
    width: 300px;
    position: relative;
    margin: 60px auto 30px;
    padding : 10px;
    /* Styles */
	background: linear-gradient(110deg, white 60%,lightpink 60%);   
	 border-radius: 0.4em;
    box-shadow: 
        0 16px 10px -8px rgba(0, 0, 0, 0.6);
}
</style>
</head>
<body class="total">
<h1 align="center">Enter The Date</h1>
<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>

<form class="date" align="center" action="low">

<label for="fromdate">FromDate:</label>
<input type="date" name="fromDate" id="fromdate"  required><br> <br>

<label for="todate">ToDate:</label>     
<input type="date" name="toDate" id="todate" required><br><br>

<input type="submit" value="calculate" class="btn btn-primary" > 
</form>

<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy1= today.getFullYear();
maxdate =yyyy1 + '-' + mm + '-'+ dd  
document.getElementById("fromdate").setAttribute("max",maxdate);

}
</script>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy1= today.getFullYear();
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;

document.getElementById("todate").setAttribute("max",maxdate);
}
</script>
</body>
</html>