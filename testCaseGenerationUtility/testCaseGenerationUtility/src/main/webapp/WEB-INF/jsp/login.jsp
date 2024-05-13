<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" href="<c:url value="/resources/Style.css" />">
<script src="<c:url value="/resources/noBack.js" />"></script>


</head>

<body >

<h2>
<font color="red">
${error}
</font></h2>

<form action="registration" method="get" class="login">
<button class="btn btn-md btn-warning btn-block" type="Submit">Go To Registration Page</button>
</form>

       <h1 class="login-title">LOGIN</h1>
  <p><span class="fontawesome-user"></span>
<form action="login" method="post" class="form-signin">
<input type="text" name="name" placeholder="User Name" class="login-input" autofocus>    

<input type="password" name="password" class="login-input" placeholder="Password">

<!-- <tr><td><input type="checkbox" name="remember"?></td><td>RememberMe</td></tr> -->
 
<input type="submit" value="login" class="login-button">

</form>
</body>
</html>