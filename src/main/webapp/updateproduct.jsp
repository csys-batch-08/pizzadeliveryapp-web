<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update product</title>
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
 .login{
    font-family: 'Ubuntu', 'Lato', sans-serif;
    font-weight: 400;
    /* Size and position */
    width: 300px;
    position: relative;
    margin: 60px auto 30px;
    padding : 10px;
    overflow: hidden;
	font-color : white;
    /* Styles */
	background: linear-gradient(110deg, white 60%,gray 60%);    border-radius: 0.4em;
    box-shadow: 
        0 16px 10px -8px rgba(0, 0, 0, 0.6);
}
.update{
		background: linear-gradient(110deg, gray 50%, white 50%);
}
</style>
</head>
<body class="update">
<center>
		<h3>UPDATE THE PRODUCTS</h3>
</center>
<ul>  
<li><a href="adddeleteupdate.jsp">Home</a></li>

  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
	

      <form  align="center" class="login" action="updateproduct"> 
		<label for="id">product id :</label>
        <input type="text" name="id" value="${id }" readonly><br><br>      
        <label for="name">product name :</label>
        <input type="text" name="name" value="${ProductName}"><br><br>
        <label for="size">product size :</label>
        <input type="text" name="size" value="${ProductSize}"><br><br>
        <label for="price">product price :</label>
        <input type="text" name="price" min="1" value="${ProductPrice}"><br><br>    
        <label for="status">product status :</label>
        <input type="text" name="status" value="${ProductStatus}"><br><br> 
        <button onclick="demo()">UPDATE</button>
        <button type="reset">RESET</button>
       </form>
</body>
</html>