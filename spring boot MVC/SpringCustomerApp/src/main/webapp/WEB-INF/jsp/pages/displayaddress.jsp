<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td>${user.billingState}</td>
				<td>${user.billingCity}</td>
				<td>${user.billingState}</td>
				<td>${user.billingZip}</td>
				<td>${user.billingCountry}</td>
				<td>${user.shippingStreet}</td>
				<td>${user.shippingCity}</td>
				<td>${user.shippingState}</td>
				<td>${user.shippingZip}</td>
				<td>${user.otherDetails}</td>
			</tr>
		</table>
	</article>