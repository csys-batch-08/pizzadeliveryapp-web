<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>        
     <link rel ="icon" href="Images/logopizza.png"; >
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> ADD products</title>
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
</style >
</head>
<body style="background-color:pink;">

<h1 align="center">ADD PRODUCTS</h1>
<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
<form align="center" action="addproduct">
	<div>	
	 <label for="name">Product name :</label>
        <input type="text" name="name"><br><br>
        <label for="size">Product size :</label> 
        <input type="text" name="size"><br><br>
        <label for="price" >Price :</label>
        <input type="number" name="price" min="1"><br><br>     
        <button type="submit" onclick="thanks()">ADD</button>
        <button type="reset">RESET</button>
      </div> 
      </form>			
      <script type="text/javascript">
      function  thanks(){
    	  alart("Product Added Successfully");
      }
      </script>
</body>
</html>