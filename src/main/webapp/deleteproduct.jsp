<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@page import="com.pizza.model.Product"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE PRODUCT</title>
<style>
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
.active {
  background-color: #04AA6D;
}
.total {
	background-image: url("Assets/Images/adminback2.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body >
		<h3 align="center">Delete Product</h3>
<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
<form align="center" action="deleteproduct" method="post">
	<div>		
	 <label for="name">product id :</label>
        <input type="text" name="id" value="${id}" ><br><br>            
        <button onclick="demo()">DELETE</button>
        <button type="reset">RESET</button>
    </div>        
<!-- <script>
function demo() { 
alert("product deleted successfully");
} 
</script> -->
</form>	
</body> 
</html> 