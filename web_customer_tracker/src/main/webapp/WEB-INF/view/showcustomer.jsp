<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/abc.css" type="text/css" rel="stylesheet">

</head>
<body>
<div>
<h1>Hello customer</h1><br>
</div>
<div class="search-container">
    <form:form action="SearchCustomer" >
      <input type="text" placeholder="Search.." name="search">
      <button id="searching" type="submit" value="Submit">Submit<i class="fa fa-search"></i></button>
    </form:form>
  </div>
  <br><br>
<div>

<input type="button" value="Add Customer" class="btn" onclick="window.location.href='AddCustomer';return false;">
&nbsp;&nbsp;<input type="button" value="Refresh" class="btn" onclick="window.location.href='Customerdetails';return false;">

<br><br>
</div>
<div id="main">

<table>

<tr>
<th>Customer-Id</th>
<th>First-Name</th>
<th>Last-Name</th>
<th>Email-Id</th>
<th id="col">Action</th>
</tr>
<c:forEach var="t" items="${customerlist}">

<tr>
<td>${t.id}</td>

<td>${t.firstname}</td>
<td>${t.lastname}</td>
<td>${t.email}</td>

<c:url var="updatelink" value="/Customer/UpdateCustomerForm">

<c:param name="customerid"  value="${t.id}"></c:param>
</c:url>
<c:url var="deletelink" value="/Customer/DeleteCustomer">

<c:param name="customerid"  value="${t.id}"></c:param>

</c:url>


<td><a href="${updatelink}" >Update</a></td>
<td><a href="${deletelink}">Delete</a></td>

</tr>
</c:forEach>

</table>

</div>
</body>
</html>