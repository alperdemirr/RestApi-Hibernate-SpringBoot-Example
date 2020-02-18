<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form:form modelAttribute="user"  method="post">	
			Please enter your name 		
			<form:input  path="name" /><br>		
		
			Please enter your surname
			<form:input  path="surname" />
				Please enter your username
			<form:input  path="username" />
				Please enter your password
			<form:input  path="password"/>
			<input type="submit" value="submit">			
		
		</form:form>
</body>
</html>