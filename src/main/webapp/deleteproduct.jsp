<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@page import="com.pizza.model.Product"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>DELETE PRODUCT</title>
<link rel="stylesheet" type="text/css" href="Assets/css/deleteproduct.css">

</head>
<body >
		<h3>Delete Product</h3>
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

</form>	
</body> 
</html> 