<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script 	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <link rel="icon" href="Images/logopizza.png"; >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<link rel="stylesheet" type="text/css" href="Assets/css/login.css">
</head>
<body class="dummySty">

	<div class="exception">
		<c:if test="${notfound !=null}">
			<h3>${notfound}</h3>
		</c:if>
		<c:if test="${Inactiveuser !=null}">
			<h3>${Inactiveuser}</h3>
		</c:if>		
	</div>
	<h1>
		<img src="Assets\Images\logopizza.png" alt="logo.png" width="150px" height="100px"> PizzaHut
	</h1>
	<br>
	<form action="Login"  class="login" method="post">
		<div class="log">
			<h3>Login</h3>
		</div>
		<label for="email">EMAIL :</label> <br> <input
			type="text" name="email" placeholder="email"
			pattern="[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}" required><br>
		<br> <label for="password">PASSWORD :</label> <br> <input
			type="password" name="password" placeholder="password" required><br>
		<br>
		<button class="btn btn-primary" type="submit">Login</button>
		
		&nbsp; &nbsp; &nbsp; <a href="index.jsp">I'm New Here</a>
	</form>
</body>
</html>