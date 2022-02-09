<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>        
     <link rel ="icon" href="Images/logopizza.png"; >
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> ADD products</title>
<link rel="stylesheet" type="text/css" href="Assets/css/addproduct.css">
</head>
<body class="total">

<h1 class="hh">ADD PRODUCTS</h1>

<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
<form align="center" action="addproduct" method="post">
	<div>	
	 <label for="name">Product Name :</label>
        <input type="text" name="name"><br><br>
        <label for="size">Product Size :</label> 
        <input type="text" name="size"><br><br>
        <label for="price" >Price :</label>
        <input type="number" name="price" min="1"><br><br>     
        <button type="submit" onclick="thanks()">ADD</button>
        <button type="reset">RESET</button>
      </div> 
      </form>		
      	<div class="center">
            	</div>
      		<c:if test="${sameproduct !=null}">
			<h3 align="center">${sameproduct}</h3>
		</c:if>
		<c:remove var="sameproduct" scope="session"/>
      <script type="text/javascript">
      function  thanks(){
    	  alart("Product Added Successfully");
      }
      </script>
</body>
</html>