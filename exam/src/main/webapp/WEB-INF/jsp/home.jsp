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
	<div class="flex-container">
		<div>
	<h4>Search Flight Details</h4>
	<a href="/update">Update flight</a>
	<form name="search" action="display" method="post"
		onsubmit="return validate()">
		<div>
			<label for="email"> Customer ID:</label> <input type="text"
				id="email" placeholder="Enter Customer ID" name="id" required>
				<label for="email"> Departure Date:</label> <input type="text"
				id="email" placeholder="Enter Customer ID" name="date" required>
			<p style="color: red;" id="demo"></p>
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<c:if test="${not empty user.airlineName}">
	<h1>Customer's Details</h1>
	<table>
		<tr>
			<th>Airline ID</th>
			<th>Airline Name</th>
			<th>Origin(From Location)</th>
			<th>Destination(To Location)</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th>Duration</th>
			<th>Total Seats</th>
			<th>Available Seats</th>
		</tr>
		<tr>
			<td>${user.airlineId}</td>
			<td>${user.airlineName}</td>
			<td>${user.fromLocation}</td>
			<td>${user.toLocation}</td>
			<td>${user.departureTime}</td>
			<td>${user.arrivalTime}</td>
			<td>${user.duration}</td>
			<td>${user.totalSeats}</td>
			<td>${user.flightDetail.getAvailableSeats()}</td>
		</tr>
	</table>
</c:if>
	</div>
</body>
</html>