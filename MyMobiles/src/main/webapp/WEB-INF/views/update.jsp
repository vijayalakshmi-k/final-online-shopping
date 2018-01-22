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
<jsp:inssclude page="/WEB-INF/views/update.jsp"></jsp:include>

<div class="container">
<c:url value="productUpdate" var="pru"></c:url>
<form method="post" action="productUpdate" enctype="multipart/form data">
<span id="reauth-email" class="reauth-email"/>
<input type="hidden" name="pid" value="$(prod.pid)">
<h4 class="input-title">Product Name</h4><br><br>
<input value="$(prod.pname)" type="text" name="pName" required/><br>

<h4 class="input-title">Product Description</h4><br><br>
<input value="$(prod.description)" type="text" name="pdescription" required/><br>
<h4 class="input-title">Product Price</h4><br><br>
<input value="$(prod.pPrice)" type="text" name="pPrice" required/><br>
<h4 class="input-title">Product Stock </h4><br><br>
<input value="$(prod.pStock)" type="text" name="pStock" required/><br>


<div class="form-group">
<table>
<tr>

<td>Select Supplier</td>
<td><select class="form-control" name="pSupplier" required>
<option value="">!---Select Supplier---</option>
<c:forEach items="${satList}" var="sat">
<option value="${sat.sid} ">sat.supplierName</option>
</c:forEach>
</select>
</table>
</div>

<div class="form-group">
<table>
<tr>

<td>Select Category</td>
<td><select class="form-control" name="pCategory" required>
<option value="">!---Select Category---</option>
<c:forEach items="${catList}" var="cat">
<option value="${cat.cid} ">cat.CategoryName</option>
</c:forEach>
</select>
</table>
</div>

<div class="fileinput fileinput-new" data provides="fileinput">
<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="image/*"></td><!-- -browse & upload -->
</div>
<br><br><br>  

<button class="btn-btn-lg btn-primary" type="submit">save</button>
<button class="btn-btn-lg btn-warning" type="reset">cancel</button>
</form>
</div>
</body>
</html>