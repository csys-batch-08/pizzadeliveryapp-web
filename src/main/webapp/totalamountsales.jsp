<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Weakly Sales</title>
<link rel="stylesheet" type="text/css" href="Assets/css/totalamount.css">

</head>
<body class="total">
<h1 class="title">Total Sold Rupess</h1>
	<ul>
		<li><a href="adddeleteupdate.jsp">Home</a></li>
		<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
	</ul>
	<br>
	<br>
	<br>

	<form align="center">
		<label for="totalprice">Total Sold Rupess</label> <br>
		<br> <input type="number" name="money" value="${totalprize}"
			readonly>
	</form>

</body>
</html>