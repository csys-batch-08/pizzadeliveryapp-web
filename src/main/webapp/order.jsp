<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.daoimpl.UserDaoImpl"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.pizza.model.User"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="com.pizza.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html  lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Order</title>
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
.order{
	 background-image: url("Assets/Images/showorder.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body onmouseover="check()"  align="center" class="order">	
       	
<c:remove var="inactive" scope="session" />
        	
<h1>Buy Your snacks</h1>
<ul>
<li><a href="ListProductServlet">Home</a></li>
  <li> <a href="ShowOrderServlet">MyOrders</a></li>
  <li><a href="ShowCartServlet">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>

<form action="order" align="center" method="post">
  
  	<div> 
		<label for="productid">product name :</label>
		<input type="text" name="productid" value="${pName}" readonly><br><br>
		
		<label for="name">quantity:</label>
        <input type="text" name="qty" id="quantity" pattern="[1-9]{1}"><br><br> 
        
        <label for="price">price : </label>       
        <input type="number" name="price" id="price" min="1"  readonly> <br><br>
            
        <button onclick="demo()">buy</button>  &nbsp; &nbsp; &nbsp; &nbsp; 
        <button type="reset">RESET</button>            
        </div>     
 </form>     
<script>
function check(){
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("price");
	console.log(count)
	totalPrice.value=count * ${pPrice};
	console.log(totalPrice.value);	
}
</script>

</body>
</html>


