<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List </title>
<style type="text/css">
th{
             background-color: gray;
             color: black;
            height: 60px;
            border: 1px solid black;
        }

        td {
        height:20px;
            text-align: center;
            border: 1px solid black;
        }
        
table {
             position: absolute;
             left:125px;  
             top:200px;      
            width: 80%;
            border-collapse: collapse;           
            border-top: none;
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
.admin{
		background: linear-gradient(110deg, gray 60%, white 60%);
}
</style>
</head>
<body style="background-color:lightpink" class="admin">
<center>
<h3>User List</h3>
</center>
<ul>
<li><a href="adddeleteupdate.jsp">Home</a></li>
<li><a href="userlist.jsp">Users List</a></li>
<li style="float:right"><a href="userlogin.jsp">Logout</a></li>
</ul><br><br><br><br>
<table>
	<tr>
	<th>User Name</th>
	<th>User email</th>
	<th>PhoneNumber</th>
	<th>Address</th>
	<th>Role</th>
	<th>Inactive</th>
	</tr>
	
	<c:forEach items="${userList}" var="obj">
	<tr>
	
		<td><c:out value="${obj.username }"></c:out></td>	
		<td><c:out value="${obj.email }"></c:out></td>	
		<td><c:out value="${obj.phonenumber }"></c:out></td>
		<td><c:out value="${obj.address }"></c:out></td>	
		<td><c:out value="${obj.type}"></c:out></td>	
		<td><a href="InactiveUserServlet?email=${obj.email}">Inactive</a></td> 		
	</tr>
	</c:forEach>
</table>
</body></html>