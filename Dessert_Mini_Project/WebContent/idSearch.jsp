<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/menu.css">

</head>
<body>
<jsp:include page="common/top.jsp" flush="true" /><br> 
<jsp:include page="common/menu.jsp" flush="true" />
<hr>
<jsp:include page="member/idSearch.jsp" flush="true" />
</body>
</html>