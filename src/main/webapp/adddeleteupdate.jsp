<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.daoimpl.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.pizza.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel ="icon" href="Assets/Images/logopizza.png" >
<meta charset="ISO-8859-1">
<title>AddUpdateDelete</title>
<link rel="stylesheet" type="text/css" href="Assets/css/adddeleteupdate.css">
</head>
<body class="admin"> 

<h1 class="hh">ADMIN</h1>

<ul class="nav navbar-nav">
<li class="active"><a href="adddeleteupdate.jsp">Home</a></li>
<li><a href="userlist.jsp">Users List</a></li>
<li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br>

<div id="sales" class="close">
<a href="javascript:void(0)" class="closebtn" onclick="closenav()">&#10006;</a>
<a href="totalamount.jsp"> Total Sales</a><br><br>
<a href="mostsaledproduct.jsp">Most Purchased Product</a><br><br>
<a href="lowestsaled.jsp">Lowest Purchased Product</a><br><br>
<a href="mostpurchaseduserdate.jsp">Most Purchase User</a>
</div>

<span style="font-size: 30px;cursor: pointer;" onclick="opennave()">Sales</span>

<form method="post">

	<table align="center" border="5">
	<tr>	
		<th>Product Id</th>	
		<th>Product Name</th>   
		<th>Product Size</th>
		<th>Product Price</th>
		<th>Product Status</th>	
		<th>Update Products</th>
	</tr>		    		
		<c:forEach items="${productList}" var="obj">	
		<tr> 
		<td><c:out value="${obj.productId }"></c:out></td>	
		<td><c:out value="${obj.productName }"></c:out></td>	
		<td><c:out value="${obj.size }"></c:out></td>
		<td><c:out value="${obj.price }"></c:out></td>	
		<td><c:out value="${obj.status }"></c:out></td>	
		<td><a href="UpdateProductConformation?Pid=${obj.productId}&productname=${obj.productName}&productsize=${obj.size}&productprice=${obj.price}&productstatus=${obj.status}">UPDATE </a></td>		 
		</tr>
		</c:forEach>
		</table><br><br><br><br><br><br> 
		</form> 
	<div class="add">
			<a href="addproduct.jsp"><button class="btn btn-primary">Add Product </button></a>
			</div>
<script>
function opennave() {
	document.getElementById("sales").style.width="250px";
}
function closenav() {
	document.getElementById("sales").style.width="0";
}
</script>
</body>
</html>