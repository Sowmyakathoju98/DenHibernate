<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			Hello!!<%=cid%>
		</h4>

		<%
			}
			%>
	</div>
	<div class="subHeader">
		<nav>
		
			<a  href="/DenHibernate/AdminController">Home</a>
		
			<a href="/DenHibernate/LogOutController">LogOut</a>
			
			</nav>
	</div>
	<table>
		<tr>
			<td colspan="2"><button>
					<a href="/DenHibernate/AddCategoryController">Add Category</a>
				</button></td>
		</tr>
		<tr>
			<td colspan="2"><button>
					<a href="/DenHibernate/AddProductController">Add Product</a>
				</button></td>
		</tr>
		<tr>
			<td colspan="2"><button>
					<a href="/DenHibernate/DeleteCategoryController">Delete Category</a>
				</button></td>
		</tr>
		<tr>
			<td colspan="2"><button>
					<a href="/DenHibernate/DeleteProductController">Delete Product</a>
				</button></td>
		</tr>
		<tr>
			<td colspan="2"><button>
					<a href="/DenHibernate/ViewProductController">View Product</a>
				</button></td>
		</tr>
	</table>
</body>
</html>