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
<jsp:include page="/WEB-INF/views/Register.jsp"></jsp:include>

<h2>Register.jsp</h2>
<form action="Register.jsp" method="post">
			<table style="width: 50%">
				<tr>
					<td> Name</td>
					<td><input type="text" name="first_name" /></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>role</td>
					<td><input type="text" name="role" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr>
				
				<tr>
					<td>enabled</td>
					<td><input type="text" name="enable" /></td>
				</tr>
				
				</table>
				
			<input type="submit" value="Submit" />
			
			<input type="reset" value="reset" /></form>
			
		</body>	
			
			
			</html>
			
			
			
			
