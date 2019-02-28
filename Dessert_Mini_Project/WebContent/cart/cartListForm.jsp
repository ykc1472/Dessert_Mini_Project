<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript">
    $(document).ready(function(){
    	
   });
</script>
<div align="center">
<table width="90%" cellspacing="0" cellpadding="0" border="0">

	<tr>
		<td height="30">
	</tr>

	<tr>
		<td colspan="5" class="td_default">&nbsp;&nbsp;&nbsp; <font
			size="5"><b>- 장바구니-</b></font> &nbsp;
		</td>
	</tr>

	<tr>
		<td height="15">
	</tr>

	<tr>
		<td colspan="11">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<tr>
		<td height="10">
	</tr>

	<tr>
		<td class="td_default" align="center" width="30">
		<input type="checkbox" name="allCheck" id="allCheck"></td>
		<td align="center"><strong>전체<br>선택</strong></td>
		<td class="td_default" align="center"><strong>상품</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
		<td class="td_default" align="center"><strong>판매가</strong></td>
		<td class="td_default" align="center" colspan="2"><strong>수량</strong></td>
		<td class="td_default" align="center"><strong>합계</strong></td>
		<td colspan="3"></td>
	</tr>

	<tr>
		<td height="11">
	</tr>
	
	
	
	<tr>
		<td colspan="11">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>

	<form name="myForm" method="post">
	<c:set var = "total" value = "0" />
	<c:forEach var="goods" items="${cartList}" varStatus="i">
		<tr>
			<td class="td_default" width="80" colspan="2" align="center">
			<!-- checkbox는 체크된 값만 서블릿으로 넘어간다. 따라서 value에 삭제할 num값을 설정한다. -->
			<input type="checkbox" name="check" id="check_${i.count}" class="check" value="${i.count}"></td>
			<th class="td_default" width="80">${i.count}
			<input type="hidden" value="${goods.fcode}" id="code_${i.count}">
			</th>
			<td class="td_default" width="80"><img src="content/image/food/${goods.fmainimage}.jpg" border="0" align="center" width="80" /></td>
			<td class="td_default" width="300" style='padding-left: 30px'>
			<b>[${goods.categoryname}]</b>${goods.ftitle}<br>
			${goods.content}<br>
			<font size="2" color="#665b5f">옵션  ${goods.foption}: ${goods.optionname}(${goods.optionprice})
			[판매 가능 재고 : ${goods.stock}]
			</font></td>
			<td class="td_default" align="center" width="110" id="gPrice_${i.count}">
			<span  id = "price1"><fmt:formatNumber value='${goods.optionprice + goods.fprice}' pattern='###,###,###' /></span>원
			</td>
			<td class="td_default" align="center" width="90"><input
				class="input_default" type="text" name="cartAmount"
				id="cartAmount_${i.count}" style="text-align: right" maxlength="3"
				size="2" value="${goods.amount}"></input></td>
			<td><input type="button" value="수정" class="update" data-num="${i.count}"/></td>
			<td class="td_default" align="center" width="80"
				style='padding-left: 5px'><span id="sum_${i.count}" class="sum">
				<fmt:formatNumber value='${(goods.optionprice + goods.fprice) * goods.amount}' pattern='###,###,###' />원
				</span></td>
			<td><input type="button" value="주문" class="orderBtn" data-xxx="${i.count}"></td>
			<td class="td_default" align="center" width="30"
				style='padding-left: 10px'>
				<input type="button" value="삭제" id="xx${i.count}"
				 class="delBtn" data-xxx="${i.count}"></td>
			<td height="10"></td>
		</tr>
		<tr>
			<td colspan="11"><hr></td>
		</tr>
	<c:set var= "total" value="${total + (goods.fprice + goods.optionprice) * goods.amount}"/>
	</c:forEach>
		<tr>
			<td colspan="9" align="right"><span id = "totalResult"></span> // <span id = "selectTotalResult">선택물품 총 가격 : 0</span></td>
		</tr>
	</form>
	<tr>
		<td colspan="10">
			<hr size="1" color="CCCCCC">
		</td>
	</tr>
	<tr>
		<td height="30">
	</tr>

	<tr>
		<td align="center" colspan="5"><a class="a_black"
			href="#" id="orderAllConfirm"> 전체 주문하기 </a>&nbsp;&nbsp;&nbsp;&nbsp; 
			<a class="a_black" href="#" id="delAllCart"> 전체 삭제하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a class="a_black" href="index.jsp"> 계속 쇼핑하기 </a>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td height="20"></td>
	</tr>

</table>
</div>
    