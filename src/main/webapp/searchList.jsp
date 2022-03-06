<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>Insert title here</title>
<style>
	body{
		background-color:Azure;
	}
	.set1{
		border: 1px solid transparent;
		margin-right: 200px;
		margin-left: 200px;
		margin-top: px;
		padding:50px 50px;		
	}
	th,td{
		padding: 7px;
	}
</style>

</head>
<body>
<div class="set1">
	<form action ="SearchEmployee" method = "post">
       
        <label for="empcode">Employee Code</label>
        <input type="text" name="empcode" id="empcode">
        
        <label for="city">City</label>
        <input type="text" name="city" id="city">
        
        <label for="state">State</label>
        <input type="text" name="state" id="state"><br><br>
        
        <label for="fromDate">Joining Date From</label>
        <input type="date" name="fromDate" id="fromDate" >
        
        <label for="toDate">Joining Date To</label>
        <input type="date" name="toDate" id="toDate" >
                
        <button>Search</button>   
    </form>
</div>

<div class="container mt-1">
<table class="table table-hover">
<caption></caption>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>Employee code</th>
		<th>Employee name</th>
		<th>Emailid</th>
		<th>city</th>
		<th>state</th>
	</tr>
	</thead>
<tbody>

<c:set var="i" value="0"/>
<c:forEach items="${searchlist}" var="viewEmployee">
<c:set var="i" value="${i+1}"/>
<tr>

<td>${i}</td>
<td><a href="UpdateEmployeeServ?empcode=${viewEmployee.empCode}">${viewEmployee.empCode}</a></td>
<td><a href="UpdateEmployeeServ?empcode=${viewEmployee.empCode}">${viewEmployee.empName}</a></td>
<td><a href="UpdateEmployeeServ?empcode=${viewEmployee.empCode}">${viewEmployee.email}</a></td>
<td><a href="UpdateEmployeeServ?empcode=${viewEmployee.empCode}">${viewEmployee.city}</a></td>
<td><a href="UpdateEmployeeServ?empcode=${viewEmployee.empCode}">${viewEmployee.state}</a></td>
</tr>

</c:forEach>
</tbody>
</div>
</table>   
</body>
</html>