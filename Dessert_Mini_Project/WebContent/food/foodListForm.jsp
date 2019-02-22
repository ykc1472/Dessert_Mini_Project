<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div align="center">
		<table border="1">
		
			<tr>
				<c:forEach var="i" begin="1" end="9">
				<td>
					<table onclick="location.href='foodFrom'" border="1">
						<tr>
							<td>이미지</td>
						</tr>
						<tr>
							<td>타이틀</td>
						</tr>
						<tr>
							<td>설명</td>
						</tr>
						<tr>
							<td>가격</td>
						</tr>
					</table>
				</td>
			<!-- 조건문 체크 -->
				<c:if test="${i%3 == 0}">
				<tr>
					<td>&nbsp;</td>
				</tr>
				</c:if>
						
				
				</c:forEach>
			</tr>
		</table>
	</div>
