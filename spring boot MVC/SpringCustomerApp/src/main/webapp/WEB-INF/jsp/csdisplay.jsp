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
