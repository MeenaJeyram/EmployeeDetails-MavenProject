<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action ="RegisterServlet" method = "post">
        <label for="username">Name</label>
        <input type="text" id="username" name="username" value="Meena" pattern="[A-Za-z]{5,}" required><br><br>
        <label for="phoneno">Phone Number</label>
        <input type="phone" name="phonenumber" id="phoneno"  pattern="[6-9][0-9]{9}" required><br><br>
        <label for="address">Address</label>
        <input type="text" name="address" id="address" pattern = "[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}" required><br><br>
        <label for="email">Email Address</label>
        <input type="email" name="email" id="email"  pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
        <label for="password">Password</label>
        <input type="password" name="password" pattern="[A-Za-z0-9]{8,10}" required><br><br>
        <button>Register</button>
    </form>
</body>
</html>