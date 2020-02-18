<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Surname</th>
    <th>User Name</th>
    <th>Password</th>
  </tr>
  <form:form modelAttribute="user" method="post" >
    <tr>
      <form:input type="hidden" path="id" value="${id}" />
      <td ><form:input type="text" path="name" value="${name}" /></td>
	  <td ><form:input type="text" path="surname" value="${surname}" /></td>
	  <td ><form:input type="text" path="username" value="${username}" /></td>
	  <td ><form:input type="text" path="password" value="${password}" /></td>
	  <td ><input type="submit" value="Kaydet" /></td>
    </tr>
	</form:form>
</table>
</body>
</html>