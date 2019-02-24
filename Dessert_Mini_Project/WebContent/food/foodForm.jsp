<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script type="text/javascript">
	$(document).ready(function(){

		// 옵션 선택에 따라 테이블을 추가해주는 부분
		$("#options").on("change", function(event){
			if($(this).val() != '#'){
				var select = Number.parseInt($(this).val());
				var tegs = $("#result").html();
				if($("#"+select).attr("id") != select){
					<c:forEach var="foodinfo" items="${foodinfoList}">
						if(${foodinfo.foption} == select){
							// tegs = $("#result").html();
							tegs += "<table border='1' id='${foodinfo.foption}'><tr><td colspan='2'>옵션 ${foodinfo.foption}: ${foodinfo.optionname}(+<fmt:formatNumber value='${foodinfo.optionprice}' pattern='###,###,### 원' />)"
						    tegs += "</td><td rowspan='3'><input type='button' value='옵션삭제' data-delete='${foodinoList.foption}'></td>";
							tegs += "</tr><tr><td>수량<input type='text' name='amount' value='1' data-amount='${foodinfo.foption}'> </td><td><img src='content/image/order/down.PNG' data-down='${foodinfo.foption}'>&nbsp;";
							tegs += "<img src='content/image/order/up.PNG' data-up='${foodinfo.foption}'></td></tr><tr><td><span style='font-size: 14px; color: gray;'><fmt:formatNumber value='${foodinfo.fprice}' pattern='###,###,### 원' /> x <span data-amount='${foodinfo.foption}'>1</span>개</span></td><td>";
							tegs += "<span style='font-size: 20px; color: red; font-weight: bold;'><fmt:formatNumber value='${foodinfo.fprice+foodinfo.optionprice}' pattern='###,###,### 원' /></span>"
							tegs += "<input type='hidden' name='foption' value='${foodinfo.foption}' data-foption='${foodinfo.foption}'><input type='hidden' name='fcode' value='${foodinfo.fcode}' data-fcode='${foodinfo.foption}'></td></tr></table><br>"
							$("#result").html(tegs);
						}
					</c:forEach>
				} else{
					alert("이미 선택하신 옵션입니다.");
				}
			}
		})
		// 옵션 선택에 따라 테이블을 추가해주는 부분
		
		$("body").on("click", "[data-up]" , function(event){
			var amount = $("[data-amount="+$(this).attr("data-up")+"]").val();
			$("[data-amount="+$(this).attr("data-up")+"]").val(++amount);
			check($("[data-amount="+$(this).attr("data-up")+"]"));
		})
		
		$("body").on("click", "[data-down]" , function(event){
			var amount = Number.parseInt($("[data-amount="+$(this).attr("data-down")+"]").val());
			if (amount - 1 != 0){
				$("[data-amount="+$(this).attr("data-down")+"]").val(--amount);
			}
		})
		
		$("body").on("change", "[data-amount]" , function(event){
			check(this);
		})
		
		function check(select){
			$.ajax({
				type : "POST",
				url : "checkStock",
				dataType : "text",
				data : {
					fcode : $("[data-fcode='"+$(select).attr("data-amount")+"']").val(),
					foption : $("[data-foption='"+$(select).attr("data-amount")+"']").val()
				},
				success : function(Data, status, xhr) {
					if(Data.trim() == "잘못된 접근입니다."){
						alert(Data.trim());
					}else{
						var stock = Number.parseInt(Data.trim());
						if (Number.parseInt($("[data-amount='"+$(select).attr("data-amount")+"']").val()) > stock){
							$("[data-amount='"+$(select).attr("data-amount")+"']").val(stock);
							alert("재고량 이상을 주문할 수 없습니다. 재고 : " + stock);
						}
					}
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
			})
		}
	})
	
</script>
<body>
				
	<div>
		<div align="center">
			<form>
				<table border="1">
					<tr>
						<td rowspan="6"><img src="content/image/food/${foodinfoList[0].fmainimage}.jpg" class="goods" /></td>
						<td>제품명</td>
						<td><b>[${foodinfoList[0].categoryname}]</b> ${foodinfoList[0].ftitle}</td>
					<tr>
					<tr>
						<td>가격</td>
						<td><fmt:formatNumber value="${foodinfoList[0].fprice}" pattern="###,###,### 원" /></td>
					</tr>
					<tr>
						<td>옵션</td>
						<td>
							<select id="options">
								<option value="#">옵션을 선택하세요.</option>
								<c:forEach var="foodinfo" items="${foodinfoList}">
									<option value="${foodinfo.foption}">[옵션 ${foodinfo.foption} : ${foodinfo.optionname} 
									(+<fmt:formatNumber value="${foodinfo.optionprice}" pattern="###,###,### 원" />)] /
									재고 : ${foodinfo.stock} 개</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>정보</td>
						<td>
							<!-- 여기에 옵션 목록 추가 -->
							<div id="result">
							</div>
							<!-- 여기까지  -->
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" id="order" value="주문하기"> <input type="submit" id="cart" value="장바구니 추가">
						</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<img src="content/image/food/A08_1.jpg" class="goods" />
						</td>
				</table>
			</form>
		</div>
	</div>
</body>
