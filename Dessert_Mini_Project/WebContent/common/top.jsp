<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<p class = "font">
<!-- 여기 껍데기로 보내기 빼고 바로 jsp로 보냈음 -->
<c:choose>
	<c:when test="${dto != null }">
		<a href="LogoutServlet" class="menuTop">로그아웃</a>&nbsp;&nbsp;
		<a href="" class="menuTop">장바구니</a>&nbsp;&nbsp;
		<a href="" class="menuTop">나의정보</a>&nbsp;
	</c:when>

	<c:otherwise>
		<a href="loginForm.jsp" class="menuTop">로그인</a>&nbsp;&nbsp;
		<a href="MemberAdd" class="menuTop">회원가입</a>&nbsp;
	</c:otherwise>
</c:choose>

</p>