<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Update Employees</title>
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
	<form action ="UpdateDetailsServ" method = "post">
	
		<c:forEach items="${emplist}" var="emplist">
		
        <label for="name">Employee Name</label>
        <input type="text" id="username" name="empname" pattern="[A-Za-z]{5,}" value='<c:out value="${emplist.empName}"></c:out>' required><br><br>
        
        <label for="empcode">Employee Code</label>
        <input type="text" name="empcode" id="empcode" value='<c:out value="${emplist.empCode}"></c:out>' required><br><br>
        
        <label for="email">Email Address</label>
        <input type="email" name="email" id="email" value='<c:out value="${emplist.email}"></c:out>' required><br><br>
        
        <label for="address">Address Line1</label>
        <input type="text" name="address1" id="address" value='<c:out value="${emplist.address1}"></c:out>' required><br><br>
       
       	<label for="address">Address Line2</label>
        <input type="text" name="address2" id="address" value='<c:out value="${emplist.address2}"></c:out>'><br><br>
        
        <label for="city">City</label>
        <input type="text" name="city" id="city" value='<c:out value="${emplist.city}"></c:out>' required><br><br>
        
        <label for="state">State</label>
        <input type="text" name="state" id="state" value='<c:out value="${emplist.state}"></c:out>' required><br><br>
        
        <label for="DOB">Date Of Birth</label>
        <input type="date" name="dateofbirth" id="DOB" value='<c:out value="${emplist.dateOfBirth}"></c:out>' required><br><br>
        
        <label for="DOJ">Date Of Joining</label>
        <input type="date" name="joiningdate" id="DOJ" value='<c:out value="${emplist.joiningDate}"></c:out>' required><br><br>
                
        <button>Update</button> 
        <input type="reset" name="reset"><br><br>
        </c:forEach> 
    </form>
</div>

</body>
</html>