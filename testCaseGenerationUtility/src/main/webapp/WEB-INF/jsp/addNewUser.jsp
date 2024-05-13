<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %> 
     <%@ taglib uri="http://www.springframework.org/tags" prefix="msg" %>
     <%@include file="commons.jsp" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<form action="login" method="get">
<button class="btn btn-md btn-warning btn-block" type="Submit">Go To login Page</button>
</form>

<s:form action="registration" modelAttribute="user">
<table border="5" align="center" >
<tr>
<input type="text" name="name" placeholder="User Name" class="login-input" autofocus>
</tr>   
<input type="password" name="password" class="login-input" placeholder="Password">

<tr><td></td><td><input type="submit" value="submitdetails" /></td></tr>
</table>
</s:form>
</body>
</html>