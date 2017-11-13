<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Humidor</title>
</head>
<body>
	<a href="add.do"> add a cigar</a>
	<c:forEach var="c" items="${list}">
		${c.shape} : ${c.wrapper} : ${c.name} : ${brand} : ${c.amount} 
		<form action="deleteCigar.do" method="post"><input type="submit" value="Smoke"><input type="hidden" name="cigarName" value="${c.name}"></form>
		<form method="post" action="update.do">
			<input type="submit" value="Update">
			<input type="hidden" name="name" value="${c.name}">
		</form> 
		<hr>
	</c:forEach>
</body>
</html>