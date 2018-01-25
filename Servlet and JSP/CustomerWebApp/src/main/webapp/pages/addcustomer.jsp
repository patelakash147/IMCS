<div>
	<h4>Enter Details</h4>
	<form action="CustomerController" method="post">
		<div>
			<br>
			<label for="email">Title:</label> <input type="text"
				placeholder="Enter Title" name="title"> <br>
			<label for="email">Fristname:</label> <input type="text"
				placeholder="Enter Firstname" name="fname" required> <br>
			<label for="email">Middle name:</label> <input type="text"
				placeholder="Enter Middlename" name="mname"> <br>
			<label for="email">Lastname :</label> <input type="text"
				placeholder="Enter Lastname" name="lname" required> <br>
			<label for="email">Suffix:</label> <input type="text"
				placeholder="Enter suffix" name="suffix"> <br>
			<label for="email">Email ID:</label> <input type="text"
				placeholder="Enter email" name="email" required> <br>
			<label for="email">Company Name:</label> <input type="text"
				placeholder="Enter Company" name="company"> <br>
			<label for="email"> Display ID:</label> <input type="text"
				placeholder="Enter Display name" name="display"> <br>
			<label for="email">printed on check:</label> <input type="text"
				placeholder="Enter name print on check" name="check" required>
			<input type='hidden' name='val' value='ADD_CUS' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<%
	String vals = request.getParameter("fname");

	if (vals != null && vals != "") {
%>
<H1>Customer Added</H1>
<% }%>