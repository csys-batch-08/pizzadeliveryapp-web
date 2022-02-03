<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <%@page import=" com.pizza.dao.ProductDaoImpl"%>
        <%@page import="com.pizza.model.Product"%>  
<!DOCTYPE html>
<html>
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
.h1{
}
#searchbar{
position: absolute;
left: 71%;
top: 119px;

}

span:hover {
  cursor: pointer;
  animation-name: bounce;
  -moz-animation-name: bounce;
}

 </style>
</head>
<body style="background-color:lightgreen;" align="center" class="main"> 
<h1 style="color:white;" align="center"><img src="Assets\Images\logopizza.png" width="150px" height="100px">PizzaHut</h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp?orderId=0">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>   
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul>

<div id="searchbar">
<form action="SearchProductServlet" > 
<input type="text" name="search" placeholder="Search" required> &nbsp<button class="btn btn-primary" type="submit">&#128269;</button>
  </form> 
  
  </div><br><br><br>
		<c:forEach items="${productlist}" var="obj">
		<div align="center">
	<span class="bounce_button"><img src="Assets\Images\<c:out value="${obj.productname}"></c:out>.jpg" alt="img" width=300px height=175px class="bounce"></span><br>
		<b style="color:white;"><c:out value="${obj.productname}"></c:out></b>&nbsp &nbsp
		<b style="color:white;"><c:out value="${obj.size}"></c:out></b>   &nbsp &nbsp &nbsp
		<b style="color:white;"><c:out value="${obj.price}"></c:out> Rs</b><br> <br>	&nbsp &nbsp 
 	  	<a href="AddCartProductConformation?productname=${obj.productname}&productsize=${obj.size}&productprice=${obj.price}"><button class="btn btn-primary">cart</button></a>   &nbsp &nbsp &nbsp		
 		<a href="OrderProductConformation?productname=${obj.productname}&productsize=${obj.size}&productprice=${obj.price}"><button class="btn btn-primary">order</button></a>   <br><br><br><br> 
		</div>
		</c:forEach>
</body>
</html>