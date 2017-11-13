<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Cigar</title>
</head>
<body>
	
	<div class="boxy">
	<h3>Enter data about your cigar</h3>
	
	<form:form action="updateCigar.do" method="POST" modelAttribute="cigar">
		<div class="row">
		<div class="col-sm-6">
			brand: <form:input path="brand" /></div>
		<div class="col-sm-6">
			 name: <form:input path="name" /></div>
		</div>
		<div class="row">
			<div class="col-md-4">
			wrapper: <select name="wrapper">
			<c:forEach items="${wrapperValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>
		</div>
		<div class="col-md-4">
			shape: <select name="shape">
			<c:forEach items="${shapeValues}" var="entry">
				<option value="${entry}">${entry}</option>
			</c:forEach>
		</select>
		</div>
		<div class="col-md-4">
			amount: <form:input path="amount" value="${amount}" />
			</div>
		</div>
		<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
		<input type="submit" value="Update Cigar">
		</div></div>
	</form:form>
	</div>
</body>
</html>