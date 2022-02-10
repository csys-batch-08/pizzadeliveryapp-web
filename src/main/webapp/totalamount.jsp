<%@page import="java.sql.ResultSet"%>
<%@page import="com.pizza.daoimpl.OrderDaoImpl"%>
<%@page import="java.sql.Date"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Total Amount</title>
<link rel="stylesheet" type="text/css" href="Assets/css/date.css">
</head>
<body class="total">
	<h1 class="title">Total Sold Amount</h1>
	<ul>
		<li><a href="adddeleteupdate.jsp">Home</a></li>
		<li style="float: right"><a href="userlogin.jsp">Logout</a></li>
	</ul>
	<br>
	<br>
	<br>
	<br>

	<form class="date" align="center" action="total">

		<label for="fromdate">FromDate:</label> <input type="date"
			name="fromDate" id="fromdate" max="" required><br> <br>

		<label for="todate">ToDate:</label> <input type="date" name="toDate"
			id="todate" required><br>
		<br>

		<button type="submit" class="btn btn-primary>Calculate">Calculate</button>
	</form>
	<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy1= today.getFullYear();
maxdate =yyyy1 + '-' + mm + '-'+ dd  
document.getElementById("fromdate").setAttribute("max",maxdate);

}
</script>
	<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy1= today.getFullYear();
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;

document.getElementById("todate").setAttribute("max",maxdate);
}
</script>
</body>
</html>