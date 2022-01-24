<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update user details</title>
<style>
 label{
            width:130px;
            display: inline-block;
        }
</style>
</head>
<body>
	<form align="center" action="updateproduct">
		<h3>change your details</h3>
        <label for="name"> name :</label>
        <input type="text" name="name"><br><br>
        <label for="name">e-mail :</label>
        <input type="text" name="size"><br><br>
        <label for="name">Phonenumber :</label>
        <input type="text" name="price"><br><br>  
        <label for="name">Address :</label>
        <input type="text" name="size"><br><br>
        <label for="name">Password :</label>
        <input type="text" name="price"><br><br> 
        <button onclick="demo()">UPDATE</button>
        <button type="reset">RESET</button>
        <a href="AddDeleteUpdate.jsp">BACK</a>
        <script>
function demo() {
alert("product updated successfully");
}
</script>
 </form>
</body>
</html>