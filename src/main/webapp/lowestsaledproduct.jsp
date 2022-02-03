<%@page import="com.pizza.model.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weakly Sales</title>
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
.total{
	background-color:  pink;
}

</style>
</head>
<body class="total">
<h1 align="center">Lowset Sold Product</h1>
<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br>
	 <form align="center">	  
	 <label for="name">Product Name</label> 
	 <input type="text" name="name" value="${Product.productname}" readonly><br><br>
	 <label for="size">Product Size</label>
	 <input type="text" name="size" value="${Product.size}" readonly><br><br>
	 <label for="prize " name="prize">Total Prize </label>
	 <input type="number" name="prize" value="${Product.price}" readonly>
	
   	</form>
</body>
</html>