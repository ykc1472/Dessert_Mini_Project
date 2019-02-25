<%@page import="com.dto.OrderDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

${orderList }
<br>
${orderCount}
<br>
${orderUserInfo }<br>
${orderList[0].payMethod}
<table width="70%" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td><b>주문완료</b></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center"><b>주문해주셔서 감사합니다.</b></td>
	</tr>

	<tr>
		<td height="7">
	</tr>

	<tr>
		<td class="td_default" align="center"><span style="color:blue;"><b>${orderUserInfo.userid } (${orderUserInfo.username})</b></span> 님의
			<span style="color:red;"><b>${orderCount}개 </b>의 제품이 안전하게 처리되었습니다.</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>상품 및 배송정보</b>
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 받으시는 분</td>
					<td class="td_default" height="35">${orderUserInfo.username}고객님</td>
				</tr>
				<tr>
					<td class="td_default" height="35"> 주소</td>
					<td class="td_default" height="35"> ${orderList[0].addr_post}<br>
						${orderList[0].addr_f }&nbsp;${orderList[0].addr_l }
					</td>
				</tr>
				
				<tr>
					<td class="td_default" height="35"> 휴대전화</td>
					<td class="td_default" height="35"> ${orderList[0].phone}</td>
				</tr>
			</table>
	</tr>
	</td>

	<tr>
		<td height="20">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="50" height="35" align="center"><strong>주문번호</strong>
					<td width="250" class="td_default" height="35" align="center" colspan="2"><strong>상품명</strong></td>
					<td width="100" class="td_default" height="35" align="center"><strong>판매가</strong></td>
					<td class="td_default" width="50" height="35" align="center"><strong>수량</strong></td>
					<td class="td_default" width="100" height="35" align="center"><strong>합계</strong></td>
				</tr>

				<c:set var = "total" value = "0" />
				<c:forEach items="${orderList}" var="order" varStatus="i">
				
				
				<tr>
					<td height="35" class="td_default">
						<span class="a_default">1</span>
					</td>
					<td height="35" class="td_default">
						<span class="a_default">상품명</span>
					</td>
					<td height="35" class="td_default" align="center">
						<span  id = "price1"></span>원
					</td>
					<td height="35" class="td_default" align="center">
						<span id = "num1">${order.amount }</span>개
					</td>
					<td height="35" class="td_default" align="center">
						<span><fmt:formatNumber value='${(order.fprice + order.optionprice) * order.amount}' pattern='###,###,###' /> 원</span>
					</td>
				</tr>
				<c:set var= "total" value="${total + (order.fprice + order.optionprice) * order.amount}"/>
				</c:forEach>

			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default"><b>결제정보</b></td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td>
			<table width="100%" border="1" style="border-collapse: collapse"
				bordercolor="#CCCCCC">
				<tr>
					<td class="td_default" width="150" height="35"> 결제금액</td>
					<td class="td_default" height="35" align = 'right'> 
					<input type = 'text' id = 'total' value = '${total}' readonly>원
					</td>
				</tr>
				<tr>
					<td class="td_default" width="150" height="35"> 결제수단</td>
					<td class="td_default" height="35" align = 'right'> 
					<span>
						<c:choose>
							<c:when test="${orderList[0].payMethod == 1}">
								신용카드
							</c:when>
							<c:when test="${orderList[0].payMethod == 2}">
								계좌이체
							</c:when>
							<c:otherwise>
								무통장입금
							</c:otherwise>
						</c:choose>
					
					</span>
					</td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td height="40">
	</tr>

	

	<tr>
		<td height="40">
	</tr>

	<tr>
		<td class="td_default" align="center"><a class="a_default"
			href="OrderListDetailServlet?mem_id=guest">주문조회 페이지로 이동</a></td>
	</tr>

	<tr>
		<td height="30">
	</tr>

</table>
