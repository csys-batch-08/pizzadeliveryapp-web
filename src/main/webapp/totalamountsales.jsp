<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.dao.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weakly Sales</title>
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
.total{
	background-color:  pink;
}
</style>
</head>
<body class="total">
<ul>  
<li><a href="AddDeleteUpdate.jsp">Home</a></li>
 <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
</ul><br><br><br>
		<% Date fromdate=(Date)session.getAttribute("fromDate");
			Date todate=(Date)session.getAttribute("toDate");
			OrderDaoImpl orderdao= new OrderDaoImpl();
 			Double price=orderdao.TotalAmount(fromdate, todate);
	 %>
	 <form align="center">
	 <label for="totalprice">Total Sold Rupess</label> <br><br>
	 <input type="number" name="money" value="<%= price%>" readonly>
	</form>
 
</body>
</html>