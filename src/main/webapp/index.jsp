 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <link rel ="icon" href="Images/logopizza.png"; >
 
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER</title>
<link rel="stylesheet" type="text/css" href="Assets/css/index.css">
</head>
<body align="center" class="dummySky">                                                                              
<h1 style="color:white;" align="center"><img src="Assets\Images\logopizza.png" width="150px" height="100px">PizzaHut</h1>
<form action="Sample" class="login" align="center" method="post"><br><br>
                                                          
        <h3>CREATE YOUR OWN ACCOUNT</h3><br>
        <label for="NAME">FIRST NAME :</label>      &nbsp &nbsp &nbsp &nbsp &nbsp
        <input type="text" name="firstname" placeholder="firstname" pattern="[a-zA-Z]{3,}" required><br><br>
        
        <label for="EMAIL" >EMAIL :</label>      &nbsp &nbsp  &nbsp &nbsp &nbsp
        <input type="text" name="email" placeholder="abc123@gmail.com" pattern="[a-z]+[a-z0-9]*[@][a-z]+[.][a-z]{2,}" required><br><br>
        
        <label for="PHONENUMBER">PHONENUMBER:</label>       &nbsp &nbsp &nbsp &nbsp &nbsp
        <input type="text" name="phonenumber" placeholder="phonenumber" pattern="[6-9]{1}[0-9]{9}" required><br><br>
        
         <label for="ADDRESS">ADDRESS :</label> &nbsp &nbsp &nbsp &nbsp &nbsp
        <input type="text" name="address" placeholder="address"  required><br><br>
        
        <label for="PASSWORD">PASSWORD :</label> &nbsp &nbsp &nbsp &nbsp &nbsp
        <input type="password" name="password" placeholder="password" pattern="[A-Za-z0-9]+[@][A-Za-z0-9]*"  required><br><br>
        
        <button type="submit">SUBMIT</button> &nbsp &nbsp &nbsp &nbsp &nbsp
        <a href="userlogin.jsp">Already Have Account</a>
</form>
</body>
</html>