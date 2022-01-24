<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user details</title>
<style type="text/css">
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
 label{
            width:400px;
            display: inline-block;
        }
</style>
</head>
<body align="center" style="background-color:pink;">
<h1>My Details</h1>
<ul>  
<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li><a href="contect.jsp">Contact</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
</ul><br><br>

<%
		User user=(User) session.getAttribute("user");
		UserDaoImpl dao=new UserDaoImpl();
		%>	
		<div class="myDiv" align="center" >
	<label for="name"><h3>NAME - </h3><%=user.getUsername() %></label><br>
	<label for="email"><h3>E-MAIL - </h3><%=user.getEmail() %></label><br>
	<label for="pnumber"><h3>PHONENUMBER - </h3><%=user.getPhonenumber() %></label><br>
	<label for="address"><h3>ADDRESS - </h3><%=user.getAddress() %></label><br><br>
	<label for="password"><h3>PASSWORD - </h3><%=user.getPassword() %></label><br>
	<label for="wallet"><h3>WALLET - </h3><%=user.getWallet() %> Rs</label>
		</div>
</body>
</html>