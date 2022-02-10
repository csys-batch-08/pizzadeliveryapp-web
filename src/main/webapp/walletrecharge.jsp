<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Wallet Recharge</title>
<link rel="stylesheet" type="text/css" href="Assets/css/rechargewallet.css">
</head>
<body align="center" class="recharge">

        <c:if test="${invalidBalance!=null}">
        <h1 class="hh">${invalidBalance}</h1>
        </c:if>   
	<h1>Recharge Your Wallet</h1>

<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
<form action="recharge" method="post">
		<label for="name"> user name :</label>
		<input type="text" name="userid" value="${user.username}" readonly><br><br> 
 		<label for="wallet">amount</label>
 		<input type="number" name="recharge" min="100"><br><br>
 		<button  type="submit">UPDATE</button> 		 
 </form>
</body>
</html>