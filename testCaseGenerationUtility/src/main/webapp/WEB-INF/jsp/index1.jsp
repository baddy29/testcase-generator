<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="commons.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid" >
    <div class="navbar-header">
    <a class="navbar-brand" href="#"></a>
    
    </div>
 
    <ul class="nav navbar-header" >
    <select name="Item1">
    <option value="1">Subitem</option>
    <option value="2">Subitem</option>
  	</select>
    
    <select name="Item2">
    <option value="1">Subitem</option>
    <option value="2">Subitem</option>
    </select>
   <select name="Item3">
    <option value="1">Subitem</option>
    <option value="2">Subitem</option>
	</select>
	 </ul>
	 <ul class="nav navbar-nav navbar-right">
	 <h4><a href="logout">Logout</a></h4>
	 </ul>
 </div>
 </nav>
 <h1><center>Welcome</center></h1>
 
</body>
</html>
