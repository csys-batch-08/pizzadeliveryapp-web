<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>user details</title>
<style type="text/css">
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
 label{
            width:400px;
            display: inline-block;
        }
 .myDiv{
 	text-align: center;
 	display: block;
 }
 .back
 {
 	background-image: url("Assets/Images/adminback2.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
 }
 
.title{
	text-align: center;
}
</style>
</head>
<body class="back">
<h1 class="title">My Details</h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li><a href="contect.jsp">Contact</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br>
	<div class="myDiv">
	<h3>NAME - </h3><c:out value="${user.userName}"></c:out>
	<h3>E-MAIL - </h3><c:out value="${user.email}"></c:out>
	<h3>PHONENUMBER - </h3><c:out value="${user.phoneNumber}"></c:out>
	<h3>ADDRESS - </h3><c:out value="${user.address}"></c:out>
	<h3>PASSWORD - </h3><c:out value="${user.password}"></c:out>
	<h3>WALLET - </h3><c:out value="${user.wallet}"></c:out>Rs
	</div>
</body>
</html>