<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
 label{
            width:130px;
            display: inline-block;
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

.active {
  background-color: #04AA6D;
}
.cart{
	 background-image: url("Assets/Images/cart.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body align="center" class="cart">
		<h1>Add To Cart</h1>
	<ul>	
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
<form action="cart" method="post">

  	<div>		 	
		<label for="productid">product name :</label>
		<input type="text" name="productid" value="${pname}" readonly><br><br>
		<label for="productid">product size :</label>
		<input type="text" name="productid" value="${psize}" readonly><br><br>   
		<label for="productid">product price :</label>
		<input type="text" name="productid" value="${pprice}" readonly><br><br>        
        <button onclick="demo()">add to cart</button>  &nbsp &nbsp &nbsp &nbsp 
        <button type="reset">RESET</button>      
   </div>        
 </form>
</body>
</html> 
    
  