<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cigar Added</title>
</head>
<body>
	<h3>Fill in the form to add a cigar</h3>
	<a href="home.do"> Go back to your humidor.</a>
	<form:form action="addCigar.do" method="POST" modelAttribute="cigar">
			brand: <form:input path="brand" />
			 name: <form:input path="name" />
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
			amount: <form:input path="amount" value="1"/>
		<br>
		<input type="submit" value="Add a Cigar">
	</form:form>
</body>
</html>