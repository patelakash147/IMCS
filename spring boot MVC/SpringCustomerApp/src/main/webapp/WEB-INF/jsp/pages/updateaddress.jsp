<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h4>Update Address</h4>
	<form name="myform" action="update" method="post">
		<div>
		<c:set var="para" value="${sessionScope.sid}" scope="session"  />
			<br>
			<label for="email">Id: ${sessionScope.sid}</label> 
			<br>
			<label for="email">Billing Street:</label> <input type="text"
				value=${user.billingState} name="bstreet"> <br>
			<label for="email">Billing City:</label> <input type="text"
				value=${user.billingCity} name="bcity"> <br>
			<label for="email">Billing State:</label> <input type="text"
				value=${user.billingState} name="bstate"> <br>
			<label for="email">Billing Zip:</label> <input type="text"
				value=${user.billingZip} name="bzip"> <br>
			<label for="email">Billing Country</label> <input type="text"
				value=${user.billingCountry} name="bcountry"> <br>
			<label for="email">Shipping Street</label> <input type="text"
				value=${user.shippingStreet} name="sstreet"> <br>
			<label for="email">Shipping City</label> <input type="text"
				value=${user.shippingState} name="scity"> <br>
			<label for="email">Shipping State</label> <input type="text"
				value=${user.shippingStreet} name="sstate"> <br>
			<label for="email">Shipping Zip</label> <input type="text"
				value=${user.shippingZip} name="szip"> <br>
			<label for="email">Shipping Country</label> <input type="text"
				value=${user.shippingCountry} name="scountry"> <br>
			<label for="email">Other Details</label> <input type="text"
				value=${user.otherDetails} name="odetails"> 
				
		</div>
		<button type="submit">Submit</button>
	</form>
</div>

