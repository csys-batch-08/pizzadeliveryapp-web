<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="com.pizza.model.Order"%>
<%@page import="com.pizza.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Order</title>
<style type="text/css">
th{
             background-color: white;
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
.order{
	 background-image: url("Assets/Images/showorder.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body align="center" class="order">
<table align="center">
<h1>MyOrders</h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>	
	
<form  action="cancel" align="center">
	<div align="center">
	<label for="name" >Order Id</label>
	<input type="number" name="id" value="${OrderId}"  readonly> <br><br>
	<label for="amount">Refund Amount</label>
	<input type="number" name="refund" value="${Amount}" readonly>
	<button type="submit" class="btn btn-primary">Cancel Order</button>
	</div>
</form>
</table>			
</body>
</html>