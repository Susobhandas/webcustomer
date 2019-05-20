<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello customer



<table>

<tr>
<th>Customer-Id</th>
<th>First-Name</th>
<th>Last-Name</th>
<th>Email-Id</th>
</tr>
<c:forEach var="t" items="${customerlist}">

<tr>
<td>${t.id}</td>

<td>${t.firstname}</td>
<td>${t.lastname}</td>
<td>${t.email}</td>
</tr>
</c:forEach>

</table>


</body>
</html>