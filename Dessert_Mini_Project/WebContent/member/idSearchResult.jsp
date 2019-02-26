<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
	$(document).ready(function(){
		$("#login").on("click", function(event){
			location.href="loginForm.jsp";
		})
	})	
</script>

<div align="center">
	<table>
		<tr>
			<td>
				<hr>
					<h1>귀하의 아이디는 ${userid2} 입니다.</h1>
				<hr>
			</td>
		</tr>
		
		<tr>
			<td>아이디 전체는 메일에서 확인해 주시기 바랍니다.</td>
		</tr>
		<tr>
			<td align="center"><button id= "login">로그인</button></td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		
	</table>
</div>
	
