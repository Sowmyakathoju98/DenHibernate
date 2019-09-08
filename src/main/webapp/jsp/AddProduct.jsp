<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		<nav> 
 
 
  <a href="/DenHibernate/AdminController">Home</a> 
 	<a href="/DenHibernate/LogOutController">LogOut</a> </nav>
	</div>
	
	<form action="/DenHibernate/AddProductController" method="post">
		<table>
			<tr>
				<td>Enter Product Name:</td>
				<td><input type="text" name="productName"></td>
			</tr>
			<tr>
				<td>Choose Product Image:</td>
				<td><input type="file" name="productImage"></td>
			</tr>
			<tr>
				<td>Choose Product Category:</td>
				<td><select name="productCategory">
						
						<c:forEach var="l" items="${requestScope.l}">
						<option value="${l.categoryId}">${l.categoryName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter Product Price:</td>
				<td><input type="text" name="productPrice"></td>
			</tr>
			<tr>
				<td>Enter Product Quantity:</td>
				<td><input type="number" name="productQuantity"></td>
			</tr>
			<tr>
				<td>Enter Product Description:</td>
				<td><textarea name="productDesc"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Product"></td>
			</tr>
		</table>
	</form>
</body>
</html>