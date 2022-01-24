<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
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
	 background-image: url("Images/showorder.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body onmouseover="check()"  align="center" class="order">

	 <%String notfound=(String)request.getAttribute("invalidBalance");
        if(notfound !=null){
        	%>
        	<h2><%=notfound %></h2>
        	        	
        	<%} %>


<h1>Buy Your snacks</h1>
<ul>
<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="Contect.jsp">Contact</a></li>
</ul><br><br><br><br>

<form action="order" align="center">
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
		
		<label for="name">quantity:</label>
        <input type="text" name="qty" id="quantity" pattern="[1-9]{1}"><br><br> 
        
        <label for="price">price : </label>       
        <input type="number" name="price" id="price" min="1"  readonly> <br><br>
            
        <button onclick="demo()">buy</button>  &nbsp &nbsp &nbsp &nbsp 
        <button type="reset">RESET</button>            
        </div>     
 </form>     
<script>
function check(){
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("price");
	console.log(count)
	totalPrice.value=count * <%=rs1.getDouble(2) %>;
	console.log(totalPrice.value);	
}
</script>
  <%
	  }%>
</body>
</html>


