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
<title>Humidor</title>
</head>
<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 boxy">
   		<a href="add.do"> add a cigar</a><br>
		<c:forEach var="c" items="${list}">
			${c.shape} : ${c.wrapper} : ${c.name} : ${c.brand} : ${c.amount} 
			<div class="row"><div class ="col-sm-6 .col-sm-offset-3">
			<form action="deleteCigar.do" method="post"><input type="submit" value="Smoke">
			<input type="hidden" name="id" value="${c.id}">
			</form>
			</div>
			<div class ="col-sm-6">
			<form method="post" action="update.do">
				<input type="submit" value="Update">
				<input type="hidden" name="id" value="${c.id}">
			</form> </div></div>
			<hr>
		</c:forEach>
    </div>
    <div class="col-md-4"></div>
</div>
	
</body>
</html>