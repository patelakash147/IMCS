<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h4>Order Details</h4>
	<form name="myform" action="CustomerController" method="post"
		onsubmit="return validate()">
		<div>
			<label for="email"> Customer ID:</label> <input type="text"
				id="email" placeholder="Enter Customer ID" name="id" required>
			<p style="color: red;" id="demo"></p>
			<input type='hidden' name='val' value='DIS_ORD' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<%
String vals=request.getParameter("id");

if(vals!=null && vals!=""){
%>
<c:if test="${empty display.invoiceCreationDate}">
	<h3>Order is not found</h3>
</c:if>
<c:if test="${not empty display.invoiceCreationDate}">

	<article class="article">
		<h1>Order Details</h1>
		<table>
			<tr>
				<th>Order ID</th>
				<th>Invoice Creation Date</th>
				<th>Delivery Due Date</th>
				<th>Payment Due Date</th>
				<th>Custom Message</th>
			</tr>
			<tr>
				<td>${display.orderIDPK}</td>
				<td>${display.invoiceCreationDate}</td>
				<td>${display.deliveryDueDate}</td>
				<td>${display.paymentDueDate}</td>
				<td>${display.customMessage}</td>
			</tr>
		</table>
	</article>
</c:if>
<% } %>