<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/DenHibernate/css/Den.css" rel="stylesheet">
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
			Hello!!<%=cid%>
		</h4>

		<%
			}
			%>
	</div>
	<div class="subHeader">
		<nav> <a href="/DenHibernate/AdminController">Home</a> <a
			href="/DenHibernate/LogOutController">LogOut</a> </nav>
	</div>
	<h1>List Of Categories</h1>
	<ul>
		<c:forEach items="${requestScope.CategoryDetail}"
							var="CategoryDetail">
							<li>${CategoryDetail.categoryName}</li>
						</c:forEach>
	</ul>
	<form action="/DenHibernate/DeleteCategoryController" method="post">
		<table>
			<tr>
				<td>Choose Category Name:</td>
				<td><select name="productCategory">
						<c:forEach items="${requestScope.CategoryDetail}"
							var="CategoryDetail">
							<li>${CategoryDetail.categoryName}</li>
						
						<option value=${CategoryDetail.categoryId}>${CategoryDetail.categoryName}</option>
						</c:forEach>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Delete Category">
	</form>
</body>
</html>