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
				placeholder="Enter Billing Street" name="bstreet"> <br>
			<label for="email">Billing City:</label> <input type="text"
				placeholder="Enter Billing City" name="bcity"> <br>
			<label for="email">Billing State:</label> <input type="text"
				placeholder="Enter Billing State" name="bstate"> <br>
			<label for="email">Billing Zip:</label> <input type="text"
				placeholder="Enter Billing Zip" name="bzip"> <br>
			<label for="email">Billing Country</label> <input type="text"
				placeholder="Enter Billing Country" name="bcountry"> <br>
			<label for="email">Shipping Street</label> <input type="text"
				placeholder="Enter Shipping Street" name="sstreet"> <br>
			<label for="email">Shipping City</label> <input type="text"
				placeholder="Enter Shipping City" name="scity"> <br>
			<label for="email">Shipping State</label> <input type="text"
				placeholder="Enter Shipping State " name="sstate"> <br>
			<label for="email">Shipping Zip</label> <input type="text"
				placeholder="Enter Shipping Zip" name="szip"> <br>
			<label for="email">Shipping Country</label> <input type="text"
				placeholder="Enter Shipping Country" name="scountry"> <br>
			<label for="email">Other Details</label> <input type="text"
				placeholder="Enter Other Details" name="odetails"> <input
				type='hidden' name='val' value='UPD_ADD' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<%
	String vals = request.getParameter("id");

	if (vals != null && vals != "") {
%>
<H1>Address Updated</H1>
<% }%>