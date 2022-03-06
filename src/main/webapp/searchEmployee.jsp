<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		margin-right: 200px;
		margin-left: 200px;
		margin-top: px;
		padding:50px 50px;		
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
</body>
</html>