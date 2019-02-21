<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&amp;subset=korean" rel="stylesheet" />
<script type="text/javascript">
	<c:if test="${!empty mesg}">
		alert("${mesg}");
		<c:remove var="mesg" />
	</c:if>
</script>
<div>
	<div class = "font">
		<c:choose>
			<c:when test="${loginInfo != null }">
				<a href="Logout" class="menuTop">로그아웃</a>&nbsp;&nbsp;
				<a href="" class="menuTop">장바구니</a>&nbsp;&nbsp;
				<a href="" class="menuTop">나의정보</a>&nbsp;
			</c:when>
		
			<c:otherwise>
				<a href="loginForm.jsp" class="menuTop">로그인</a>&nbsp;&nbsp;
				<a href="memberForm.jsp" class="menuTop">회원가입</a>&nbsp;
			</c:otherwise>
		</c:choose>
		<div align="center"><img src="content/image/order/mainBanner.jpg" width = "200">
		
		</div>
	</div>
	
</div>
