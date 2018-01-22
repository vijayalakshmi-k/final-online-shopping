<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyMobiles</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/checkout.jsp"></jsp:include>

<div class="container">
<div class="col-xs-6 jumbotron">
<div class="row">
<div class="head">
<label>customer shipping details</label>
</div>


<div class="outer">

<div class="well" style="width 100%">
<form action ="${pageContext.request.contextPath}/invoiceprocesss" method="post">
<c:set var="gtot" value="0"/>
<c:forEach var="c" items="${cart}">
<c:set var="gtot" value="${gtot+p.price*p.qty}"></c:set>




<div class="well">
<table>
<tr>
<td colspan="3">Name</td>
<td>${user.name}</td></tr>

<tr>
<td colspan="3">Email</td>
<td>${user.email}</td></tr>
<tr>
<td colspan="3">Address</td>
<td>${user.address}</td></tr>
<tr>
<td colspan="3">phone</td>
<td>${user.phone}</td></tr>
<tr>
</table>
<div class="outer">
<h3>Enter Payment details</h3>
<br>
<label>Select Payment</label>
<select name="payment">
<option value"COD">cash on delivery</option>
<option value="Net">Net Banking</option>
</select>
<br><br>
<div>
Name:<input type="text" name="name on card">
Card Number:<input type="number" name="card Number">
<input type="hidden" name="total" value="${gtot}">
</div>
</div>
<input type="submit" value="proceed" style="width:75%" class="btn btn-danger">
</div></c:forEach>
</div>
</div>
</form>
</div>
</div>
</div>
</body>
</html>