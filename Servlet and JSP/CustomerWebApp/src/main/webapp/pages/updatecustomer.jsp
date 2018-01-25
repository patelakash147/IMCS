<div>
	<h4>Enter Details for UPDATE cuctomer</h4>
	<form name="myform" action="CustomerController" method="post"
		onsubmit="return validate()">
		<div>
			<br>
			<label for="email">ID:</label> <input type="text"
				placeholder="Enter Title" name="id" required>
			<p style="color: red;" id="demo"></p>
			<br>
			<label for="email">Title:</label> <input type="text"
				placeholder="Enter Title" name="title"> <br>
			<label for="email">Fristname:</label> <input type="text"
				placeholder="Enter Firstname" name="fname"> <br>
			<label for="email">Middle name:</label> <input type="text"
				placeholder="Enter Middlename" name="mname"> <br>
			<label for="email">Lastname :</label> <input type="text"
				placeholder="Enter Lastname" name="lname"> <br>
			<label for="email">Suffix:</label> <input type="text"
				placeholder="Enter suffix" name="suffix"> <br>
			<label for="email">Email ID:</label> <input type="text"
				placeholder="Enter email" name="email"> <br>
			<label for="email">Company Name:</label> <input type="text"
				placeholder="Enter Company" name="company"> <br>
			<label for="email"> Display ID:</label> <input type="text"
				placeholder="Enter Display name" name="display"> <br>
			<label for="email">printed on check:</label> <input type="text"
				placeholder="Enter name print on check" name="check"> <input
				type='hidden' name='val' value='UPD_CUS' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<%
	String vals = request.getParameter("id");

	if (vals != null && vals != "") {
%>
<H1>Customer Updated</H1>
<% }%>