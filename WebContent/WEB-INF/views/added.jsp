<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/added.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cigar added</title>
</head>
<body>
	Cigar Input:
	<br>
	Cigar name: ${cigar.name }
	<br> Brand: ${cigar.brand }
	<br> Wrapper Color: ${cigar.wrapper }
	<br> Shape: ${cigar.shape }
	<br> Amount Added: ${cigar.amount }
	<br>

	<p>
		<a href="home.do">Home</a>
	</p>
</body>
</html>