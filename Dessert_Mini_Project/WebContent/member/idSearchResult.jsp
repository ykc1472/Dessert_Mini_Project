<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>귀하의 아이디 입니다.</h1>

	<% String userid = (String)request.getAttribute("userid2"); %>

	<%=userid %>

</body>
</html>