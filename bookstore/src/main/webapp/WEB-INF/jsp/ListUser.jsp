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
	  <c:forEach items="${users}" var="user">
	    <tr>
	      <td ><c:out value="${user.name}" /></td>
	      <td><c:out value="${user.surname}" /></td>
	      <td ><c:out value="${user.username}" /></td>
	      <td><c:out value="${user.password}" /></td>
	      <td>
	      	<form action="update" method="get">
		      	<input type="hidden" name="id" value="${user.id}"/>
		        <input type="submit" value="Güncelle" />
			</form>
	      </td>
	            <td>
	      	<form action="delete" method="get">
		      	<input type="hidden" name="id" value="${user.id}"/>
		        <input type="submit" value="Sil" />
			</form>
	      </td>
	    </tr>
	  </c:forEach>
	</table>
	
</body>
</html>