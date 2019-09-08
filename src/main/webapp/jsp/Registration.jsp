<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("/DenORM/Images/bg4.jpeg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	width: 100%;
	height: 630px;
}

#registration {
	text-align: center;
	padding-top: 80px;
	font-family: cursive;
}
</style>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<div id="registration">
		<h1>Register Here</h1>
		<form action="/DenHibernate/RegistrationController" method="post">
			<center>
				<table>
					<tr>
						<td>Enter Your Name:</td>
						<td><input type="text" name="name" required="required"
							pattern="[a-zA-Z][a-zA-Z]+">
					</tr>
					<tr>
						<td>Enter Your Email:</td>
						<td><input type="email" name="email" required="required">
					</tr>
					<tr>
						<td>Password (UpperCase, LowerCase, Number):</td>
						<td><input type="password" placeholder="Choose your password"
							name="password" minlength="8"
							pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$"
							required="required">
					</tr>
					<tr>
						<td>Enter Your Address:</td>
						<td><input type="text" name="address" required="required">
					</tr>
					<tr>
						<td>Enter Your DOB:</td>
						<td><input type="date" name="dob" required="required">
					</tr>
					<tr>
						<td>Enter Your Contact:</td>
						<td><input type="number" name="contact" pattern="[0-9]*"
							minlength="10" required="required">
					</tr>
					<tr>
						<td>Enter Your City:</td>
						<td><input type="text" name="city"
							pattern="[a-zA-Z][a-zA-Z]+" required="required">
					</tr>
					<tr>
						<td>Enter Your State:</td>
						<td><input type="text" name="state"
							pattern="[a-zA-Z][a-zA-Z]+" required="required">
					</tr>
				</table>
			</center>
			<br> <input style="margin-left: 8%;" type="submit"
				value="Register"><br> <a href="Login.jsp"
				style="margin-left: 3%;">Already Having Account?Login In</a>
		</form>
	</div>
</body>
</html>