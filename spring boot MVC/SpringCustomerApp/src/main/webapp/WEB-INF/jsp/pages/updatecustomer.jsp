<div>
	<h4>Enter Details for UPDATE cuctomer</h4>
	<form name="myform" action="update" method="post"
		>
		<div>
			<label for="email"></label><br>
			<label for="email">Id: ${sessionScope.sid}</label>
			<p style="color: red;" id="demo"></p>
			<label for="email">Title:</label> <input type="text"
				value=${user.title}  name="title"> <br>
			<label for="email">Fristname:</label> <input type="text"
				value=${user.firstName} name="fname"> <br>
			<label for="email">Middle name:</label> <input type="text"
				value=${user.middleName} name="mname"> <br>
			<label for="email">Lastname :</label> <input type="text"
				value=${user.lastName} name="lname"> <br>
			<label for="email">Suffix:</label> <input type="text"
				value=${user.suffix} name="suffix"> <br>
			<label for="email">Email ID:</label> <input type="text"
				value=${user.email} name="email"> <br>
			<label for="email">Company Name:</label> <input type="text"
				value=${user.company} name="company"> <br>
			<label for="email"> Display ID:</label> <input type="text"
				value=${user.displayName} name="display"> <br>
			<label for="email">printed on check:</label> <input type="text"
				value=${user.printOnCheckAs} name="check"> <input
				type='hidden' name='val' value='UPD_CUS' />
		</div>
		<button type="submit">Submit</button>
	</form>
</div>
<h1>${message}</h1>
