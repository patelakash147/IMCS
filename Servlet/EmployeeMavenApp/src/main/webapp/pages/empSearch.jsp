<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
h2{
color :red
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
<body>
	<center>
	<form action="EmployeeSearch" method="post">
		<h1>Enter Employee Number</h1><br> <input type="text" name="empNumber" placeholder="Enter here">
		<br> <input type="submit" value="Submit">
	</form>
	<%
String vals=request.getParameter("empNumber");

if(vals!=null && vals!=""){
%>
	<table border=1>
		<tr>
			<th>Employee id</th>
			<th>Employee number</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Date of birth</th>
			<th>Age</th>
		</tr>
		<tr>
			<th>${emp.getId()}</th>
			<th>${emp.getNumber()}</th>
			<th>${emp.getName()}</th>
			<th>${emp.getSalary()}</th>
			<th>${emp.getDoj()}</th>
			<th>${emp.getAge()}</th>

		</tr>
	</table>
   <H2>${error}</H2> 
	<% } %>
	</center>
</body>
</html>