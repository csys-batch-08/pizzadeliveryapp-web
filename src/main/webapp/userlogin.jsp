 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
      <link rel ="icon" href="Images/logopizza.png"; >   
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
       
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
<style>
a:hover	{
            text-decoration:none;
            background-color: white;   
        }
        label{
            width:130px;
            display: inline-block;
        	}
.dummySty {
  background-image: url("Assets/Images/login.jpg");
    background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
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
background: linear-gradient(110deg, rgb(254,155,26) 60%,rgb(231,35,57) 60%);    border-radius: 0.4em;
    box-shadow: 
         8px 10px 8px rgba(0, 0, 0, 0.6);
}
label{
font-family : comic sans;
    color: white !important;
}
input{
	border-radius: 0.4em;
}
.log{
		font-family:  sans-serif;
		background: linear-gradient(110deg, rgb(254,155,26) 60%,rgb(254,155,26) 60%);    border-radius: 0.4em;
}
</style>
</head>
<body class="dummySty">

	<c:if test="${notfound !=null}">
        <p>${notfound}<p>
      </c:if>
        
        
<h1 style="color:white;" align="center"><img src="Assets\Images\logopizza.png" width="150px" height="100px">PizzaHut</h1>
        <br>
      <form action="Login" align="center" class="login"> 
        <div class="log">
        <h3>Login</h3>
        </div>
        <label for="email" font-color="white">EMAIL :</label> <br>
        <input type="text" name="email" placeholder="email" pattern="[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}" required><br><br>
        <label for="password">PASSWORD :</label>  <br>
        <input type="password" name="password" placeholder="password" required><br><br>
        <button class="btn btn-primary" type="submit">Login</button>    &nbsp &nbsp &nbsp
        <a href="index.jsp">I'm New Here</a>
        </form>
</body>
</html>