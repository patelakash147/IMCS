<div>
	<h4>Add Address</h4>
	<form name="myform" action="CustomerController" method="post"
		onsubmit="return validate()">
		<div>
			<br>
			<label for="email">Id:</label> <input type="text"
				placeholder="Enter Customer Id" name="id" required>
			<p style="color: red;" id="demo"></p>
			<br>
			<label for="email">Billing Street:</label> <input type="text"
				placeholder="Enter Billing Street" name="bstreet" required>
			<br>
			<label for="email">Billing City:</label> <input type="text"
				placeholder="Enter Billing City" name="bcity" required> <br>
			<label for="email">Billing State:</label> <input type="text"
				placeholder="Enter Billing State" name="bstate" required> <br>
			<label for="email">Billing Zip:</label> <input type="text"
				placeholder="Enter Billing Zip" name="bzip" required> <br>
			<label for="email">Billing Country</label> <input type="text"
				placeholder="Enter Billing Country" name="bcountry" required>
			<br>
			<label for="email">Shipping Street</label> <input type="text"
				placeholder="Enter Shipping Street" name="sstreet" required>
			<br>
			<label for="email">Shipping City</label> <input type="text"
				placeholder="Enter Shipping City" name="scity" required> <br>
			<label for="email">Shipping State</label> <input type="text"
				placeholder="Enter Shipping State " name="sstate" required>
			<br>
			<label for="email">Shipping Zip</label> <input type="text"
				placeholder="Enter Shipping Zip" name="szip" required> <br>
			<label for="email">Shipping Country</label> <input type="text"
				placeholder="Enter Shipping Country" name="scountry" required>
			<br>
			<label for="email">Other Details</label> <input type="text"
				placeholder="Enter Other Details" name="odetails"> <input
				type='hidden' name='val' value='ADD_ADD' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<%
	String vals = request.getParameter("id");

	if (vals != null && vals != "") {
%>
<H1>Address Added</H1>
<% }%>