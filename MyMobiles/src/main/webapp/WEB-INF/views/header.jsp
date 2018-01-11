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
<nav id="navbar-blue" class="navbar navbar-inverse navbar-static-top" role="navigation">
<div class="nav-navbar-nav">
<button type="button" class="navbar-toggle" data-toggle="offcanvas" data-target="#mynavmenu" data-canvas="#navdemo">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
</div>
<div class="collapse navbar-collapse" id="#navDemo">
 <ul class="nav navbar-nav">
<li><a href="index">HOME</a>
<li><a href="Contact"><i class="fa fa adrdress-book" aria-hidden="true"></i></a></li>
<li><a href="productlist">product List</a></li>
<li><a href="Adding">Admin</a>
<li class="dropdown"><a class="drop-down toggle" data-toggle="dropdown"
href="#">Admin List<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="${pagecontext.request.contextpath}/productList/product"></a></li>
<li><a href="${pagecontext.request.contextpath}/SupplierList/Supplier"></a></li>
<li><a href="${pagecontext.request.contextpath}/CategoryList/Category"></a></li>
</ul>
<li><a href="GoToRegister">Register</a>
</li>
</ul>
<li class="dropdown"><a class="drop-down toggle" data-toggle="dropdown" href="#">
Category choice<span class ="caret"></span>
<ul class="dropdown-menu">
<c:forEach var="catval" items="${catList}">
<li><a href="${pagecontext.request.contextpath}/productCustList?cid=${catVal.cid">${catVal.name}</a>
</c:forEach>

</ul>

</li>
</div>
</nav></body></html>