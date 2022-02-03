<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.pizza.dao.CartDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@page import="com.pizza.model.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Showcart</title>
<style type="text/css">
th{
             background-color: gray;
             color: black;
            height: 60px;
            border: 1px solid black;
        }

        td {
        height:20px;
            text-align: center;
            border: 1px solid black;
        }
        
table {		
color:black;
             position: absolute;
             left:125px;  
             top:200px;      
            width: 80%;
            border-collapse: collapse;           
            border-top: none;
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
	background-color : lightgreen;
   	background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}

</style>
</head>
<body align="center" class="cart">
<table align="center">

			<h1><b>MyCart<b></b></h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp?orderId=0">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
	<tr>	
		<th>Cart Id</th>
		<th>product name</th>
		<th>product size</th>
		<th>product price</th>
		<th>Order</th>
		<th>Remove</th>
	</tr>	
	
		<c:forEach items="${cartList}" var="obj">
		<tr>
		<td>${obj.id}</td>
		<td>${obj.product.productname}</td>
		<td>${obj.product.size}</td>
		<td>${obj.product.price}</td>			
		<td><a href="OrderProductConformation?productname=${obj.product.productname}&productsize=${obj.product.size}&productprice=${obj.product.price}">order</a> </td> <br><br> 
		<td><a href="Deletecart?cartid=${obj.id}" >Remove</a></td> 
		</tr>		
		</c:forEach>

</table>
</body>
</html>