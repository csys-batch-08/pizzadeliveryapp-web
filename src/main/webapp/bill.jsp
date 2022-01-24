<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="com.pizza.model.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Bill</title>
<style type="text/css">
th{
             color: black;
        }

        td {
                    border: 10px solid gray;
                    height: 60px;
                     background-color: white;
                    text-align: center;
        }
        
table {
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
.order{
	 background-image: url("Images/showorder.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
</head>
<body align="center" class="order">
<h1 align="center"><b>Bill</b></h1>
<ul>  
<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="Contect.jsp">Contact</a></li>
</ul><br><br><br><br>
			
		<%		
		int id=Integer.parseInt(request.getParameter("orderid"));
		String name=request.getParameter("name");
		String size=request.getParameter("size");
		int qty=Integer.parseInt(request.getParameter("quantity"));
		Double price=Double.parseDouble(request.getParameter("price"));
		%>
		<form action="bills">
		<table>
		<tr>
		<td><input type="number" name="id" value="<%=id %>" readonly></td>
			<td><%=name %></td>
			<td><%=size %></td>
			<td><%=qty %></td>
			<td><%=price %></td>
		</tr>
		</table>	<br>
		<button type="submit" class="btn btn-primary">Take</button>
	</form>
 </body>
</html>