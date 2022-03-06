<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		background-color:Azure;
	}
	.set1{
		border: 1px solid black;
		margin-right: 400px;
		margin-left: 400px;
		margin-top: 70px;
		padding:50px 50px;		
	}

</style>
</head>
<body>
<div class="set1">
	<form action ="EmployeeRegisterServ" method = "post">
        <label for="name">Employee Name</label>
        <input type="text" id="username" name="empname" pattern="[A-Za-z]{5,}" required><br><br>
        
        <label for="empcode">Employee Code</label>
        <input type="text" name="empcode" id="empcode" required><br><br>
        
        <label for="email">Email Address</label>
        <input type="email" name="email" id="email" required><br><br>
        
        <label for="address">Address Line1</label>
        <input type="text" name="address1" id="address" required><br><br>
       
       	<label for="address">Address Line2</label>
        <input type="text" name="address2" id="addvress"><br><br>
        
        <label for="city">City</label>
        <input type="text" name="city" id="city" required><br><br>
        
        <label for="state">State</label>
        <input type="text" name="state" id="state" required><br><br>
        
        <label for="DOB">Date Of Birth</label>
        <input type="date" name="dob" id="DOB" required><br><br>
        
        <label for="DOJ">Date Of Joining</label>
        <input type="date" name="doj" id="DOJ" required><br><br>
                
        <button>Register</button> 
        <input type="reset" name="reset"><br><br> 
    </form>
</div>

<c:if test="${sessionScope.insert!=null}">
	<h4>${sessionScope.insert}</h4>
</c:if>
<c:remove var="insert" scope="session" />


</body>
</html>