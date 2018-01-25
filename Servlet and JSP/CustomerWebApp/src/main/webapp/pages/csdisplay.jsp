<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h4>Customer Details</h4>
	<form name="myform" action="CustomerController" method="post"
		onsubmit="return validate()">
		<div>
			<label for="email"> Customer ID:</label> <input type="text"
				id="email" placeholder="Enter Customer ID" name="id" required>
			<p style="color: red;" id="demo"></p>
			<input type='hidden' name='val' value='DIS_CUS' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>

<%
	String vals = request.getParameter("id");

	if (vals != null && vals != "") {
%>
<c:if test="${empty display.firstname}">
	<h3>Customer is not found</h3>
</c:if>
<c:if test="${not empty display.firstname}">

	<article class="article">
		<h1>Customer's Details</h1>
		<table>
			<tr>
				<th>Customer ID</th>
				<th>Title</th>
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>Suffix</th>
				<th>Email</th>
				<th>Company</th>
				<th>Display Name</th>
				<th>Print On Check</th>
			</tr>
			<tr>
				<td>${display.custID}</td>
				<td>${display.title}</td>
				<td>${display.firstname}</td>
				<td>${display.middleName}</td>
				<td>${display.last_name}</td>
				<td>${display.suffix}</td>
				<td>${display.email}</td>
				<td>${display.company}</td>
				<td>${display.displaName}</td>
				<td>${display.printOnCheckAs}</td>
			</tr>
		</table>
	</article>
</c:if>
<%
	}
%>