<%@page import="java.util.List"%>
<%@page import="com.pizza.model.Product"%>
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

</style>
</head>
<body style="background-color: pink">
<h1 align="center">Most Sold Product</h1>
<ul>  
<li><a href="AddDeleteUpdate.jsp">Home</a></li>
 <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>

		<%  Date fromdate=(Date) session.getAttribute("fromDate");
			Date todate=(Date)session.getAttribute("toDate");
			Product product=new Product();
			OrderDaoImpl orderdao = new OrderDaoImpl();
			Product productlist=orderdao.mostsaledproduct(fromdate, todate);	
	     %>		 
	 <form align="center">
	 <label for="name">Product Name</label> 
	 <input type="text" name="name" value="<%=productlist.getProductname() %>" readonly><br><br>
	 <label for="size">Product Size</label>
	 <input type="text" name="size" value="<%=productlist.getSize() %>" readonly><br><br>
	 <label for="prize ">Total Prize </label>
	 <input type="number" name="prize" value="<%=productlist.getPrice() %>" readonly>
   	</form>
</body>
</html>