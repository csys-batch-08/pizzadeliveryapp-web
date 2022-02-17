<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Inactive</title>
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
.total {
	background-image: url("Assets/Images/adminback2.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
h1{
  text-align: center;
}
</style>
</head>
<body class="total">
		<h1>Inactive User</h1>
<ul>  
<li><a href="AdminProductList">Home</a></li>
 <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>

<form align="center" action="inactive" method="post"> 
	<div>	
	 <label for="name">User</label>
        <input type="text" name="id" value="${userEmail}" readonly><br><br> 
        <button type="submit">Inactive</button>   
       </div>    
  </form>
</body>
</html>