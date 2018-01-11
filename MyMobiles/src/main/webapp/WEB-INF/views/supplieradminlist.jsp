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
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"rel="stylesheet">
</head>
<body>
	<h2>SupplierAdminList</h2>
	<form action="supplierAdminList.jsp" method="post">
			<table style width: "50%">
				<tr>
					<td> SI no</td>
					<td><input type="text" name="SI-No" /></td>
				</tr>
				
				<tr>
					<td> SID</td>
					<td><input type="text" name="SID" /></td>
				</tr>
	
	
					<tr>
					<td> Supplier Name</td>
					<td><input type="text" name="Supplier Name" /></td>
				</tr>
	
        </table>
	<input type="Button" value="save" />
	<input type="Button" value="cancel" />
			
	</form>
	</body>
	</html>
	
<table class="table table-hover" id="apl" class="display" border="2" width="80" align="center">
<tr>
  <th>SI No</th>
	<th>SID</th>
	<th>Supplier Name</th>
	<th class="span2">Action</th>
	</tr>
	<c:forEach var="p" varstatus ="st" items="${supplist }"></c:forEach>
	<tr>
	<td><c:out value="${st.count }"></c:out></td>
		<td><c:out value="${c.sid }"></c:out></td>
		<td><c:out value="${c.SupplierName }"></c:out></td>
	<td><c:set var="contextRoot"> value="${pageContext.request.contextPath}"
		<a href="#" class="btn btn-info" role="button"></a>
		<a href="#" class="btn btn-danger" role="button"></a></c:set>
		</td>
		</tr>*//
	
</table>
</body>
</html>
	
	
	
	
	
	