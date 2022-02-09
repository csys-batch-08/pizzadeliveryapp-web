<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="com.pizza.dao.UserDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pizza.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" type="text/css" href="Assets/css/userlist.css">

</head>
<body style="background-color: lightpink" class="admin">

	<h3 class="hh">User List</h3>
	<ul>
		<li><a href="adddeleteupdate.jsp">Home</a></li>
		<li><a href="userlist.jsp">Users List</a></li>
		<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
	</ul>
	<br>
	<br>
	<br>
	<br>

	<table>
		<tr>
			<th>User Name</th>
			<th>User Email</th>
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
</body>
</html>