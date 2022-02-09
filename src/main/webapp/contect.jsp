<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cuntect Us</title>
<link rel="stylesheet" type="text/css" href="Assets/css/contect.css">

</head>
<body>
<h1>Contect Us</h1>
<ul>  
<li><a href="showproducts.jsp">Home</a></li>
  <li> <a href="showorder.jsp?orderId=0">MyOrders</a></li>
  <li><a href="showcart.jsp">Mycart</a></li>  
  <li> <a href="userdetails.jsp">Account</a></li>
  <li><a href="walletrecharge.jsp">RechargeWallet</a></li>   
  <li style="float:right"><a href="userlogin.jsp">Logout</a></li>
  <li><a href="contect.jsp">Contact</a></li>
</ul><br>
  <div class="wrapper">
    <form class="form">
      <div class="pageTitle title"> </div>
      <div class="secondaryTitle title">Please fill details.</div>
      <input type="text" class="name formEntry" placeholder="Name" required>
      <input type="text" class="email formEntry" placeholder="Email" required>
      <textarea class="message formEntry" placeholder="Message" required></textarea>
      <input type="checkbox" class="termsConditions" value="Term">
      <label style="color: grey" for="terms"> I Accept the <span style="color: #0e3721">Terms of Use</span>  <span style="color: #0e3721">Privacy Policy</span>.</label><br>
      <a href="showproducts.jsp"><button class="submit formEntry" onclick="thanks()">Submit</button></a>
    </form>
  </div>
 
</body>
 <script>
  function thanks() {

	  alert("submitted successfully");
  }
  </script>
</html>