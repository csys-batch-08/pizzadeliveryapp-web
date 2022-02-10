<%@page import="com.pizza.model.User"%>
<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pizza.daoimpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Most Purchased User</title>
<link rel="stylesheet" type="text/css" href="Assets/css/mostsoledproduct.css">
</head>
<body class="background">
	<h1 class="hh">Most Purchased User</h1>
	<ul>
		<li><a href="adddeleteupdate.jsp">Home</a></li>
		<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
	</ul>
	<br>
	<br>
	<br>
	<br>
	<form align="center" method="post">
		<label for="name">User Name</label> <input type="text" name="name" value="${User.userName}" readonly><br>
		<br> 
		<label for="prize " >Total Prize </label> 
		<input type="number" name="prize" value="${User.wallet}" readonly>
	</form>
</body>
</html>