<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <%@page import="com.pizza.daoimpl.ProductDaoImpl"%>
        <%@page import="com.pizza.model.Product"%>  
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PRODUCTS</title>
<style>
	th{
             background-color: black;
             color: white;
            height: 60px;            
        }       
table {
             position: absolute;
             left:125px;  
             top:125px;     
            width: 80%;
            border-collapse: collapse;           
            border-top: none;
        }	
        a:hover{
            text-decoration:none;
            background-color: white;
            border: 1px solid black;
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
  background-color: lightblue;
}

.active {
  background-color: #04AA6D;
}
.main{
	background-image: url("Assets/Images/main.gif");
    background-repeat: no-repeat;
  	background-attachment: fixed;
  	background-size: cover;
}
h1{
 color: white;
  text-align: center;
}
strong{
 color: white;
}
    </style>
</head>
<body align="center" class="main"> 
<h1><img src="Assets\Images\logopizza.png" alt="logo.png" width="150px" height="100px">PizzaHut</h1>

<ul>  
<li><a href="ListProductServlet">Home</a></li>
  <li> <a href="ShowOrderServlet">MyOrders</a></li>
  <li><a href="ShowCartServlet">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>

		<c:forEach items="${requestScope.ProductList}" var="obj">
		<div align="center">
	<span class="bounce_button"><img src="Assets\Images\<c:out value="${obj.productName}"></c:out>.jpg" alt="img" width=300px height=175px class="bounce"></span><br>
	<strong> <c:out value="${obj.productName}"></c:out>&nbsp; &nbsp;
		<c:out value="${obj.size}"></c:out>   &nbsp; &nbsp; &nbsp;
		<c:out value="${obj.price}"></c:out><br> <br></strong>	&nbsp; &nbsp; 
 	  	<a href="AddCartProductConformation?productname=${obj.productName}&productsize=${obj.size}&productprice=${obj.price}"><button class="btn btn-primary">cart</button></a>   &nbsp; &nbsp; &nbsp;		
 		<a href="OrderProductConformation?productname=${obj.productName}&productsize=${obj.size}&productprice=${obj.price}"><button class="btn btn-primary">order</button></a>   <br><br><br><br> 
		</div>
		</c:forEach>					
</body>
</html>