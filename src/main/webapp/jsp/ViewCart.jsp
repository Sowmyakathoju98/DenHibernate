<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function MyCart(){
	alert("Deleted");
}</script>
</head>

<body>
<%@ include file="Header.jsp" %>
<table align="center" style="text-align: center" cellpadding="5"
					cellspacing="5" border="1">
					<tr>
						<td>PRODUCTIMAGE</td>
						<td>PRODUCT NAME</td>
						<td>PRODUCT PRICE</td>
						<td>CART DATE</td>
						<td>DELETE ITEM</td>
						<td>BUY NOW</td>
					</tr>
			 		<form action="/DenHibernate/BuyNowController" method="get"> 
						<c:forEach items="${ sessionScope.CartList }" var="cart">
							<tr>
								<td><img src="/DenHibernate/Images/${cart.product.productImage }"></td>
								<td>${cart.product.productName }</td>
								<td>${cart.product.productPrice }</td>
								<td>${cart.cartDate}</td>
								<td><a href="/DenHibernate/DeleteCartItemController?cid=${cart.cartId}" onclick="return MyCart()">Delete Item</a></td>
								<td><input type="submit" name="buynow" value="Buy now"></td>
							</tr>
						</c:forEach>
						</form>
				</table>
<%@ include file="Footer.jsp" %>
</body>
</html>