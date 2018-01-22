<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyMobiles</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/adding.jsp"></jsp:include>

<div class="container">
<div class="page-container">
<div class="container">
<div class="row">
<div class="col-md-6">

<div class="panel with-nav-tabs- panel-primary">
<div class="panel-heading">
<ul class="nav-nav-tabs">
<li class="active"><a href="#tab1" data toggle="tab">Category</a>
<li><a href="#tab2" data toggle="tab">Supplier</a>
<li><a href="#tab3" data toggle="tab">Product</a>
</ul>
</div>
<div class="panel-body">
<div class="tab-content">

<div class="tab-panel fade in active" id="tab1">
<form method="post" action="<c:url value="/savesupp"/>" class="form-signin">
<span id="reauth-email" class="reauth-email">
<h4 class="input-title">Supplier Id</h4><br><br>
<input class="form-control" type="number" name="sid" required/>
<h4 class="input-title">Supplier Name</h4><br><br>
<input class="form-control" type="text" name="sname" required/>
</span>
<button class="btn-btn-lg btn-primary" type="submit">save</button>
<button class="btn-btn-lg btn-primary" type="reset">cancel</button>
</form>
</div>


<div class="tab-panel fade in active" id="tab2">
<form method="post" action="<c:url value="/saveCat"/>" class="form-signin">
<span id="reauth-email" class="reauth-email">
<h4 class="input-title">Category Id</h4><br><br>
<input class="form-control" type="number" name="cid" required/>
<h4 class="input-title">Category Name</h4><br><br>
<input class="form-control" type="text" name="cname" required/>
</span>
<button class="btn-btn-lg btn-primary" type="submit">save</button>
<button class="btn-btn-lg btn-warning" type="reset">cancel</button>
</form>
</div>


<div class="tab-panel fade in active" id="tab3">
<form method="post" action="<c:url value="/saveproduct"/>" class="form-signin" enctype="multipart/form-data">
<span id="reauth-email" class="reauth-email">
<h4 class="input-title">Product Id</h4><br><br>
<input class="form-control" type="number" name="pid" required/>
<h4 class="input-title">Product Name</h4><br><br>
<input class="form-control" type="text" name="pname" required/>
<h4 class="input-title">Product Price</h4><br><br>
<input class="form-control" type="number" name="pprice" required/>
<h4 class="input-title">Product Description</h4><br><br>
<input class="form-control" type="text" name="pdescription" required/>
<h4 class="input-title">Product Stock</h4><br><br>
<input class="form-control" type="number" name="pstock" required/>
</span>

<div class="form-group">
<table>
<tr>
<td>Select Supplier</td>
<td>
<select class="form-control" name="psupplier" required>
<option value="">---select Supplier---</option>
<c:forEach items="${satList}" var="sat">${sat.supplierName}</option></c:forEach>
</select>
</table></div>

<div class="form-group">
<table>
<tr>
<td>Select Category</td>
<td>
<select class="form-control" name="pCategory" required>
<option value="">---select Category---</option>
<c:forEach items="${catList}" var="sat">${cat.categoryName}</option></c:forEach>
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
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</body>
</html>























































</div>




</div>
</div>


</div>

</div>


</div>


</div>
