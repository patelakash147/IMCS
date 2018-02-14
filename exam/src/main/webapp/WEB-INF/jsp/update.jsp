<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function validate() {
		var num = document.myform.id.value;
		if (isNaN(num)) {
			document.getElementById("demo").innerHTML = "Enter Numeric value only";
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div>
	<h4>Enter Details for UPDATE Flight details</h4>
	<form name="myform" action="update" method="post"
		>
		<div>
		
			<label for="email">flight id:</label> <input type="text"  name="title"> <br>
			<label for="email">airline id:</label> <input type="text" name="fname"> <br>
			<label for="email">airline Name:</label> <input type="text" name="mname"> <br>
			<label for="email">origin :</label> <input type="text" name="lname"> <br>
			<label for="email">destination:</label> <input type="text" name="suffix"> <br>
			<label for="email">departure time:</label> <input type="text" name="email"> <br>
			<label for="email">arrival time:</label> <input type="text" name="company"> <br>
			<label for="email"> duration:</label> <input type="text" name="display"> <br>
			<label for="email">total seat:</label> <input type="text" name="check">
			<label for="email">price:</label> <input type="text" name="check">
			<label for="email">available seat:</label> <input type="text" name="check">
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<h1>${message}</h1>
</body>
</html>