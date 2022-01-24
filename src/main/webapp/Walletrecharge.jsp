<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallet Recharge</title>
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
  background-color: #04AA6D;
}
       label{
            width:130px;
            display: inline-block;
        }
        
   .recharge{
	 background-image: url("Images/money.jpg");
     background-repeat: no-repeat;
  	 background-attachment: fixed;
 	 background-size: cover;
}
</style>
</head>
<body class="recharge">

 <%String notfound=(String)session.getAttribute("invalidBalance");
        if(notfound !=null){
        	%>
        	<h2 align="center"><%=notfound %></h2>
        	<%session.removeAttribute("invalidBalance");%>
       <% } %>    
<form action="recharge" method="post" align="center">
	<h1>Recharge Your Wallet</h1>

<ul>  
<li><a href="Showproducts.jsp">Home</a></li>
  <li> <a href="Showorder.jsp">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>
  <li> <a href="Userdetails.jsp">Account</a></li>
  <li><a href="Walletrecharge.jsp">RechargeWallet</a></li>
  <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br><br><br><br>

<%		User user=(User) session.getAttribute("user");
		UserDaoImpl dao=new UserDaoImpl();
		%>
		<label for="name"> user name :</label>
		<input type="text" name="userid" value="<%=user.getUsername()%>" readonly><br><br> 
 		<label for="wallet">amount</label>
 		<input type="number" name="recharge" min="100"><br><br>
 		<button  type="submit">UPDATE</button> 		 
 </form>
</body>
</html>