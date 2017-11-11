<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Humidor</title>
</head>
<body>
	<form action="addCigar.do" method="post">
		<input type="text" name="name">
		
		
		<input type="submit" value="Submit">
		
	</form>
	
	<c:forEach var="c" items="${list}">
		${c.shape} : ${c.wrapper} : ${c.name}
		<hr>
	</c:forEach>
</body>
</html>