<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="com.pizza.model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Invoice Bill</title>
<link rel="stylesheet" type="text/css" href="Assets/css/bill.css">
</head>
<body  class="order">
<h1 class="hh">Bill</h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
		
		<form action="bills" method="post">
		<table>
		<tr>
		<td><input type="number" name="id" value="${Oid}" readonly></td>
			<td>${productname}</td>
			<td>${productsize}</td>
			<td>${quantity}</td>
			<td>${productprice}</td>
		</tr>
		</table><br><br><br>
		
		<div class="take">
		<button type="submit" class="btn btn-primary" >Take</button>
		</div>
	</form>
 </body>
</html>