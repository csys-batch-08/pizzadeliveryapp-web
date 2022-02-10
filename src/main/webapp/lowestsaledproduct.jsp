<%@page import="com.pizza.model.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.daoimpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Weakly Sales</title>
<link rel="stylesheet" type="text/css" href="Assets/css/mostsoledproduct.css">
</head>
<body class="background">
	<h1 class="hh">Lowset Sold Product</h1>
	<ul>
		<li><a href="adddeleteupdate.jsp">Home</a></li>
		<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
	</ul>
	<br>
	<br>
	<br>
	<form align="center" method="post">
		<label for="name">Product Name</label> <input type="text" name="name" value="${Product.productName}" readonly><br>
		<br> 
		<label for="size">Product Size</label> 
		<input type="text" name="size" value="${Product.size}" readonly><br>
		<br> 
		<label for="prize " name="prize">Total Price </label> 
		<input type="number" name="prize" value="${Product.price}" readonly>
	</form>
</body>
</html>