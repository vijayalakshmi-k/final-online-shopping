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
<jsp:include page="/WEB-INF/views/ack.jsp"></jsp:include>
  <h2>OrderForm</h2>
  
      <hr>
      <form method="get" action="order.jsp">
        <table border=1 cellpadding=5>
          <tr>
            <th>Order</th>
            <th>Product</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
  <%
      while (rset.next()) {
        int id = rset.getInt("id");
  %>
          <tr>
            <td><input type="checkbox" name="id" value="<%= id %>"></td>
            <td><%= rset.getString("Product") %></td>
            <td>$<%= rset.getInt("price") %></td>
            <td><%= rset.getInt("qty") %></td>
          </tr>
  <%
      }
  %>
        </table>
        <br>
        <input type="submit" value="Order">
        <input type="reset" value="Clear">
      </form>
      <a href="<%= request.getRequestURI() %>"><h3>Back</h3></a>
  <%
      rset.close();
      stmt.close();
      conn.close();
      }  
  %>
</body>
</html>
  