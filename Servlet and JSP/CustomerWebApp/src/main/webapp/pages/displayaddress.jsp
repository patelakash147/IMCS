<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h4>Address Details</h4>
	<form name="myform" action="CustomerController" method="post"
		onsubmit="return validate()">
		<div>
			<label for="email">Customer ID:</label> <input type="text" id="email"
				placeholder="Enter Customer id" name="id" required>
			<p style="color: red;" id="demo"></p>
			<input type='hidden' name='val' value='DIS_ADD' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>

<%
	String vals = request.getParameter("id");

	if (vals != null && vals != "") {
%>
<c:if test="${empty display.billingStreet}">
	<h3>Customer is not found</h3>
</c:if>
<c:if test="${not empty display.billingStreet}">
	<article class="article">
		<h1>Customer's Details</h1>
		<table>
			<tr>
				<th>Billing Street</th>
				<th>Billing City</th>
				<th>Billing State</th>
				<th>Billing Zip</th>
				<th>Billing Country</th>
				<th>Shipping Street</th>
				<th>Shipping City</th>
				<th>Shipping State</th>
				<th>Shipping Country</th>
				<th>Other Details</th>
			</tr>
			<tr>
				<td>${display.billingStreet}</td>
				<td>${display.billingCity}</td>
				<td>${display.billingState}</td>
				<td>${display.billingZip}</td>
				<td>${display.billingCountry}</td>
				<td>${display.shippingStreet}</td>
				<td>${display.shippingCity}</td>
				<td>${display.shippingState}</td>
				<td>${display.shippingZip}</td>
				<td>${display.otherDetails}</td>
			</tr>
		</table>
	</article>
</c:if>
<%
	}
%>