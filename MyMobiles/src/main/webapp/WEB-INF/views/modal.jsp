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
<h2>Register.jsp</h2>
<div class="container">  
  <h2>Modal Example</h2>  
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>  
  <div class="modal fade" id="onload" role="dialog"  aria-labelledBy="mympdal" aria-hidden="true">  
    <div class="modal-dialog modal-lg">  
      
      <div class="modal-content">  
        <div class="modal-header">  
          <button type="button" class="close" data-dismiss="modal">×</button>  
          <h4 class="modal-title">Modal Header</h4>  
        </div>  
        <div class="modal-body">  
          <span>Added successfully!!!!!!!!!</span>
        </div>  
        <div class="modal-footer">  
        <a href="${page context.request.contextpath}/admin/adding" class="btn-btn-primary" role="button">BACK</a>
        </div>  
      </div>  
        
    </div>  
  </div>  
    
</div> 


<script type="text/javascript">
$(document).ready(function(){
	$('#onload').modal('show');
});

</script> 
</body>
</html>  














