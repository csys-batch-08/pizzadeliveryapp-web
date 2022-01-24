<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	 background-image: url("Images/cart.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body align="center" class="cart">
		<h1>Add To Cart</h1>
	<ul>	
<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>
<form action="cart" method="post">
	<% 	
	User user=(User) session.getAttribute("user");		
	UserDaoImpl userdao=new UserDaoImpl();
	int id=userdao.finduserid(user);
	
	ProductDaoImpl productdao=new ProductDaoImpl();	
	List<Product> productList=productdao.showProduct();	

	String pname=request.getParameter("productname");
	String psize=request.getParameter("productsize");
	Product product=new Product(pname,psize,null);
	
	ResultSet rs1=productdao.findProductId(product);
	session.setAttribute("productid", product);			
   if(rs1.next()) {	   
    %>	
    
  	<div>		
		<label for="productid">product name :</label>
		<input type="text" name="productid" value="<%=product.getProductname() %>" readonly><br><br>
		<label for="productid">product size :</label>
		<input type="text" name="productid" value="<%=product.getSize() %>" readonly><br><br>           
        <button onclick="demo()">add to cart</button>  &nbsp &nbsp &nbsp &nbsp 
        <button type="reset">RESET</button>      
        </div>        
 </form>
  <%
	}%>
</body>
</html> 
    
  