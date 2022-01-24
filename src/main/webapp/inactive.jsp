<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
</style>
</head>
<body style="background-color:orange;">
		<h3 align="center">Delete Product</h3>
<ul>  
<li><a href="AddDeleteUpdate.jsp">Home</a></li>
 <li style="float:right"><a href="Userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
<form align="center" action="inactive">
	<div>	
	<% String email=request.getParameter("email") ; %>
	 <label for="name">User</label>
        <input type="text" name="id" value=<%= email%> readonly><br><br> 
        <button type="submit">Inactive</button>       
</script>
</body>
</html>