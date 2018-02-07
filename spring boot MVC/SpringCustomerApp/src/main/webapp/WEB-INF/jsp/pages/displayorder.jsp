<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:forEach items="${user}" var="listItem">
			<tr>
				<td><button><a href="product/${listItem.order_ID_PK}">${listItem.order_ID_PK}</a></button></td>
				<td>${listItem.invoiceCreationDate}</td>
				<td>${listItem.deliveryDueDate}</td>
				<td>${listItem.paymentDueDate}</td>
				<td>${listItem.customMessage}</td>
			</tr>
		</c:forEach>
	</table>
</article>
