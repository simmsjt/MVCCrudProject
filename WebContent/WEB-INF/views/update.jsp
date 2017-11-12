<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Cigar</title>
</head>
<body>
	<h3>Enter data about your giraffe</h3>
	<form:form action="updateCigar.do" method="POST" modelAttribute="cigar">
		Name: <form:input path="name" />
		<br>
		Brand: <form:input path="brand" />
		<br>
		Amount: <form:input path="amount" />
		<br>
		Amount: <form:input path="amount" />
		<br>
		Amount: <form:input path="amount" />
		<br>
		wrapper: <select name="wrapper">
			<c:forEach items="${wrapperValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>
			shape: <select name="shape">
			<c:forEach items="${shapeValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>
		<form:hidden path="name" />
		<input type="submit" value="Update">
	</form:form>
</body>
</html>