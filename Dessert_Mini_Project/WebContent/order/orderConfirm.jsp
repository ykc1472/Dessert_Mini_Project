<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript" src="content/js/postAddress.js"></script>	
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#samePost").on("click", function(event){
			if(this.checked){
				$("#orderName").val($("#mname").val());
				$("#postcode").val($("#mpost2").val());
				$("#roadAddress").val($("#maddress1").val());
				$("#jibunAddress").val($("#maddress2").val());
				$("#phone").val($("#mphone").val());
			} else{
				$("#orderName").val("");
				$("#postcode").val("");
				$("#roadAddress").val("");
				$("#jibunAddress").val("");
				$("#phone").val("");
			}
		})
		
		////////////////////////////////////////////////
		
		$('.btn-example').click(function(){
	        var $href = $(this).attr('href');
	        layer_popup($href);
	    });
	    function layer_popup(el){

	        var $el = $(el);        //레이어의 id를 $el 변수에 저장
	        var isDim = $el.prev().hasClass('dimBg');   //dimmed 레이어를 감지하기 위한 boolean 변수

	        isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

	        var $elWidth = ~~($el.outerWidth()),
	            $elHeight = ~~($el.outerHeight()),
	            docWidth = $(document).width(),
	            docHeight = $(document).height();

	        // 화면의 중앙에 레이어를 띄운다.
	        if ($elHeight < docHeight || $elWidth < docWidth) {
	            $el.css({
	                marginTop: -$elHeight /2,
	                marginLeft: -$elWidth/2
	            })
	        } else {
	            $el.css({top: 0, left: 0});
	        }

	        $el.find('a.btn-layerClose').click(function(){
	            isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
	            return false;
	        });

	        $('.layer .dimBg').click(function(){
	            $('.dim-layer').fadeOut();
	            return false;
	        });

	    }
		
		////////////////////////////////////////////////
		
	})
</script>
<div align="center">
<form name="myForm" method="post" action="orderDone">
	<table width="80%" cellspacing="0" cellpadding="0">

		<tr>
			<td height="30">
		</tr>

		<tr>
			<td><b>주문상품 확인</b></td>
		</tr>

		<tr>
			<td height="15">
		</tr>

		<tr>
			<td>
				<hr size="1" color="CCCCCC">
			</td>
		</tr>

		<tr>
			<td height="5">
		</tr>

		<tr>
			<td>
				<table width="100%" cellspacing="0" cellpadding="0">
					<tr>
						<td class="td_default" align="center"><strong>주문</strong></td>
						<td class="td_default" align="center" colspan="2"><strong>상품정보</strong></td>
						<td class="td_default" align="center"><strong>판매가</strong></td>
						<td class="td_default" align="center"><strong>수량</strong></td>
						<td class="td_default" align="center"><strong>가격</strong></td>
					</tr>

					<tr>
						<td colspan="6">
							<hr size="1" color="CCCCCC">
						</td>
					</tr>
					<c:set var = "total" value = "0" />
					<c:forEach items="${orderList}" varStatus="i" var="order">
					<tr>
						<td class="td_default" width="80" align="center">${i.count}
						<input type="hidden" value="${order.foption}" name="foption" id="foption"><input type="hidden" value="${order.fcode}" name="fcode" id="fcode">
						</td>
						<td class="td_default" width="80" align="center"><img src="content/image/food/${order.fmainimage}.jpg" border="0" width="80"></td>
						<td class="td_default" width="500" style="padding-left: 30px">${order.ftitle}
						<br>${order.content}
						<br><font size="2" color="#665b5f">[옵션  ${order.foption}: ${order.optionname}]</font></td>
						<td class="td_default" align="center" width="110"><fmt:formatNumber value='${order.fprice + order.optionprice}' pattern='###,###,###' /> 원
						</td>
						<td class="td_default" align="center" width="90"><input type="text" value="${order.amount}" name="amount" readonly="readonly"></td>
						<td align="right"><b><span style="color: blue; font-size: 15px;"><fmt:formatNumber value='${(order.fprice + order.optionprice) * order.amount}' pattern='###,###,###' /> 원</span></b></td>
						<c:set var= "total" value="${total + (order.fprice + order.optionprice) * order.amount}"/>
					</tr>
					<tr>
						<td colspan="6">
							<hr size="1" color="CCCCCC">
						</td>
					</tr>
					</c:forEach>
					
					<tr>
						<td height="30"></td>
						<td class="td_default" align="right" colspan="3">총 결제 금액 :</td>
						<td class="td_default" align='right' colspan="3"><b><span style="color: red; font-size: 20px;" id="totalPrice"><fmt:formatNumber value='${total}' pattern='###,###,### 원' /></span></b>
							<input type="hidden" name="payment" value="${total}">
						</td>
					</tr>
				</table> 
			<tr>
				<td>
					<hr size="1" color="CCCCCC">
				</td>
			</tr>

		</td>
	</tr><!--  고객 정보 시작-->
		<tr>
		<td height="30">
	
		</tr>

	<tr>
		<td><b>고객 정보</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>


	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						
						이 름
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mname" size="20"
							maxlength="20" value="${orderUserInfo.username}"></input>
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						우편번호
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mpost2" size="4"
							maxlength="6" value="${orderUserInfo.address_post}" readonly></input>
						
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						주 소
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="maddress1" size="35"
							maxlength="200" value="${orderUserInfo.address_f}" readonly></input><br>
						<input class="input_default" type="text" id="maddress2" size="35"
							maxlength="200" value="${orderUserInfo.address_l}" readonly></input>
					</td>
				</tr>
				
				<tr>
					<td height="35" class="td_default">
						휴대전화
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="mphone" size="15"
							maxlength="15" value="${orderUserInfo.phone }"></input>
						
					</td>
				</tr>
			</table>							
		</td>
	</tr>
<!--  고객 정보 끝-->
	<tr>
		<td height="30">
	
		</tr>

	<tr> 
		<td class="td_default">
			 <input type="checkbox" name="same" id="samePost"> 배송지가 동일할 경우 선택하세요.
		</td>
	</tr>
<!--  배송지 정보 시작-->
	<tr>
		<td height="30">
	
		</tr>

	<tr>
		<td><b>배송지 정보</b></td>
	</tr>

	<tr>
		<td height="15">
	
	</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						
						이 름
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="orderName"
							name="orderName" size="20" maxlength="20" value=""></input>
					</td>
				</tr>
				<tr>
					<td height="35" class="td_default">
						
						우편번호
					</td>
					<td height="35" class="td_default">
<!-- 다음주소 시작-->
	<input type="text" name="post" id="postcode" placeholder="우편번호"> 
	<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
	<br>
	<input type="text" name="addr1" id="roadAddress" placeholder="도로명주소">
	<input type="text" name="addr2" id="jibunAddress" placeholder="지번주소">
	<span id="guide" style="color:#999"></span>
<br>
<!-- 다음주소 끝 -->
					</td>
				</tr>
				
				<tr>
					<td height="35" class="td_default">
						
						휴대전화
					</td>
					<td height="35" class="td_default">
						<input class="input_default" type="text" id="phone"
							name="phone" size="15" maxlength="15" value=""></input>
					
					</td>
				</tr>
			</table>							
		</td>
	</tr>
<!--  배송지 정보 끝-->

	<tr>
		<td height="30">
	
		</tr>
	<tr>
		<td><b>결제수단</b></td>
	</tr>

	<tr>
		<td height="15">
	
		</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="0" border="1"
					style="border-collapse:collapse" bordercolor="#CCCCCC">
				<tr>
					<td width="125" height="35" class="td_default">
						<input type="radio" name="payMethod" value="1" checked>신용카드</input>
						
						<input type="radio" name="payMethod" value="2">계좌이체</input>
						
						<input type="radio" name="payMethod" value="3">무통장 입금</input>
					</td>
					
				</tr>
				
			</table>							
		</td>
	</tr>
	
	<tr>
		<td height="30">
	
		</tr>


	<tr>
		<td class="td_default" align="center">
			<input type='button' value='취소' onclick="javascript:history.back()">	
			<input type="submit" value='결제하기' id="orderDone">
		</td>
	</tr>

</table>

</form>
</div>


