<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="java.util.List"%>
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

<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp?orderId=0">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
	<tr>	
		<th>Cart Id</th>
		<th>product name</th>
		<th>product size</th>
		<th>product price</th>
		<th>Remove</th>
		<th>Order</th>
	</tr>	

<%		Product product=new Product();
		Product productdetails=(Product) session.getAttribute("product");
		 ProductDaoImpl dao1=new ProductDaoImpl();
		 List<Product> list1=dao1.showProduct();
		 for(int j=0;j<list1.size();j++){
		 	 product=list1.get(j);		
		 }
		User user=(User) session.getAttribute("user");	
		Cart cart=new Cart();
		CartDaoImpl dao=new CartDaoImpl();
		List<Cart> list=dao.showcart(user);
		for(int i=0;i<list.size();i++){
		cart=list.get(i);	
		%>		
		<tr>
		<td><%=cart.getId() %></td>
		<td><%=cart.getProduct().getProductname()%></td>
		<td><%=cart.getProduct().getSize() %></td>
		<td><%=cart.getProduct().getPrice()%></td>		
		<td><a href="Deletecart?cid=<%=cart.getId() %>" >Remove</a></td>
		<td><a href="Order.jsp?productname=<%=product.getProductname()%>&productsize=<%=product.getSize()%>&productprice=<%=product.getPrice()%>">order</a></td><br><br>
		</tr>		
	<% } %>
</table>
</body>
</html>