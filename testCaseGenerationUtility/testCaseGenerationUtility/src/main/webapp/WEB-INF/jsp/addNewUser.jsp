<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %> 
     <%@ taglib uri="http://www.springframework.org/tags" prefix="msg" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<form action="/login" method="get">
<button class="btn btn-md btn-warning btn-block" type="Submit">Go To login Page</button>
</form>

<s:form action="submitdetails" modelAttribute="user">
<table border="5" align="center" >



<%-- <tr><td><msg:message code="role.customer_code"/></td><td><s:input path="username" /></td></tr> --%>
<tr>
<td>Username<s:input path="name" /></td></tr>
<tr><td>Password </td><td><s:input path="password" />
<%-- <tr><td>Enabled</td><td><s:input path="active" /> --%>

<%-- <tr><td>User Role </td></tr>
<th><s:radiobutton path="role.roleName" value="ROLE_USER"/>USER
<th><s:radiobutton path="role.roleName" value="ROLE_ADMIN"/>ADMIN --%>
<tr><td></td><td><input type="submit" value="submitdetails" /></td></tr>
</table>
</s:form>
</body>
</html>