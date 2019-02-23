<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div align="center">
		<table border="1">
			
			<tr>
				<c:forEach var="dto" items="${flist.foodlist}" varStatus="i">
				<td>
					<table onclick="location.href='foodForm?fcode=${dto.fcode}'" border="1">
						<tr>
							<td><img src="content/image/food/${dto.fmainimage}.jpg"></td>
						</tr>
						<tr>
							<td><b>${dto.ftitle}</b></td>
						</tr>
						<tr>
							<td>${dto.content}</td>
						</tr>
						<tr>
							<td>${dto.fprice}</td>
						</tr>
					</table>
				</td>
				<c:if test="${i.count % 3 == 0 }">
					<tr>
						<td colspan="3">&nbsp;</td>
					</tr>
				</c:if>
				
				</c:forEach>
			</tr>
		</table>
	</div>
