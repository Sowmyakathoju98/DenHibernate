<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/DenHibernate/css/Den.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Home Page</title>
<script>
	function mycart() {
		alert("Added Successfully");
	}
</script>
</head>
<body>
	<div class="Container">
		<div class="header" id="top">
			<h1>Shoppers Den</h1>
			<h3>Find it,Love it,Buy it</h3>
			<!-- <img src="/DenFirst/Images/b1.jpg">-->
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
				<a id="aa" href="/DenHibernate/HomePageController">Home</a>
				<%
					if (cid != null) {
				%>
				<a href="/DenHibernate/LogOutController">LogOut</a> <a
					href="/DenHibernate/MyCartController">My Cart</a>
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
		<div>
			<form action="/DenHibernate/SearchController" method="post"
				style="margin-top: 10px; text-align: center;">
				<input type="search" placeholder="Search Product here"
					name="searchText" class="searchtext"> <input type="submit"
					value="Search" name="search" class="searchButton">
			</form>
		</div>
		<div id="products">
			<%
				Object list = request.getAttribute("list");
				if (list == null) {
			%>
			<table align="center" id="mytable" style="text-align: center"
				cellpadding="5" cellspacing="5" border="1">
				<tr>
					<td>PRODUCTIMAGE</td>
					<td>PRODUCT NAME</td>
					<td>PRODUCT PRICE</td>
					<td>PRODUCT DESCRIPTION</td>
					<td>CHOOSE</td>
					<td>CHOOSE</td>
				</tr>
				<c:forEach items="${ sessionScope.pList }" var="product">
					<tr>
						<form action="/DenHibernate/BuyNowController" method="get">
							<td><input type="hidden" value="${product.productImage}" name="productImage"
							><img src='/DenHibernate/Images/${product.productImage}'></td>
							<input type="hidden" value="${product.productId}"
								name="productId" id="productId">
							<td><input type="hidden" value="${product.productName}"
								name=productName>${product.productName}</td>
							<td><input type="hidden" value="${product.productPrice}"
								name=productPrice>${product.productPrice}</td>
							<td><input type="hidden" value="${product.productDescription}" name="productDesc">${product.productDescription}</td>
							<!-- <td>Enter Quantity:<input type="text"  id="orderQuantity"
							name="orderQuantity"></td> -->
							<!-- 						<td><input type=button  -->
							<!-- 						onClick="redirect()" value='Add to Cart'></td> -->
							<td><a
								href="/DenHibernate/AddToCartController?pid=${product.productId}"
								onclick="mycart()">Add to Cart </a></td>
							<td><input type="submit" name="buynow" value="Buy now"></td>
						</form>
					</tr>
				</c:forEach>
				<%
					} else {
				%>
				<table align="center" style="text-align: center" id="mytable"
					cellspacing="5" border="1">
					<tr>
						<td>PRODUCTIMAGE</td>
						<td>PRODUCT NAME</td>
						<td>PRODUCT PRICE</td>
						<td>PRODUCT DESCRIPTION</td>
						<td>CHOOSE</td>
						<td>CHOOSE</td>
					</tr>
					<form action="/DenHibernate/BuyNowController" method="get">
						<c:forEach items="${ requestScope.list }" var="product">
							<tr>
								<td><img
									src="/DenHibernate/Images/${product.productImage }"></td>
								<input type="hidden" name="productId" id="productId"
									value="${product.productId }">
								<td name="productName"><input type="hidden"
									name="productName" value="${product.productName }">${product.productName }</td>
								<td name="productPrice"><input type="hidden"
									name="productPrice" value="${product.productPrice }">${product.productPrice }</td>
								<td name="productDesc">${product.productDescription }</td>
								<td>Enter Quantity:<input type="text" name="orderQuantity"
									id="orderQuantity"></td>
								<%
									session.setAttribute("searchid", "hello");
								%>
								<td><a
									href="/DenHibernate/AddToCartController?pid=${product.productId}&oq=5"
									onclick="return myCart()">Add to Cart </a></td>
								<!-- 								<td><input type=button onClick="redirect()" value='Add to Cart'></td> -->
								<td><input type="submit" name="buynow" value="Buy now">
								</td>
							</tr>
						</c:forEach>
					</form>
				</table>
				<%
					}
				%>
			</table>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>