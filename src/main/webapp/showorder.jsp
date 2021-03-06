<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.pizza.model.User"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pizza.daoimpl.OrderDaoImpl"%>
<%@page import="com.pizza.model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SHOWORDERS</title>
<style type="text/css">
th {
	background-color: gray;
	color: black;
	height: 60px;
	border: 1px solid black;
}

td {
	height: 20px;
	text-align: center;
	border: 1px solid black;
}

table {
	color: black;
	position: absolute;
	left: 125px;
	top: 200px;
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

.order {
	background-color: lightgreen;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
</head>
<body align="center" class="order">
	<table>
		<h1>MyOrders</h1>
		<ul>
			<li><a href="ListProductServlet">Home</a></li>
			<li><a href="ShowOrderServlet">MyOrders</a></li>
			<li><a href="ShowCartServlet">Mycart</a></li>
			<li><a href="userdetails.jsp">Account</a></li>
			<li><a href="walletrecharge.jsp">RechargeWallet</a></li>
			<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
			<li><a href="contect.jsp">Contact</a></li>
		</ul>

		<tr>
			<th>Order Id</th>
			<th>Product Name</th>
			<th>Product Size</th>
			<th>Product Price</th>
			<th>Quantity</th>
			<th>Date</th>
			<th>Status</th>
			<th>Cancel Order</th>
			<th>Bill</th>
		</tr>
		<c:forEach items="${requestScope.orderList}" var="obj">
			<tr>
				<td>${obj.orderId}</td>
				<td>${obj.product.productName}</td>
				<td>${obj.product.size}</td>
				<td>${obj.price} Rs</td>
				<td>${obj.quantity}</td>
				<td><fmt:parseDate value="${obj.orderDate}" pattern="yyyy-MM-dd" var="macthDate" type="date"/> 
				<fmt:formatDate pattern="dd/MM/yyyy" value="${macthDate}" /></td>
				<td>${obj.status}</td>
				<td><c:if test="${obj.status == 'pending' }"><a href="BillDeliverdConformation?orderid=${obj.orderId}&name=${obj.product.productName}&size=${obj.product.size}&quantity=${obj.quantity}&price=${obj.price}&date=${obj.orderDate}">bill</a></c:if></td>
				<td><c:if test="${obj.status == 'pending'}"><a href="CancelOrderConformation?orderId=${obj.orderId}&amount=${obj.price}">cancel</a></c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>