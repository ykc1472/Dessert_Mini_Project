<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#continu").on("click", function(event){
		history.back(-1);
	})
	
	$("#cartlist").on("click", function(event){
		location.href="cartList";
	})
})
</script>
<div align="center">
	<table>
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><b>장바구니에 ${success}개의 제품이 추가되었습니다.</b></td>
		</tr>
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		<tr>
			<td align="center"><button id="continu">계속 쇼핑하기</button></td>
			<td align="center"><button id="cartlist">장바구니 확인하기</button></td>
		</tr>
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		
	</table>
</div>		
