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

		<form action="user" method="post">

			Please enter your username 		
			<input type="text" name="userName" /><br>		
		
			Please enter your password
			<input type="text" name="password"/>
			
			<input type="submit" value="submit">			
		
		</form>
		${successMessage}
		<br>

</body>
</html>