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

<div align="center" class="content">
	<form action="PasswdCheckServlet" method="get">
		<table>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td align="center" width="100">&nbsp;아이디&nbsp;</td>
				<td align="center" width="200">&nbsp;${userid}&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			
			<tr>
				<td align="center">&nbsp;비밀번호&nbsp;</td>
				<td align="center">&nbsp;${ userpw}&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="loginForm.jsp" class="login">로그인 화면으로 이동</a></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
		</table>
	</form>
</div>