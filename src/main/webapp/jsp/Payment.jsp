<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<%
if (cid != null) {%>
<div id="payment">
<h1>Payment Page</h1>
<form action="/DenHibernate/PaymentController" method="post">
<table align="center">
<tr>
<td>Enter the Card Number:</td>
<td><input type="number" name="cardNumber" pattern="[0-9]{13,16}"  max="999999999999999" required="required"></td>
</tr>
<tr>
<td>Enter the Card Holder Name:</td>
<td><input type="text" name="cardHolderName" required="required"></td>
</tr>
<tr>
<td>Select the Card Type:</td>
<td><select name="cardType" required="required">
  <option value="creditCard">Credit card</option>
  <option value="debitCard">Debit Card</option>
  </select>
  </td>
</tr>
<tr>
<td>Enter the Expiry date:</td>
<td><input type="date" name="Edate" ></td>
</tr>
<tr>
<td>Enter the CVV:</td>
<td><input type="number" name="cvv" max="999" min="-999" required="required" ></td>
</tr>
<tr>
<td><input type="submit" value="Pay" ></td>
<td><input type="reset" name="Reset" ></td>
</tr>
</table>
</form>
<%}
else{
request.setAttribute("buynowid", "Please Login in order to Buy and do payment for the product!!!");
RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Login.jsp");
dispatcher.forward(request, response);
}

%>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>