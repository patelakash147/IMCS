<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h4>Customer Details</h4>
	<form name="myform" action="display" method="post"
		onsubmit="return validate()">
		<div>
			<label for="email"> Customer ID:</label> <input type="text"
				id="email" placeholder="Enter Customer ID" name="id" required>
			<p style="color: red;" id="demo"></p>
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<c:if test="${not empty user.firstName}">
<article class="article">
	<h1>Customer's Details</h1>
	<table>
		<tr>
			<th>Title</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Suffix</th>
			<th>Email</th>
			<th>Company</th>
			<th>user Name</th>
			<th>Print On Check</th>
		</tr>
		<tr>
			<td>${user.title}</td>
			<td>${user.firstName}</td>
			<td>${user.middleName}</td>
			<td>${user.lastName}</td>
			<td>${user.suffix}</td>
			<td>${user.email}</td>
			<td>${user.company}</td>
			<td>${user.displayName}</td>
			<td>${user.printOnCheckAs}</td>
		</tr>
	</table>
</article>
</c:if>