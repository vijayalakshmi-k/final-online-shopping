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
<jsp:include page="/WEB-INF/views/Cart.jsp"></jsp:include>

<div class="container">
<h2>Here your Cart</h2>
<table class="table table-hover" id="apl" class="display" border="2" width="80" align="center"></table>
<tr>
<th>Product name</th>th> 
<th>Product price</th>
<th>product quantity</th>
<th>product image</th>
<th>sub total</th>
<th>Action</th>
</tr>

<c:if test="${empty cart info}">
<tr>
<td colspan="10" align="center">No record exist!!</td></tr>
</c:if>

<c:forEach var="p" varstatus="st" items="${cartinfo}">
<tr>
<td><c:out value="${p.name}"></c:out></td>
<td><c:out value="${p.qty}"></c:out></td>
<td><c:out value="${p.price}"></c:out></td>
<td><img src="${pagecontext.request.contextPath}/resources/${p.imgName}" height="50px width="50px"></td>
<td><c:out value="${p.qty*p.price}"/></td>
<td class="span2">
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<a class="btn btn-danger" role="button" href="<c:url value="/deletePcart/${p.cartId}"/>">Delete cart</a>
</td>
</tr>
</c:forEach>
<tr>
<td>
<c:set  var="gtot" value="${gtot+p.price*p.qty }"></c:set>
<span class="col-lg-9" align="right"><label>Grand Total</label><c:out value="${gtot}"/></span>
</td></tr>
<tfoot>
<tr>
<td>
<a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath}/index">Continue shopping</a></td>
<td>
<a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath}/Checkout">Checkout</a>

</td>

</tr></tfoot></div></body></html>






















