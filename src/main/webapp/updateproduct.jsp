<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>update product</title>
<link rel="stylesheet" type="text/css" href="Assets/css/updateproduct.css">

</head>
<body class="update">
		<h3 class="hh">UPDATE THE PRODUCTS</h3>

<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>

  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>

      <form  align="center" class="login" action="updateproduct"> 
		<label for="id">product id :</label>
        <input type="text" name="id" value="${id }" readonly><br><br>      
        <label for="name">product name :</label>
        <input type="text" name="name" value="${productName}"><br><br>
        <label for="size">product size :</label>
        <input type="text" name="size" value="${productSize}"><br><br>
        <label for="price">product price :</label>
        <input type="text" name="price" min="1" value="${productPrice}"><br><br>    
        <label for="status">product status :</label>
        <input type="text" name="status" value="${productStatus}"><br><br> 
        <button onclick="demo()">UPDATE</button>
        <button type="reset">RESET</button>
       </form>
</body>
</html>