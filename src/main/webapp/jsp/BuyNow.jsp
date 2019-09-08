<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="/DenHibernate/BuyNowController" method="post">
		<h2>The Following product is the one you Ordered</h2>
		<input type="hidden" value="${requestScope.product.productId }"><br>
		<table border="2" align="center">
			<tr>
				<td>ProductImage</td>
				<td>ProductName</td>
				<td>ProductPrice</td>
				<td>ProductDescription</td>
				<td>Quantity</td>
				<td>Buy Now</td>
			</tr>
			<tr>
				<td><img
					src="/DenHibernate/Images/${requestScope.product.productImage }"></td>
				<td><input type="hidden"
					value="${requestScope.product.productName }" name="productName">${requestScope.product.productName }</td>
				<td><input type="hidden"
					value="${requestScope.product.productPrice }" name="productPrice">${requestScope.product.productPrice }</td>
				<td>${requestScope.product.productDescription }</td>
				<td>Please Enter The Quantity:<br> <input type="text"
					name="quantity"></td>
				<td><input type="submit" name="BuyNow"
					value="Proceed To Payment"></td>
			</tr>
		</table>

	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>