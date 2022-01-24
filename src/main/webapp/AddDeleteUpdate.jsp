<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel ="icon" href="Images/logopizza.png"; >
<meta charset="ISO-8859-1">
<title>AddUpdateDelete</title>
<style>
	
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
  background-color: lightblue;
}
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
             position: absolute;
             left:125px;  
             top:200px;     
            width: 80%;
            border-collapse: collapse;           
            border-top: none;
        }
.add{
position: absolute;
bottom: 30px;
left:650px;
}
.admin{
		background: linear-gradient(110deg, gray 50%, white 50%);
}
.hh{
	color : white;
}

.close{
	height: 100%;
	width: 0;
	  overflow: hidden;
	position: fixed;
	z-index: 1;
	top: 0;
	left:0;
	background-color: white;
	overflow-x :hidden;
	transition : 0.5s;
	padding-top: 60px; 
}
.close{
		padding: 8px -30px 8px 32px;
		text-decoration: none;
		font-size: 25px;
		color: #818181;
		display :block;
		transition : 0.5s;
}
.close a:hover{
	color: red;	
	text-decoration:none;
}
.close .closebtn{
		position: absolute;
		top: 0;
		right: 25px;
		font-size: 30px;
		margin-left: 50px;
}
@media screen and (max-height: 450px){
		.close{ padding-top: 15px;}
		.close .a{ font-size: 18px;}
		
	}
th{
	color: white;
}
</style>
</head>
<body class="admin"> 
<center>

<h1 class="hh">Admin</h1>

</center>
<ul class="nav navbar-nav">
<li class="active"><a href="AddDeleteUpdate.jsp">Home</a></li>
<li><a href="userlist.jsp">Users List</a></li>
<li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
</ul><br>

<div id="sales" class="close">
<a href="javascript:void(0)" class="closebtn" onclick="closenav()">X</a>
<a href="totalamount.jsp"> Total Sales</a><br><br>
<a href="mostsaledproduct.jsp">Most Purchased Product</a><br><br>
<a href="lowestsaled.jsp">Lowest Purchased Product</a><br><br>
<a href="mostpurchaseduserdate.jsp">Most Purchase User</a>
</div>

<span style="font-size: 30px;cursor: pointer;" onclick="opennave()">Sales</span>

<form align="center">

	<table align="center" border="5">
	<tr>	
		<th>Product id</th>	
		<th>Product name</th>
		<th>Product size</th>
		<th>Product price</th>
		<th>Delete Products</th>	
		<th>Update Products</th>
	</tr>		    
		<%
		ProductDaoImpl dao=new ProductDaoImpl();
		List<Product> list=dao.showProduct();
		for(int i=0;i<list.size();i++){ 
			Product product=list.get(i);
		ResultSet rs=dao.findProductId(product);
		if(rs.next()){%>		
		<tr>
		<td><%= rs.getInt(1)%></td>		
		<td><%= product.getProductname()%></td>
		<td><%=product.getSize()%></td>
		<td><%=product.getPrice() %></td>						
		<td><a href="Deleteproduct.jsp?Pid=<%= rs.getInt(1)%>">DELETE </a></td>
		<td><a href="Updateproduct.jsp?Pid=<%= rs.getInt(1)%>">UPDATE </a></td>

		<% }} %>	
		</tr>	
		</table><br><br><br><br><br><br>
		</form>
	<center>
	<div class="add">
			<a href="Addproduct.jsp"><button class="btn btn-primary">Add Product </button></a>
			</div>
</center>

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