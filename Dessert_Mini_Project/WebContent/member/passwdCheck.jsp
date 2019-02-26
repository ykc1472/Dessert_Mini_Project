<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="css/loginForm.css">

<script type="text/javascript">
	<c:if test="${!empty mesg}">
		alert("${mesg}");
		<c:remove var="mesg" />
	</c:if>
</script>
	
<script type="text/javascript">
	$(document).ready(function(){
		$("form").on("submit", function(event){
			if($("#pwcheck").val().length == 0){
				alert("인증번호를 입력해주세요.");
				$("#pwcheck").focus();
				event.preventDefault();
			} else if ($("#pwcheck").val().length == 0){
				alert("인증번호를 입력해주세요.");
				event.preventDefault();
				$("#pwcheck").focus();
			}
		});
	});
</script>

<div align="center" class="content">
	<form action="PasswdCheckServlet" method="get">
		<table>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td>인증번호</td>
				<td><input type="text" name="pwcheck" id="pwcheck"></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="인증하기"></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
						
		</table>
	</form>
</div>