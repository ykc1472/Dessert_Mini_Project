<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 펑션 기능을 쓰기 위해서는 위의 문장이 필요하다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/menu.css">
<body>

<h1>memberForm</h1>
<div align="right">
	<jsp:include page="common/top.jsp" flush="true" /><br>
</div>
<jsp:include page="common/menu.jsp" flush="true" />
<hr>
<jsp:include page="main/main.jsp" flush="true" />
</body>
</html>