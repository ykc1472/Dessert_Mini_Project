<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="content/css/loginForm.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	<c:if test="${!empty mesg}">
		alert("${mesg}");
		<c:remove var="mesg" />
	</c:if>
	
	$(document).ready(function(){
		$("form").on("submit", function(event){
			if($("#userid").val().length == 0){
				alert("ID를 입력해주세요.");
				$("#userid").focus();
				event.preventDefault();
			} else if ($("#userpw").val().length == 0){
				alert("PW를 입력해주세요.");
				event.preventDefault();
				$("#userpw").focus();
			}
		})
	})
</script>

<div align="center" class="content">
	<form action="loginAction" method="get">
		<table border="1">
			<tr>
				<td><input type="text" name="userid" id="userid"></td>
				<td rowspan="2"><input type="submit" value="로그인" id="submit"></td>
			</tr>
			<tr>
				<td>
					<input type="text" name="userpw" id="userpw">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<a href="MemberIdSearchUIServlet" class="login">아이디찾기</a> &nbsp;/&nbsp; <a href="MemberPasswdSearchUIServlet" class="login">비밀번호 찾기</a>
				</td>
			</tr>
		</table>
	</form>
</div>