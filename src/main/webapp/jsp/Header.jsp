<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link href="/DenHibernate/css/Den.css" rel="stylesheet" > 
</head>
<body>
	<div class="header" id="top">
		<h1>Shoppers Den</h1>
		<h3>Find it,Love it,Buy it</h3>
		<!-- <img src="/ShoppersDen/Images/b1.jpg">-->
		<%
			Object cid = session.getAttribute("cid");
			if (cid != null) {
				String name = (String) session.getAttribute("name");
		%>
		<h4>
			Hello!!<%=name%>
		</h4>

		<%
			} else {
		%>
		<h4>Hello User!!Please Login</h4>
		<%
			}
		%>
	</div>
	<div class="subHeader">
		<nav>
			<a  href="/DenHibernate/HomePageController">Home</a>
			<%
				if (cid != null) {
			%>
			<a href="/DenHibernate/LogOutController">LogOut</a>
			<%
				} else {
			%>
			<a href="/DenHibernate/jsp/Login.jsp">Login</a> <a
				href="/DenHibernate/jsp/Registration.jsp">SignUp</a>
			<%
				}
			%>
			<a href="">FAQ</a> <a href="">My Account</a> <a href="">Help</a>
		</nav>
	</div>

</body>
</html>