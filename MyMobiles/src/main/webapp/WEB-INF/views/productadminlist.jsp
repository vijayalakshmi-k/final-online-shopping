<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyMobiles</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

<jsp:include page="/WEB-INF/views/productadminlist.jsp"></jsp:include>

	<h2>ProductAdminList</h2>
  <table class="table table-hover" id="apl" class="display" border="2" width="80" align="center"></table>
	<tr>
	<th>SI No</th>
	<th>PID</th>
	<th>Product Name</th>
	<th>Product Supplier</th>
	<th>Product Category</th>
	<th>Description</th>
	<th>Stock</th>
	<th>Price</th>
	<th class="span2">Action</th>
	</tr>
	<c:if test="$ empty prodlist}">
	<tr>
	<td colspan="10" align="center">this list is empty</td></tr>
	</c:if>
	<c:forEach var="p" varstatus="st" items="${prodList }">
	<tr>
		<td><c:out value="${st.count }"></c:out></td>
		<td><c:out value="${p.pid }"></c:out></td>
		<td><c:out value="${p.pname }"></c:out></td>
		<td><c:out value="${p.supplier.SupplierName }"></c:out></td>
		<td><c:out value="${p.category.CategoryName }"></c:out></td> 
		<td class="span3"><c:out value="${p.description }"></c:out></td>
	    <td><c:out value="${p.price }"></c:out></td>
		<td><c:out value="${p.Stock }"></c:out></td>
		<td> <img src="${pagecontext.request.contextpath}/resources/${p.imgname}" height="50px" width="50px"></td>
		<td>< class="span4">   
		<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
		<a  class="btn btn-info"    role="button"  href="${contextroot}/updateprod?pid=<c:out value=/${p.pid}">Edit</a>
		<a  class="btn btn-danger" role="button"  href="${contextroot}/deleteprod?pid=<c:out value=/${p.pid}">Delete</a>
				</td></tr></c:forEach></table>
				</div>
				
</body>
</html>