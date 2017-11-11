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
	<!--<form action="addCigar.do" method="post">
		<input type="text" name="name"> 
		<select name="wrapper">
			<c:forEach items="${wrapperValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>
		<select name="shape">
			<c:forEach items="${shapeValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>

		<input type="submit" value="Submit">

	</form>
-->
	<c:forEach var="c" items="${list}">
		${c.shape} : ${c.wrapper} : ${c.name} : ${brand} : ${c.amount}
		<hr>
	</c:forEach>
</body>
</html>