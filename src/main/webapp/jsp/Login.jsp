<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-image: url("/webapp/Images/bg4.jpeg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	width: 100%;
	height: 630px;
}

#login {
	text-align: center;
	padding-top: 150px;
	font-family: cursive;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="login">
		<form action="/DenHibernate/LoginController" method="post">
			<h1>LOGIN HERE</h1>
			<%
				Object cid = request.getAttribute("buynowid");
				if (cid != null) {
			%>
			<h4 style="color: red;"><%=cid%></h4>
			<%
				}
			%>
			<%
				Object addToCart = request.getAttribute("addToCart");
				if (addToCart != null) {
			%>
			<h4 style="color: red;"><%=addToCart%></h4>
			<%
				}
			%>

			<table align="center">
				<tr>
					<td>Enter the UserId:</td>
					<td><input type="email" name="username" required="required">
				</tr>
				<tr>
					<td>Password (UpperCase, LowerCase, Number):</td>
					<td><input type="password" name="password" required="required"
						placeholder="min 8 characters">
				</tr>
			</table>

			<br> <input type="submit" name="submit" value="Login"><br>
			<br> <a href="Registration.jsp">New User?Sign UP</a>
		</form>
	</div>
</body>
</html>
<!-- minlength="8" required="required" placeholder="min 8 characters"
		pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" -->